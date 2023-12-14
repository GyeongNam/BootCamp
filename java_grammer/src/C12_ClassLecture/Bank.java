package C12_ClassLecture;

public class Bank {
    public static void main(String[] args) {
        BankAccout b = new BankAccout("123");
        b.withdraw(1000);
        b.deposit(10000);
        b.withdraw(5000);
        b.deposit(2500);
        b.withdraw(10000);
        System.out.println("잔고는 :"+b.getBalance());
        System.out.println("계좌는 :"+b.getAccount_num());

    }
}
class BankAccout {
    private static String account_num ;
    private static long balance = 0;

    // 생성자
    BankAccout(String str){
        account_num = str;
    }

    public long getBalance() {
        return balance;
    }

    public String getAccount_num(){
        return account_num;
    }

    public void deposit(long pay){
        balance += pay;
        System.out.println(pay +"를 예금합니다.");
        System.out.println("잔액은 :"+ balance +"원 입니다.");
    }

    public void withdraw(long pay){
        if(balance<pay){
            System.out.println("잔액이 부족합니다");
        }else{
            balance-=pay;
            System.out.println(pay +"를 인출합니다.");
            System.out.println("잔액은 :"+ balance +"원 입니다.");
        }
    }
}
