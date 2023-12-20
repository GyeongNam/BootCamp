package C14_Interface.BankService;

public class BankAccount {
    private String account_num ;
    private long balance = 0;

    public String getAccount_num() {
        return account_num;
    }

    public void setAccount_num(String account_num) {
        this.account_num = account_num;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    // 생성자
    BankAccount(String str){
        account_num = str;
    }
}
