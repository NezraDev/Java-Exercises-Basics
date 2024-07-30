
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a Multiplicand: ");
        int multiplicand = scanner.nextInt();
        System.out.print("Enter a Multiplicator: ");
        int multiplicator = scanner.nextInt();

        int total = 0;
       
        for(int i = 0; i <= multiplicator; i++)
        {
            int product = multiplicand * i;
            System.out.println(multiplicand + " x " + i + " = " + product);
            total += product;
        }
        double average = (double) total / (multiplicator);
        System.out.println("Total of the product: " + total);
        System.out.println("Average of the product: " + average);
        if (total % 2 == 0)
        {
            System.out.println(total + " is an even number");
        }else{
            System.out.println(total + " is an odd number");
        }
        
        
      
    }
        
}

