import java.sql.*;
import java.util.Scanner;

public class Login {
    public boolean UserLogin() {
        LoginTransaction login = new LoginTransaction();
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();
        Register register = new Register();

        String url = "jdbc:mysql://127.0.0.1:3306/atminfo";
        String user = "root";
        String password = "071223";
        String query = "SELECT * FROM atmusers WHERE username = ? AND password = ? AND pincode = ?";

        System.out.println(" ");
        System.out.println("┍-------------------------------------------------------------┑");
        System.out.println("|                          Login                              |");
        System.out.println("┕-------------------------------------------------------------┛");
        System.out.println(" ");
        System.out.print("       Username : ");
        String username = scanner.next();
        System.out.print("       Password : ");
        String user_password = scanner.next();
        System.out.print("       PinCode  : ");
        int user_pin_code = scanner.nextInt();

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.setString(2, user_password);
            stmt.setInt(3, user_pin_code);

            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                System.out.println(" ");
                System.out.println("┍-------------------------------------------------------------┑");
                System.out.println("|                      Login Successfully                     |");
                System.out.println("┕-------------------------------------------------------------┛");
                return true;


            } else {
                System.out.println(" ");
                System.out.println("┍-------------------------------------------------------------┑");
                System.out.println("|                      Account not Found                      |");
                System.out.println("|                                                             |");
                System.out.println("|                   Do you want to Register?                  |");
                System.out.println("|                           1. Yes                            |");
                System.out.println("|                           2. No                             |");
                System.out.println("┕-------------------------------------------------------------┛");

                System.out.print("       Select Choice : ");
                int choice = scanner.nextInt();
                switch (choice){
                    case 1 :
                    {
                        register.UsersRegistration();
                        break;
                    }
                    case 2 :
                       bank.BankSystem();
                       break;
                }
                return false;

            }
        } catch (SQLException e) {
            e.printStackTrace();

        }


        return false;
    }


}
