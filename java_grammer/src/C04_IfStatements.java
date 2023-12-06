public class C04_IfStatements {
//    public static void main(String[] args) {
//    int key = 1234;
//    Scanner sc = new Scanner(System.in);
//    System.out.println("비밀번호를 입력해 주세요.");
//    int pw = sc.nextInt();
//    if(key == pw){
//        System.out.println("문이 열렸습니다.");
//    }else{
//        System.out.println("비밀번호가 틀렸습니다.");
//    }
//    }

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("영문자 하나를 입력해주세요.");
//        char ch = sc.nextLine().charAt(0);
//
//        if (Character.isUpperCase(ch)) {
//            System.out.println("대문자입니다.");
//        } else if (Character.isLowerCase(ch)){
//            System.out.println("소문자입니다.");
//        } else {
//            System.out.println("문자가 아닙니다.");
//        }
//
//        if(ch >='A'&& ch<='Z'){
//            System.out.println("대문자입니다.");
//        } else if(ch >='a'&& ch<='z'){
//            System.out.println("소문자입니다.");
//        } else {
//            System.out.println("문자가 아닙니다.");
//        }
//    }

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        boolean theft = false;
//
//        System.out.println("금액을 입력하세요");
//        int pay = sc.nextInt();
//
//        sc.nextLine();
//        System.out.println("도난카드입니까?");
//        String str = sc.nextLine();
//
//        if(str.equals("yes") || str.equals("예") || str.equals("y")){
//            theft = true;
//        }
//
//        if(1500 <= pay && !theft){
//            System.out.println("남은 잔액은 : "+ (pay - 1500) +"원 입니다.");
//        }else if(1500 > pay){
//            System.out.println("잔액이 "+(1500 - pay)+"원 부족합니다.");
//        }else{
//            System.out.println("도난카드 입니다.");
//        }
//    }

//    public static void main(String[] args) {
//        String answer = "1234";
//        System.out.println("비밀번호를 입력해주세요.");
//        Scanner sc = new Scanner(System.in);
//        String input = sc.nextLine();
//        String result = input.equals(answer) ?
//            "문이 열립니다."
//            :
//            "비밀번호가 틀렸습니다.";
//        System.out.println(result);
//    }

//    public static void main(String[] args) {
//        int myMoney = 10000;
//        int texyFee = 10000;
//        int busFee = 3000;
//        int kickBoardFee = 2000;
//
//        if(texyFee<=myMoney){
//            System.out.println("택시");
//        }else if(busFee<=myMoney){
//            System.out.println("버스");
//        }else if(kickBoardFee<=myMoney){
//            System.out.println("킥보드");
//        }else {
//            System.out.println("도보");
//        }
//        // 범위를 정확히 명시할 것.
//    }


//    public static void main(String[] args) {
//        System.out.println("원하시는 번호를 입력해주세요.");
//        System.out.println("1. 대출 서비스    2. 예금 서비스");
//        System.out.println("3. 적금 서비스    0. 상담사 연결");
//        Scanner sc = new Scanner(System.in);
//        int input = sc.nextInt();
//        switch (input){
//            case 1:
//                System.out.println("대출 서비스입니다.");
//                break;
//            case 2:
//                System.out.println("예금 서비스입니다.");
//                break;
//            case 3:
//                System.out.println("적금 서비스입니다.");
//                break;
//            case 0:
//                System.out.println("상담사 연결을 위해 잠시만 기다려주세요.");
//                break;
//            default:
//                System.out.println("잘못 누르셨습니다.");
//                break;
//        }
//
//    }
}


