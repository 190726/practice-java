package toby.practice.generic;

import javax.print.attribute.IntegerSyntax;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TypeSafeMapTest {

    static class TypeSafeMap{
        Map<Type, Object> map = new HashMap<>();

        <T> void put(TypeReference<T> tr, T value){
            map.put(tr.type, value);
        }

        <T> T get(TypeReference<T> tr) {
            if(tr.type instanceof Class<?>){
                return ((Class<T>)tr.type).cast(map.get(tr.type));
            }else{
                return ((Class<T>)((ParameterizedType)tr.type).getRawType()).cast(map.get(tr.type));
            }
        }

    }

    static class TypeReference<T>{
        Type type;

        public TypeReference() {
            Type superType = getClass().getGenericSuperclass();
            if(superType instanceof ParameterizedType){
                this.type = ((ParameterizedType)superType).getActualTypeArguments()[0];
            }
            else throw new RuntimeException();
        }
    }

    public static void main(String[] args) {
        TypeSafeMap map = new TypeSafeMap();
        TypeReference<List<Integer>> typeReference = new TypeReference<>(){};
        map.put(typeReference, List.of(1, 2, 3));
        System.out.println(map.get(typeReference));
    }
}
