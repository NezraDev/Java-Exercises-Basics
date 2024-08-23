import java.util.Scanner;

public class Commands {

    CalculationCircle circle = new CalculationCircle();
    CalculationTriangle triangle = new CalculationTriangle();

    public void Choices() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(" ");
            System.out.println("Please Select the Shape you want to compute");
            System.out.println("1. Circle");
            System.out.println("2. Triangle");
            System.out.println(" ");
            System.out.print("Select Choice : ");
            int choice = scanner.nextInt();
            System.out.println(" ");
            switch (choice) {
                case 1: {
                    System.out.println("1. Area");
                    System.out.println("2. Perimeter");
                    System.out.println(" ");
                    System.out.print("Select Choice : ");
                    int choiceCalculationOfCircle = scanner.nextInt();
                    System.out.println(" ");
                    if (choiceCalculationOfCircle == 1) {
                        circle.calculationAreaCircle();
                        break;
                    } else {
                        circle.calculationPerimeterCircle();
                        break;
                    }
                }
                case 2: {
                    System.out.println("1. Area");
                    System.out.println("2. Perimeter");
                    System.out.print("Select Choice : ");
                    int choiceCalculationForTriangle = scanner.nextInt();
                    System.out.println(" ");
                    if (choiceCalculationForTriangle == 1) {
                        triangle.calculationAreaTriangle();
                        break;
                    } else {
                        triangle.calculationPerimeterTriangle();
                    }
                }
                default:
                    System.out.println("Invalid Choice");
                    continue;
            }
            while (true) {
                System.out.println(" ");
                System.out.println("Do you want to Calculate Again? : ");
                System.out.println("1. Yes");
                System.out.println("2. No");
                System.out.print("Select Choice : ");
                int calculateChoice = scanner.nextInt();
                switch (calculateChoice) {
                    case 1: {
                        break;
                    }
                    case 2: {
                        System.out.println("Thank you for using!");
                        return;
                    }
                    default:
                        System.out.println("Invalid selection choice!");
                        continue;
                }
                break;
            }
        }
    }
    }

