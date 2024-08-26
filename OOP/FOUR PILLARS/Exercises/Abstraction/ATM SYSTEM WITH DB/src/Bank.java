import java.util.Scanner;

public class Bank {
    public void BankSystem() {
        Bank bank = new Bank();
        LoginTransaction transaction = new LoginTransaction();
        Scanner scanner = new Scanner(System.in);
        Register register = new Register();
        Login login = new Login();

        while (true) {
            System.out.println(" ");
            System.out.println("┍-------------------------------------------------------------┑");
            System.out.println("|                   Welcome to I-ATM MO!                      |");
            System.out.println("|                       1. Login                              |");
            System.out.println("|                       2. Register                           |");
            System.out.println("|                       3. Exit                               |");
            System.out.println("┕-------------------------------------------------------------┛");
            System.out.println(" ");

            System.out.print("       Select Choice : ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                        boolean isLoggedIn = login.UserLogin();

                        if (isLoggedIn) {
                            boolean continueTransaction;

                            do {
                                continueTransaction = transaction.Transaction();
                            } while(continueTransaction);
                            }
                        break;
                case 2:
                    while (true) {
                        boolean isRegisteredIn = register.UsersRegistration();
                        if (isRegisteredIn) {
                            continue;
                        }
                        break;
                    }
                    break;
                case 3:
                    System.out.println("┍-------------------------------------------------------------┑");
                    System.out.println("|                   Thank you for using                       |");
                    System.out.println("┕-------------------------------------------------------------┛");
                    return;
                default:
                    System.out.println("┍-------------------------------------------------------------┑");
                    System.out.println("|                      Invalid Input                          |");
                    System.out.println("┕-------------------------------------------------------------┛");
                    while (true) {
                        bank.BankSystem();
                        break;
                    }
                    break;
            }

        }
    }
}
