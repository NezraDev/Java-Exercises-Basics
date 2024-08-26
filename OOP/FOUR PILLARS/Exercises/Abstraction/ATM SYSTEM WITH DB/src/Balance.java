import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Balance {

    public void checkBalance() {
        Scanner scanner = new Scanner(System.in);

        String url = "jdbc:mysql://127.0.0.1:3306/atminfo";
        String user = "root";
        String password = "071223";
        String query = "SELECT balance FROM atmusers WHERE pincode = ?";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = connection.prepareStatement(query)) {

            boolean isPinCorrect = false;

            while (!isPinCorrect) {
                System.out.println();
                System.out.print("       Enter your pincode for confirmation: ");

                try {
                    int userPinCode = scanner.nextInt();
                    stmt.setInt(1, userPinCode);
                    ResultSet resultSet = stmt.executeQuery();

                    if (resultSet.next()) {
                        isPinCorrect = true;
                        double balance = resultSet.getDouble("balance");
                        System.out.println();
                        System.out.println("┍-------------------------------------------------------------┑");
                        System.out.println("       Maintaining Balance: " + balance);
                        System.out.println("┕-------------------------------------------------------------┛");
                    } else {
                        System.out.println("┍-------------------------------------------------------------┑");
                        System.out.println("|                        Wrong Pincode                        |");
                        System.out.println("┕-------------------------------------------------------------┛");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("┍-------------------------------------------------------------┑");
                    System.out.println("|                 Please Enter Numeric Pincode                |");
                    System.out.println("┕-------------------------------------------------------------┛");
                    scanner.next(); // Clear the invalid input
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
