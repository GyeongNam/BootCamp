package C12_ClassLecture;

public class C1201_Method {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i<=10; i++){
            sum += i;
        }
        System.out.println(sum);

        int total = 0;
        for (int i = 10; i <= 20; i++) {
            total += i;
        }
        System.out.println(total);

        // 중복되는 코드 따로 빼기
        int sumAcc_total = sumAcc(100,200);
        System.out.println(sumAcc_total);

        System.out.println(C1201_Method.sumAcc(1,10));

        // 메서드 구성 요소 : 매개변수, 반환타입, 접근제어자, 클래스 메서드 여부(static)
    }

    // void  = 리턴타입 x
    static int sumAcc(int start, int end){
        int total = 0;
        for (int i = start; i<=end; i++ ){
            total += i;
        }
        System.out.println(total);
        return  total;
    }
}
