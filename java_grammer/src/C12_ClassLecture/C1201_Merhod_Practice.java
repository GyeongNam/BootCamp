package C12_ClassLecture;

import java.util.Scanner;

public class C1201_Merhod_Practice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("정수를 입력하세요.");
        long num = sc.nextLong();
        if(isPrime(num)){
            System.out.println(num+"은 소수입니다. true");
        }else {
            System.out.println(num+"은 소수가 아닙니다. false");
        }
        isPrimePrint(num);
    }
    public static boolean isPrime(long a){
        if(a<2){
            return false;
        }
        for(int i=2; i<=Math.sqrt(a); i++){
            if(a%i==0){
                return false;
            }
        }
        return true;
    }
    public static void isPrimePrint(long a){
        if(a == 1){
            System.out.println("소수가 아닙니다.");
            return;
        }
        for(int i=2; i<=Math.sqrt(a); i++){
            if(a%i==0){
                System.out.println("소수가 아닙니다.");
                return;
            }
        }
        System.out.println("소수입니다.");
    }
}
