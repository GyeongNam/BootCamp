package C16_Etc_Class;

public class C1605_Enum_Main {
    public static void main(String[] args) {
        EnumStudent s1 = new EnumStudent();
        s1.setName("jo1");
        s1.setClassGrade(ClassGrade.a1);
        EnumStudent s2 = new EnumStudent();
        s1.setName("jo2");
        s1.setClassGrade(ClassGrade.a2);
        EnumStudent s3 = new EnumStudent();
        s1.setName("jo3");
        s1.setClassGrade(ClassGrade.a3);
        // 타입이 여전히 String 타입이므로, 클래스 변수를 사용하지 않을 수 있다.
        EnumStudent s4 = new EnumStudent();
        s4.setName("jo4");
        s4.setRole(Role.GENERAL_USER);
        System.out.println(s4.getRole());
        System.out.println(s4.getRole().getClass());
        // enum 값 내부에는 저장된 순서대로 0부터 index값이 내부적으로 할당
        System.out.println(s4.getRole().ordinal());
    }
}

enum Role{
    // 각 열거형 상수는 콤마로 구분하고, 상수 목록 끝에는 세미콜론으로 마무리
    GENERAL_USER, ADMIN_USER, SUPER_USER
}

class ClassGrade{
    static final  String a1 = "first_grade";
    static final  String a2 = "second_grade";
    static final  String a3 = "third_grade";
}

class EnumStudent{
    private String name;
    private String ClassGrade;
    private Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getClassGrade() {
        return ClassGrade;
    }

    public void setClassGrade(String classGrade) {
        ClassGrade = classGrade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
