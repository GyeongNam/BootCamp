package C14_Interface.BankService;


import java.util.Scanner;

public class BankController {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("계좌번호를 입력해주세요.");
        String num = sc.nextLine();
        BankAccount entity = new BankAccount(num);
        while (true){
            System.out.println("1. 입금");
            System.out.println("2. 출금");
            System.out.println("3. 잔액 확인");
            System.out.println("4. 서비스 종료");
            int service_num1 = sc.nextInt();
            if(service_num1 == 1){
                // 출금
                System.out.println("방법을 선택해주세요.");
                System.out.println("1. Card");
                System.out.println("2. Kapay");
                int service_num2 = sc.nextInt();
                System.out.println("금액을 입력해주세요");
                long pay = sc.nextInt();
                if(service_num2 == 1){
                    BankService service = new BankCard();
                    service.deposit(entity,pay);
                }else{
                    BankService service = new BankKapay();
                    service.deposit(entity,pay);
                }
            } else if (service_num1 == 2) {
                // 입금
                System.out.println("방법을 선택해주세요.");
                System.out.println("1. Card");
                System.out.println("2. Kapay");
                int service_num2 = sc.nextInt();
                System.out.println("금액을 입력해주세요");
                long pay = sc.nextInt();
                if(service_num2 == 1){
                    BankService service = new BankCard();
                    service.withdraw(entity,pay);
                }else{
                    BankService service = new BankKapay();
                    service.withdraw(entity,pay);
                }
            } else if (service_num1 == 3){
                System.out.println("잔액 확인 서비스 입니다.");
                System.out.println("잔액은 " + entity.getBalance() + "원 입니다.");
            } else if (service_num1 == 4){
                System.out.println("방문해 주셔서 감사합니다.");
                break;
            }
            System.out.println("방문해 주셔서 감사합니다.");
        }

//        BankAccout b = new BankAccout("123");
//        b.withdraw(1000);
//        b.deposit(10000);
//        b.withdraw(5000);
//        b.deposit(2500);
//        b.withdraw(10000);
//        System.out.println("잔고는 :"+b.getBalance());
//        System.out.println("계좌는 :"+b.getAccount_num());
    }
}
