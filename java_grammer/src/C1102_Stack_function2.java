public class C1102_Stack_function2 {
    public static void main(String[] args) {
        System.out.println("main start");
        System.out.println(function1(1));
        System.out.println("main end");
    }
    static int function1(int a){
        System.out.println("function1 start");
        System.out.println("function1 end");
        return function1(a*2);
    }
}
