import java.util.Scanner;

public class CalculationCircle extends AbstractionMethod {
    Scanner scanner = new Scanner(System.in);
    // Calculation of Area of Circle
    public double area() {
        System.out.print("Radius : ");
        double radius = scanner.nextDouble();
        return Math.PI * Math.pow(radius, radius);
    }

    // Calculation of Perimeter of Circle
    @Override
    public double perimeter() {
        System.out.print("Radius : ");
        double radius = scanner.nextDouble();
        return 2 * Math.PI * radius;
    }

    // Displaying the result
    public CalculationCircle calculationAreaCircle(){
        double areaResult = area();
        System.out.println("The Area of Circle is : " + areaResult);
        return this;
    }

    public CalculationCircle calculationPerimeterCircle(){
        double perimeterResult = perimeter();
        System.out.println("The Perimeter of Circle is " + perimeterResult);
        return this;
    }
}
