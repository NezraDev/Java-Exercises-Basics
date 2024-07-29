
import java.text.NumberFormat;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int annualInterestRate = 100;
        int yearsToMonth = 12;

        System.out.print("Principal ($1k - $1M): ");
        int principal = scanner.nextInt();
        while (true){
            if(principal >= 1_000 && principal <= 1_000_000){
                break;
            }
            else{
                System.out.println("Enter a number between 1,000 and 1,000,000");  
            }
        }

        System.out.print("Annual Interest Rate : ");
        double rate = scanner.nextDouble();
        while(true){
            if (rate > 0 && rate <= 30){
                rate = rate / annualInterestRate / yearsToMonth;
                break;
            }
            else{
                System.out.println("Enter a value greater than 0 and less than or equal to 30");
            } 
        }

        System.out.print("Period (Years): ");
        int years = scanner.nextInt();

        while(true){
            if (years > 0 && years <= 30){
                years = years * yearsToMonth;
                break;
            }
            else{
                System.out.print("Enter a between 1 and 30");
            }
     }
        double answer = principal * (rate * Math.pow(1 + rate, years)) / (Math.pow(1 + rate, years)-1);
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String result = currency.format(answer);
            
        System.out.println("Mortgage: " + result);
    }
}
