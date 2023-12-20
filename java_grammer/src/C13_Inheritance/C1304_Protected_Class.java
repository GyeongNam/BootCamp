package C13_Inheritance;

// public : 프로젝트 전체에서 접근가능
// protected : 패키지를 벗어나더라도 상속관계인 경우 접근 가능
// default : 패키지내에서만 접근가능
// private : 클래스 내에서만 접근가능
public class C1304_Protected_Class {
    private String st1 = "hello 1";
    String st2 = "hello 2";
    protected String st3 = "hello 3";
    public String st4 = "hello 4";
}
