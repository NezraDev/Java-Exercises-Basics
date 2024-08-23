
import java.text.NumberFormat;
import java.util.Scanner;


public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Principal: ");
        long principal = scanner.nextLong();
      
        System.out.print("Annual Interest Rate: ");
        double annual = scanner.nextDouble() / 100 / 12;
       

        System.out.print("Period (Years): ");
        int years = scanner.nextInt() * 12;

        double answer = principal * (annual * Math.pow(1 + annual, years)) / (Math.pow(1 + annual, years)-1);
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String result = currency.format(answer);
        
        System.out.println("Mortgage: " + result);

       
    }
}
