public class C1101_Stack_function1 {
    public static void main(String[] args) {
        System.out.println("main start");
        function1();
        System.out.println("main end");
    }
    static void function1(){
        System.out.println("function1 start");
        function2();
        System.out.println("function1 end");
    }
    static void function2(){
        System.out.println("function2 start");

        System.out.println("function2 end");
    }
}
