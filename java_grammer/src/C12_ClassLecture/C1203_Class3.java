package C12_ClassLecture;

public class C1203_Class3 {
    public static void main(String[] args) {
        BankAccount sim = new BankAccount("12345");
        sim.deposit(10000);
        sim.withDraw(400);
        

    }
}
//클래스명 BankAccount
//0)객체 변수 : 계좌번호(account_number), balance(잔고)
//0-1)계좌번호 setter
//1)메서드 : 예금(deposit) 인출(withdraw)
//1-1) deposit에 잔액이 충분해야 인출
//1-2) 잔액 얼마 남았는지 확인하는 메서드
class BankAccount{
    private String account_number;  //계좌번호
    private long balance;     //잔고

    public String getAccount_number() {
        return account_number;
    }

    //    별도의 생성자를 만들지 않으면 매개변수 없는 기본 생성자가 숨겨져있다
//    생성자: 클래스가 객체화 될떄 자동으로 실행되는 메서드
//    클래스명(){} : 생성자의 형태
    BankAccount(String accountNumber){
        this.account_number = accountNumber;
    }

    public void deposit(long money){
        this.balance += money;
        System.out.println(money + "원 입금되었습니다.");
    }

    public void withDraw(long money) {
        if (this.balance >= money) {
            this.balance -= money;
            System.out.println(money + "원 출금되었습니다.");
        } else {
            System.out.println("계좌 잔고가 부족합니다.");
        }
    }

    public long checkBalance(){
        return this.balance;
    }
}