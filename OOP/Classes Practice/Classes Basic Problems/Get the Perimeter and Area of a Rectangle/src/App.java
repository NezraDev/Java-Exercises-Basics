
import java.util.Scanner;

class Rectangle{
    private double heightInput, widthInput;

public void setWidth()
{
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter width : ");
    widthInput = scanner.nextDouble();
}
public void setHeight()
{
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter height : ");
    heightInput = scanner.nextDouble();
}

public void getPerimeter()
{
    double perimeter = 2 * (heightInput + widthInput);
    System.out.println("Perimeter : " + perimeter);
}
public void getArea()
{
    double area = heightInput * widthInput;
    System.out.println("Area : " + area);
}
}

public class App {
    public static void main(String[] args) throws Exception {
    Rectangle rectangle = new Rectangle();
    rectangle.setWidth();
    rectangle.setHeight();
    rectangle.getPerimeter();
    rectangle.getArea();
    }
}

