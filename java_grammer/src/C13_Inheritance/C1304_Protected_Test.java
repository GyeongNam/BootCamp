package C13_Inheritance;

public class C1304_Protected_Test {
    public static void main(String[] args) {
        C1304_Protected_Class pc = new C1304_Protected_Class();
        // default 접근 가능
        System.out.println(pc.st2);
        // protected 접근 가능
        System.out.println(pc.st3);
        // public 접근 가능
        System.out.println(pc.st4);
    }
}
