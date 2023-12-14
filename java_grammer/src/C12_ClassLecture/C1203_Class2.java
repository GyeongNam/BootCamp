package C12_ClassLecture;

public class C1203_Class2 {
    public static void main(String[] args) {
        Person p = new Person();
        p.setName("조경남");
        p.setEmail("123412@12");
        p.setPassword("1234");
        p.setAge(30);
        System.out.println(p.getName()+"는"+p.getPassword() +"의 비밀번호로"+ p.getEmail() +"가지고");


        Person p2 = new Person();

//        p2.whoIs();
    }
}
class Person{
    private String name;
    private String email;
    private String password;
    private int age;

    public void whoIs(){
        System.out.println(
                name + " " + email + " " + password+ " " + age + "입니다."
        );
    }

    public void setName(String name) {
        if(name.length() < 10){
            this.name = name;
        }else{
            System.out.println("이름이 너무 깁니다.");
        }

    }

    public void setEmail(String email) {
        if(email.contains("@")){
            this.email = email;
        }else{
            System.out.println("이메일 형식이 아닙니다.");
        }

    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAge(int age) {
        if(age>20){
            this.age = age;
        }else{
            System.out.println("나이가 너무 어립니다.");
        }
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getAge() {
        return age;
    }
}
