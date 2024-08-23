import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

    Scanner scanner = new Scanner(System.in);
    System.out.println("Welcome to the Java Calculator ");
    System.out.println("Please Enter to Proceed <------");
    scanner.hasNextLine();

    while(true){
    System.out.println();
    System.out.println("Please SELECT your Operator");
    scanner.skip("");
    System.out.println("    +" + "    Add");
    System.out.println("    -" + "    Subtract");
    System.out.println("    /" + "    Divide");
    System.out.println("    *" + "    Multiply");
    System.out.println("");
    System.out.print("Enter an Operator: ");
    char operator = scanner.next().charAt(0);
    
    System.out.print("Enter a Number: ");
    double first_Num = scanner.nextDouble();
    System.out.print("Enter a Number: ");
    double second_Num = scanner.nextDouble();

    switch(operator)
{
        case '+' :
        {
            double sum = first_Num + second_Num;
            System.out.println("Answer: " + sum);
            System.out.println();
            break;
        }
        case '-' :
        {
            double difference = first_Num - second_Num;
            System.out.println("Answer: " + difference);
            System.out.println();
            break;
        }
        case '*' :
        {
            double product = first_Num * second_Num;
            System.out.println("Answer: " + product);
            System.out.println();
            break;
        }
        case '/' :
        {
            double quotient = first_Num / second_Num;
            System.out.println("Answer: " + quotient);
            System.out.println();
            break;
        }
        default:
            System.out.println("");
            System.out.println("You have inputted invalid operator");
            System.out.println("");   

    }
        System.out.println();
        System.out.println("Do you want to calculate again?");
        System.out.print("");
        System.out.println("              Y" );
        System.out.println("              N" );
        char answer = scanner.next().charAt(0);
        if(answer == 'n' || answer == 'N'){
            break;
        }else{
            scanner.nextLine();
        }
    }
    scanner.close();
    System.out.println("Thank you for using Java Calculator ");
}
}



