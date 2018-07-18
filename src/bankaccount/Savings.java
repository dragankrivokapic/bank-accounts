package bankaccount;

public class Savings extends Account {

    //properties specific to a Savings account
   private int safetyDepositBoxId;
   private int safetyDepositBoxKey;

    //constructor to initialize savings account properties
    public Savings(String name, String sSN, double initDeposit){
        super(name, sSN, initDeposit);
        accountNumber = "1" + accountNumber;
        setSafetyDepositBox();
    }

    @Override
    public void setRate() {
        rate = getBaseRate() - .25;
    }

    private void setSafetyDepositBox(){
        safetyDepositBoxId = (int)(Math.random() * Math.pow(10,3));
        safetyDepositBoxKey =(int)(Math.random() * Math.pow(10,4));
    }

    public void showInfo(){
        super.showInfo();
        System.out.println(
                "Your savings account features:" +
                 "\n Safety deposit box id: " +safetyDepositBoxId+
                 "\n Safety deposit box key: " +safetyDepositBoxKey

                         );
    }
}
