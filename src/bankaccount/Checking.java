package bankaccount;

public class Checking extends Account {
    //list properties specific to Checking account
    private int debitCardNumber;
    private int debitCardPin;

    //constructor to initialize checking account properties
    public Checking(String name, String sSN, double initDeposit){
        super(name, sSN, initDeposit);
        accountNumber = "2" + accountNumber;
        setDebitCard();
    }

    @Override
    public void setRate() {
        rate = getBaseRate() * .15;
    }

    private void setDebitCard(){
        debitCardNumber = (int) (Math.random() * Math.pow(10,12));
        debitCardPin = (int) (Math.random() * Math.pow(10,4));
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println(
                    "Your checking account feature:" +
                    "\n Debit card number: " +debitCardNumber+
                    "\n Debit card pin: " +debitCardPin
                           );
    }
}
