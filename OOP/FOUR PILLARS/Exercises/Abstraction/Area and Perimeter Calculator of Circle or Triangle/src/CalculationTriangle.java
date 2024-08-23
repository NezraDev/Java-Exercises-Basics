import java.util.Scanner;

public class CalculationTriangle extends AbstractionMethod {
    Scanner scanner = new Scanner(System.in);

    // Calculation of Area of Triangle
    @Override
    public double area() {
        System.out.print("Height : ");
        double height = scanner.nextDouble();
        System.out.print("Base : ");
        double base = scanner.nextDouble();
        return 0.5 * height * base;
    }

    // Calculation of Perimeter of Triangle
    @Override
    public double perimeter() {
        System.out.print("Base : ");
        double base = scanner.nextDouble();
        System.out.print("Side One : ");
        double sideOne = scanner.nextDouble();
        System.out.print("Side Two : ");
        double sideTwo = scanner.nextDouble();
        return (base + sideOne + sideTwo);
    }

    //Displaying the Results
    public CalculationTriangle calculationAreaTriangle() {
        double areaResult = area();
        System.out.println("The Area of the Triangle is : " + areaResult);
        System.out.println(" ");
        return this;
    }

    public CalculationTriangle calculationPerimeterTriangle() {
        double perimeterResult = perimeter();
        System.out.println("The Perimeter of the Triangle is : " + perimeterResult);
        System.out.print(" ");
        return this;
    }
}

