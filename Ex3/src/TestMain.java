import java.util.Scanner;

public class TestMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter complex number 1 (real and imaginary part): ");
        double real1 = scanner.nextDouble();
        double imag1 = scanner.nextDouble();
        System.out.print("Enter complex number 2 (real and imaginary part): ");
        double real2 = scanner.nextDouble();
        double imag2 = scanner.nextDouble();
        MyComplex num1 = new MyComplex(real1, imag1);
        MyComplex num2 = new MyComplex(real2, imag2);
        System.out.println("Number 1 is: " + num1);
        if (num1.isReal()) {
            System.out.println(num1 + " is a pure real number");
        } else {
            System.out.println(num1 + " is NOT a pure real number");
        }
        if (num1.isImaginary()) {
            System.out.println(num1 + " is a pure imaginary number");
        } else {
            System.out.println(num1 + " is NOT a pure imaginary number");
        }
        System.out.println("\nNumber 2 is: " + num2);
        if (num2.isReal()) {
            System.out.println(num2 + " is a pure real number");
        } else {
            System.out.println(num2 + " is NOT a pure real number");
        }
        if (num2.isImaginary()) {
            System.out.println(num2 + " is a pure imaginary number");
        } else {
            System.out.println(num2 + " is NOT a pure imaginary number");
        }
        if (num1.equals(num2)) {
            System.out.println("\n" + num1 + " is equal to " + num2);
        } else {
            System.out.println("\n" + num1 + " is NOT equal to " + num2);
        }
        MyComplex sum = num1.addNew(num2);
        System.out.println("\n" + num1 + " + " + num2 + " = " + sum);
        scanner.close();
    }
}
