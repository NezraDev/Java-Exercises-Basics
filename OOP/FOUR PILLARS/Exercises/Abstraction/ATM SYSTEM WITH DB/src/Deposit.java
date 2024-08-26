import java.sql.*;
import java.util.Scanner;

public class Deposit {
    public void UserDeposit() {
        Scanner scanner = new Scanner(System.in);

        String url = "jdbc:mysql://127.0.0.1:3306/atminfo";
        String user = "root";
        String password = "071223";
        String query = "SELECT * FROM atmusers WHERE pincode = ?";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = connection.prepareStatement(query)) {

            boolean isPinCorrect = false;

            System.out.print("       Amount you want to deposit: ");
            double amountDeposit = scanner.nextDouble();

            while (!isPinCorrect) {
                System.out.println();
                System.out.print("       Enter your pincode for confirmation: ");
                int userPinCode = scanner.nextInt();

                stmt.setInt(1, userPinCode);
                ResultSet resultSet = stmt.executeQuery();

                if (resultSet.next()) {
                    isPinCorrect = true;
                    double currentBalance = resultSet.getDouble("balance");
                    double newBalance = currentBalance + amountDeposit;

                    String updateQuery = "UPDATE atmusers SET balance = ? WHERE id = ?";
                    try (PreparedStatement updateStmt = connection.prepareStatement(updateQuery)) {
                        updateStmt.setDouble(1, newBalance);
                        updateStmt.setInt(2, resultSet.getInt("id"));
                        updateStmt.executeUpdate();
                    }

                    System.out.println();
                    System.out.println("┍-------------------------------------------------------------┑");
                    System.out.println("       New Balance: " + newBalance);
                    System.out.println("┕-------------------------------------------------------------┛");
                } else {
                    System.out.println();
                    System.out.println("┍-------------------------------------------------------------┑");
                    System.out.println("|                        Wrong Pincode                        |");
                    System.out.println("┕-------------------------------------------------------------┛");
                }
            }

        } catch (SQLException e) {
            System.out.println("An error occurred while processing the transaction.");
        }
    }
}
