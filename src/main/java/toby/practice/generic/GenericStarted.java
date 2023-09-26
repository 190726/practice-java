package toby.practice.generic;

public class GenericStarted {
    static class Hello<T>{} //받는 쪽은 type parameter라고 한다.

    static void hello(String str){} //parameter

    public static void main(String[] args) {
        hello("");//argument
        new Hello<String>();//넘어가는 String을 type arguments(타입인자)라고 한다.
    }
}
