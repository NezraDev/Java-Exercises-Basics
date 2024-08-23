import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        int balance = 0;
        Map<String, String> userDatabase = new HashMap<>();
        List<Integer> pinCodes = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("");
            System.out.println("=======================================");
            System.out.println("|        Welcome to ATM System        |");
            System.out.println("=======================================");
            System.out.println("|            1. Login                 | ");
            System.out.println("|            2. Register              |");
            System.out.println("|            3. Exit                  |");
            System.out.println("=======================================");
            System.out.println("");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  

            if (choice == 2) {
                System.out.println("");
                System.out.print("Username : ");
                String username = scanner.nextLine();

                if (userDatabase.containsKey(username)) {
                    System.out.println("Username already taken! Please enter another.");
                } else {
                    System.out.print("Password : ");
                    String password = scanner.nextLine();
                    System.out.print("PIN CODE : ");
                    int pinCode = scanner.nextInt();
                    userDatabase.put(username, password);
                    pinCodes.add(pinCode);
                    System.out.println(" ");
                    System.out.println("---------------------------------------");
                    System.out.println("|       Registration successful       |");      
                    System.out.println("---------------------------------------");
                    System.out.println("");
                    
                }
            } else if (choice == 1) {
                while (true) {  
                    System.out.println(" ");
                    System.out.print("Username : ");
                    String username = scanner.next();
                    System.out.print("Password : ");
                    String password = scanner.next();
                    System.out.print("PIN CODE : ");
                    int pinCode = scanner.nextInt();
                    System.out.println(" ");
                    if (userDatabase.containsKey(username) && userDatabase.get(username).equals(password) && pinCodes.contains(pinCode)){
                        System.out.println("---------------------------------------");
                        System.out.println("|          Login successful           |");      
                        System.out.println("---------------------------------------");

                        while (true) {  
                            System.out.println("");
                            System.out.println("=======================================================");
                            System.out.println("|        Please select what type of transaction       |");
                            System.out.println("=======================================================");
                            System.out.println("|                 1. Check Balance                    |");
                            System.out.println("|                 2. Withdraw                         |");
                            System.out.println("|                 3. Deposit                          |");
                            System.out.println("|                 4. Logout                           |");
                            System.out.println("=======================================================");
                            System.out.println("");
                            System.out.print("Enter your choice: ");
                            int transactionChoice = scanner.nextInt();
                            System.out.println("");
                            scanner.nextLine();  

                            switch (transactionChoice) {
                                case 1:
                                System.out.println("---------------------------------------");
                                System.out.println("         Remaining Balance  : " + balance);      
                                System.out.println("---------------------------------------");
                                System.out.print(" ");
                                break;
                                case 2:
                                    System.out.print("Amount you want to withdraw: ");
                                    int amountWithdraw = scanner.nextInt();
                                    scanner.nextLine();
                                    
                                    if (amountWithdraw > balance)
                                    {
                                        System.out.println("");
                                        System.out.println("---------------------------------------");
                                        System.out.println("|        Unsufficient Balance         |");      
                                        System.out.println("---------------------------------------");
                                        
                                    }else {
                                        balance -= amountWithdraw;
                                        System.out.println("");
                                        System.out.println("---------------------------------------");
                                        System.out.println("         New Balance  : " + balance);      
                                        System.out.println("---------------------------------------");
                                        System.out.print(" ");
                                    }
                                    break;
                                case 3:
                                    System.out.print("Amount you want to deposit: ");
                                    int amountDeposit = scanner.nextInt();
                                    scanner.nextLine();
                                    balance =+ amountDeposit;
                                    System.out.println("");
                                    System.out.println("---------------------------------------");
                                    System.out.println("     You Deposited : " +amountDeposit );  
                                    System.out.println("     New Balance :   " +balance );     
                                    System.out.println("---------------------------------------");
                                    System.out.print(" ");
                                    break;
                                case 4:
                                    System.out.println("---------------------------------------");
                                    System.out.println("|        Logging out.........         |");      
                                    System.out.println("---------------------------------------");
                                    System.out.println("");
                                    break; 
                                default:
                                    System.out.println("Invalid choice.");
                            }

                            if (transactionChoice == 4) {
                                break; 
                            }
                        }
                        break; 
                    } else {
                        System.out.println(" ");
                        System.out.println("Your username, password and pincode did not match, please try again.");
                        System.out.println("");
                    }
                }
            } else if (choice == 3) {
                System.out.println("");
                System.out.println("---------------------------------------");
                System.out.println("|   Thank you for using ATM System    |");      
                System.out.println("---------------------------------------");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
