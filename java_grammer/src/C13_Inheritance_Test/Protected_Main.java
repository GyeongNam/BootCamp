package C13_Inheritance_Test;

import C13_Inheritance.C1304_Protected_Class;

public class Protected_Main extends C1304_Protected_Class{
    public static void main(String[] args) {
        C1304_Protected_Class pc = new C1304_Protected_Class();
        // public 만 접근가능i
        System.out.println(pc.st4);
        Protected_Main pm = new Protected_Main();
        // 상속 받으면 자식에서 접근가능
        System.out.println(pm.st3);
    }
}
