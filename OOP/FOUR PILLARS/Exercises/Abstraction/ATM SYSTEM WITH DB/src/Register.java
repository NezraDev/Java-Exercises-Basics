import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Register {
        Scanner scanner = new Scanner(System.in);

        public boolean UsersRegistration(){
            // Information on the SQL
            String url = "jdbc:mysql://127.0.0.1:3306/atminfo";
            String user ="root";
            String password = "071223";
            String query = "INSERT INTO atmusers (username, password, pincode, balance) VALUES (?, ?, ?, 0)";

            // Users Registration
            System.out.println(" ");
            System.out.println("┍-------------------------------------------------------------┑");
            System.out.println("|                        Register                             |");
            System.out.println("┕-------------------------------------------------------------┛");
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

                int rowsAffected = stmt.executeUpdate();
                if (rowsAffected > 0){
                    System.out.println("");
                    System.out.println("┍-------------------------------------------------------------┑");
                    System.out.println("|                  Successfully Registered                    |");
                    System.out.println("┕-------------------------------------------------------------┛");

                }else{
                    System.out.println("┍-------------------------------------------------------------┑");
                    System.out.println("|                    Registered Failed                        |");
                    System.out.println("┕-------------------------------------------------------------┛");

                }
            } catch (SQLException e) {
               e.printStackTrace();
            } ;
            return false;
        }
}

