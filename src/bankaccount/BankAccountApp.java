package bankaccount;

import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {
    public static void main(String[] args) {

        List<Account> accounts = new LinkedList<Account>();

        String file = "C:\\Users\\Gidra\\Downloads\\NewBankAccounts.csv";

        //Read a CSV file then create new accounts based on that data
        List<String[]> newAccountHolders = utilities.CSV.read(file);

        for (String[] accountHolder : newAccountHolders) {
            String name = accountHolder[0];
            String sSN = accountHolder[1];
            String accountType = accountHolder[2];
            double initDeposit = Double.parseDouble(accountHolder[3]);
            //System.out.println(name + " " + sSN + " " + accountType + " $" + initDeposit);
            if (accountType.equals("Savings")){
                accounts.add(new Savings(name, sSN, initDeposit));
            }else if (accountType.equals("Checking")){
                accounts.add(new Checking(name, sSN, initDeposit));
            }else {
                System.out.println("Error reading account type");
            }
        }

        for (Account acc : accounts) {
            System.out.println("\n*************");
            acc.showInfo();
        }

    }
}
