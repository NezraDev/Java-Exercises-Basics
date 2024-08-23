
import java.util.Scanner;
    class Calculator {
        private double  first_number;
        private double  second_number;
        private Scanner scanner = new Scanner(System.in);
        private char operator;

        void numberInput(){
            System.out.print("Enter First Number: ");
            first_number= scanner.nextDouble();
            System.out.print("Enter Second Number: ");
            second_number= scanner.nextDouble();
        }

        void operatorInput(){
            System.out.println("");
            System.out.println("Please SELECT your Operator");
            scanner.skip("");
            System.out.println("    +" + "    Add");
            System.out.println("    -" + "    Subtract");
            System.out.println("    /" + "    Divide");
            System.out.println("    *" + "    Multiply");
            System.out.println("");
            System.out.print("Enter an Operator: ");
            operator = scanner.next().charAt(0);
        }

        void operatorValidation()
        {
            switch(operator)
            {
                case '+' :
                {
                    double sum = first_number + second_number;
                    System.out.println("Sum: " + sum );
                    break;
                }
                case '-' :
                {
                    double difference = first_number - second_number;
                    System.out.println("Difference: " + difference );
                    break;
                }
                case '*' :
                {
                    double product = first_number * second_number;
                    System.out.println("Product: " + product );
                    break;
                }
                case '/' :
                {
                    double quotient = first_number / second_number;
                    System.out.println("Sum: " + quotient );
                    break;
                }
                default : 
                
                    System.out.println("You have entered an invalid operator, Please try again");
                    break; 
                
                }   
            }
   

        boolean retry()
        {
            System.out.print("Do you want to Calculate again? (Y or N) : ");
            char choice = scanner.next().charAt(0);
            return choice == 'y' || choice == 'Y';
            
        }

    void appCalculator()
    {  
        Calculator calculator = new Calculator();
        boolean continueCalculate;

        do {
            calculator.operatorInput();
            calculator.numberInput();
            calculator.operatorValidation();
            continueCalculate = calculator.retry();
        } while(continueCalculate);
        {
            System.out.println("Thank you for using Java Calculator");
            scanner.close();
        }
    }
}

public class App {
    public static void main(String args[]) {     
       Calculator calculator = new Calculator();
       calculator.appCalculator();
        
    }
}




