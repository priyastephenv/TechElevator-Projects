import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

class Account {
    /*
     * Instance variables
     */
    private BigDecimal balance;
    private List<String> accountHolders;

    /*
     * Constructor
     */
    public Account(String primaryAccountHolderName){
        this.balance = BigDecimal.ZERO;
        this.accountHolders.add(primaryAccountHolderName);
    }

    /*
     * Methods
     */
    public void deposit(BigDecimal amountToDeposit){
        //this.balance += amountToDeposit;
        this.balance = this.balance.add(amountToDeposit);
    }

    public void withdraw(BigDecimal amountToWithdraw){
        //this.balance -= amountToWithdraw;
        this.balance = this.balance.subtract(amountToWithdraw);
    }

    public void addJointAccountHolder(String jointAccountHolderName){
        this.addJointAccountHolder(jointAccountHolderName);
    }

    @Override
    public String toString(){
        return "The current balance is: $" + this.balance.setScale(2, RoundingMode.HALF_UP);
    }
}

public class BigDecimalDemo {
    public static void main(String[] args) {
        Account account1 = new Account("Jose");

        BigDecimal deposit1 = new BigDecimal("0.1");
        BigDecimal deposit2 = new BigDecimal("0.2");

        account1.deposit(deposit1);
        account1.deposit(deposit2);

        System.out.println(account1);
    }
}
