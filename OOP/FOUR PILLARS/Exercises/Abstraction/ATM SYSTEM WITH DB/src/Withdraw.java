import java.sql.*;
import java.util.Scanner;

public class Withdraw {
    public void UserWithdraw() {
        Scanner scanner = new Scanner(System.in);
        String url = "jdbc:mysql://127.0.0.1:3306/atminfo";
        String user = "root";
        String password = "071223";
        String query = "SELECT * FROM atmusers WHERE pincode = ?";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = connection.prepareStatement(query)) {

            boolean isPinCorrect = false;
            System.out.println(" ");
            System.out.print("       Amount you want to withdraw : ");
            double amountWithdraw = scanner.nextDouble();

            while (!isPinCorrect) {
                System.out.println(" ");
                System.out.print("       Enter your pincode for confirmation:  ");
                int userPinCode = scanner.nextInt();

                stmt.setInt(1, userPinCode);
                ResultSet resultSet = stmt.executeQuery();

                if (resultSet.next()) {
                    isPinCorrect = true;
                    double currentBalance = resultSet.getDouble("balance");

                    if (amountWithdraw <= currentBalance) {
                        double newBalance = currentBalance - amountWithdraw;

                        String updateQuery = "UPDATE atmusers SET balance = ? WHERE id =?";
                        try (PreparedStatement updatedstmt = connection.prepareStatement(updateQuery)) {
                            updatedstmt.setDouble(1, newBalance);
                            updatedstmt.setInt(2, resultSet.getInt("id"));
                            updatedstmt.executeUpdate();
                        }
                        System.out.println("┍-------------------------------------------------------------┑");
                        System.out.println("|                     Withdrawal Successful                   |");
                        System.out.println("┕-------------------------------------------------------------┛");
                        System.out.println("┍-------------------------------------------------------------┑");
                        System.out.println("       New Balance : " + newBalance);
                        System.out.println("┕-------------------------------------------------------------┛");
                    } else {

                        System.out.println("┍-------------------------------------------------------------┑");
                        System.out.println("|             Insufficient Funds, Please Try Again            |");
                        System.out.println("┕-------------------------------------------------------------┛");
                    }
                } else {
                    System.out.println(" ");
                }
            }
            } catch(SQLException e){
                e.printStackTrace();

            }
        }
    }


