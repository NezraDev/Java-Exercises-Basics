import java.util.Scanner;

public class LoginTransaction {

    public boolean Transaction(){
        Balance balance = new Balance();
        Withdraw withdraw = new Withdraw();
        Deposit deposit = new Deposit();
        Bank bank = new Bank();

        Scanner scanner = new Scanner(System.in);
        System.out.println("┍-------------------------------------------------------------┑");
        System.out.println("|                    Select a Transaction                     |");
        System.out.println("|                                                             |");
        System.out.println("|                      1. Check Balance                       |");
        System.out.println("|                      2. Withdraw                            |");
        System.out.println("|                      3. Deposit                             |");
        System.out.println("|                      4. Exit                                |");
        System.out.println("┕-------------------------------------------------------------┛");

        System.out.println(" ");
        System.out.print("       Select Choice : ");
        int choice = scanner.nextInt();

        switch(choice){
            case 1 :
                balance.checkBalance();
                break;
            case 2 :
                withdraw.UserWithdraw();
                break;
            case 3 :
                deposit.UserDeposit();
                break;
            case 4 :
                return false;
            default:
                break;
        }
        return true;
    }
}
