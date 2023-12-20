package C14_Interface.BankService;

public interface BankService {
    public void deposit(BankAccount entity,long pay);

    public void withdraw(BankAccount entity,long pay);
}