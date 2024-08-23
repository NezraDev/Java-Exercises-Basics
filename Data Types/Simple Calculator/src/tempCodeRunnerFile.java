import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Java Calculator");
        System.out.println("Please Enter to Proceed :))");
        scanner.next();

        System.out.println("Please SELECT your Operator");
        System.out.println("+" + "Add");
        System.out.println("-" + "Subtract");
        System.out.println("/" + "Divide");
        System.out.println("*" + "Multiply");
       

        System.out.print("Enter a Number: ");
        double first_Num = scanner.nextDouble();
        System.out.print("Enter a Number: ");
        double second_Num = scanner.nextDouble();
       
    }
}


