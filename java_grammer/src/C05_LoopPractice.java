import java.util.Arrays;

public class C05_LoopPractice {
//    public static void main(String[] args) {
//        int sum = 0;
//        for(int i = 1; i<20; i++){
//            if(i%2==0){
//                sum += i;
//            }
//        }
//        System.out.println(sum);
//    }
//    public static void main(String[] args) {
//        int n = 1234;
//        int i = 0;
//        int m = 0;
//        while (true){
//            if(n>0){
//                int tmp = n%10;
//                m = m*10 + tmp;
//                n = n/10;
//            }else{
//                break;
//            }
//            i++;
//        }
//        System.out.println(m);
//    }

//    public static void main(String[] args) {
//        int a = 24, b = 36, m, re = 0;
//        if(a>b){
//            m = b;
//        }else{
//            m = a;
//        }
//        for(int i = 1; i<=m; i++){
//            if(a%i==0 && b%i==0){
//                re = i;
//            }
//        }
//        System.out.println(re);
//        int minNum = a/m * b/m * m;
//        System.out.println(minNum);
//    }

    public static void main(String[] args) {
        int[] myArr = {1,5,7,9,10};
        for(int i = 0; i<5; i++){
            System.out.println(myArr[i]);
        }
        for (int i:myArr){
            System.out.println(i);
        }
        for(int i = 0; i<myArr.length; i++){
            myArr[i] += 10;
        }
        System.out.println(Arrays.toString(myArr));
    }
}

