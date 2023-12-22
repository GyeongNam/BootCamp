package C16_Etc_Class;

public class C1601_Math {
    public static void main(String[] args) {
        // Math.random(); 0.0~1.0미만의 임의 double 형을 반환
        for (int i =0; i<10; i++){
            double random = Math.random();
            System.out.println((int)(random*100));
        }

        // Math.abs() : 절대값 반환
        System.out.println(Math.abs(-5));

        // floor() : 소수점 내림
        System.out.println(Math.floor(5.7));
        // ceil() : 소수점 올림
        System.out.println(Math.ceil(5.7));
        // round() : 소수점 반올림
        System.out.println(Math.round(5.7));

        // max, min
        System.out.println(Math.max(5,8));
        System.out.println(Math.min(5,8));

        // pow(a,b) : 제곱 연산 수행 a의 b승
        System.out.println(Math.pow(2,5));

        // sqrt() : 제곱근 연산 수행
        System.out.println(Math.sqrt(25));

    }
}
