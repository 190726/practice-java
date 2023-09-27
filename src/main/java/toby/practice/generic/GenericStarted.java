package toby.practice.generic;

import java.util.List;

public class GenericStarted {
    static class Hello<T>{} //받는 쪽은 type parameter 라고 한다. 인스턴스 생성시점에 파라미터를 사용한다

    static <T> void hello(T t) { // 클래스 레벨뿐만 아니라 메소드 레벨에서도 제너릭을 사용할 수 있다.
        System.out.println(t.toString());
    }

    static void hello2(String str){} //parameter

    public static void main(String[] args) {
        hello("");//argument
        new Hello<String>();//넘어가는 String 을 type arguments(타입인자)라고 한다.

        hello("hello");
        hello(1000);

        /**
         * (1) Generic 의 첫번째 목적은 컴파일 시점에 타입체크!
         *     컴파일 시점에 발견되지 않으면, 런타임 환경에서 발견될 수 밖에 없다(잠재적 장애)
         */
        List<String> samples = List.of("1", "2");

        List resamples = samples; //raw type 을 그대로 사용하지 말것
        List<Integer> numbers = resamples;


    }
}
