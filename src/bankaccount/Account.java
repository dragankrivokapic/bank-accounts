package bankaccount;

public abstract class Account implements IBaseRate {

    //fields for Savings and Checking accounts
   private String name;
   private String sSN;
   private double balance;
   protected String accountNumber;
   protected double rate;
   protected static int index = 10000;

    //Constructor to set base properties and initialize the account
    public Account(String name, String sSN, double initDeposit){
        this.name = name;
        this.sSN = sSN;
        balance = initDeposit;

        //set account number
        index++;
        this.accountNumber = setAccountNumber();

        setRate();

    }

    private String setAccountNumber(){
        String lastTwoOfSsn = sSN.substring(sSN.length()-2, sSN.length());
        int uniqueId = index;
        int randomNumber = (int)(Math.random() * Math.pow(10,3));
        return lastTwoOfSsn + uniqueId + randomNumber;
    }

    public abstract void setRate();

    //list common methods

    public void compound(){
        double accuredInterest = balance * (rate/100);
        balance += accuredInterest;
        System.out.println("Accrued interest: $" +accuredInterest);
        printBalance();
    }

    public void deposit(double amount){
        balance += amount;
        System.out.println("Depositing $" +amount);
        printBalance();
    }

    public void withdraw(double amount){
        balance -= amount;
        System.out.println("Withdrawing $" +amount);
        printBalance();
    }

    public void transfer(String toWhere, double amount){
        balance -= amount;
        System.out.println("Transfering $" +amount+ " to " +toWhere);
        printBalance();
    }

    public void printBalance(){
        System.out.println("Your balance is: $" +balance);
    }

    public void showInfo(){
        System.out.println(
                    "NAME is: " + name +
                    "\n Account number is: " + accountNumber +
                    "\n Balance is: " + balance +
                    "\n Rate is: " + rate + "%"
                    );
    }
}
