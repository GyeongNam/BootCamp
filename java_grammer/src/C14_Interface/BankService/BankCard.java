package C14_Interface.BankService;

public class BankCard implements BankService{

    @Override
    public void deposit(BankAccount entity, long pay) {
        System.out.println("카드 서비스 입금입니다.");
        entity.setBalance(entity.getBalance()+pay);
        System.out.println(pay +"를 입금합니다.");
        System.out.println("잔액은 :"+ entity.getBalance() +"원 입니다.");
    }

    @Override
    public void withdraw(BankAccount entity, long pay) {
        System.out.println("카드 서비스 출금입니다.");
        if(entity.getBalance()<pay){
            System.out.println("잔액이 부족합니다");
            System.out.println("잔액은 "+ entity.getBalance() + "원 입니다.");
        }else{
            entity.setBalance(entity.getBalance()-pay);
            System.out.println(pay +"를 인출합니다.");
            System.out.println("잔액은 :"+ entity.getBalance() +"원 입니다.");
        }
    }
}
