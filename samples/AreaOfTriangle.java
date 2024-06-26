
//https://www.upgrad.com/tutorials/software-engineering/java-tutorial/area-of-triangle-in-java/#example-2-%E2%80%93-finding-the-area-of-triangle-in-java-using-the-three-sides-of-the-triangle
// FINDING THE AREA OF TRIANGLE IN JAVA USING THE THREE SIDES OF THE TRIANGLE
package samples;

import java.util.Scanner;

public class AreaOfTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the length of side a:");
        double a = scanner.nextDouble();

        System.out.println("Enter the length of side b:");
        double b = scanner.nextDouble();

        System.out.println("Enter the length of side c:");
        double c = scanner.nextDouble();

        double s = (a + b + c) / 2;
        double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
        System.out.println("The area of the triangle is: " + area);

        scanner.close();
    }
}


/*
 an example of calculating the area of a triangle
 using the height and base of the triangle (base x height) in Java:

import java.util.Scanner;

public class upGradTutorials {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the base of the triangle:");
        double base = scanner.nextDouble();

        System.out.println("Enter the height of the triangle:");
        double height = scanner.nextDouble();

        double area = (base * height) / 2;
        System.out.println("The area of the triangle is: " + area);
    }
}


an example of calculating the area of a triangle in Java using a constructor:

import java.util.Scanner;

public class Triangle {
    private double base;
    private double height;
    private double area;

    public Triangle (double base, double height) {
        this.base = base;
        this.height = height;
    }

    public void calculateArea() {
        area = (base * height) / 2;
    }

    public double getArea() {
        return area;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the base of the triangle:");
        double base = scanner.nextDouble();

        System.out.println("Enter the height of the triangle:");
        double height = scanner.nextDouble();

        Triangle triangle = new Triangle(base, height);
        triangle.calculateArea();

        System.out.println("The area of the triangle is: " + triangle.getArea());
    }
}



FINDING AREA OF TRIANGLE IN JAVA USING USER-DEFINED METHOD
import java.util.Scanner;

public class upGradTutorials {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the base of the triangle:");
        double base = scanner.nextDouble();

        System.out.println("Enter the height of the triangle:");
        double height = scanner.nextDouble();

        double area = calculateTriangleArea(base, height);

        System.out.println("The area of the triangle is: " + area);
    }

    public static double calculateTriangleArea(double base, double height) {
        return (base * height) / 2;
    }
}




FINDING THE AREA OF A TRIANGLE IN JAVA USING OBJECT-ORIENTED PROGRAMMING
Here is an example of calculating the area of a triangle in Java using object-oriented programming:

import java.util.Scanner;

public class Triangle {
    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle(double a, double b, double c) {
        sideA = a;
        sideB = b;
        sideC = c;
    }

    public double calculateArea() {
        double s = (sideA + sideB + sideC) / 2;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the length of side A:");
        double sideA = scanner.nextDouble();

        System.out.println("Enter the length of side B:");
        double sideB = scanner.nextDouble();

        System.out.println("Enter the length of side C:");
        double sideC = scanner.nextDouble();

        Triangle triangle = new Triangle(sideA, sideB, sideC);
        double area = triangle.calculateArea();

        System.out.println("The area of the triangle is: " + area);
    }
}
 */