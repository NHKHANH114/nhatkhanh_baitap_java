public class TestMain {
    public static void main(String[] args) {
        Circle circle1 = new Circle();
        Circle circle2 = new Circle(5.0);
        Circle circle3 = new Circle(7.0, "blue");
        System.out.println("Circle 1: " + circle1);
        System.out.println("Area of Circle 1: " + circle1.getArea());
        System.out.println("Circle 2: " + circle2);
        System.out.println("Area of Circle 2: " + circle2.getArea());
        System.out.println("Circle 3: " + circle3);
        System.out.println("Area of Circle 3: " + circle3.getArea());
        Cylinder cylinder1 = new Cylinder();
        Cylinder cylinder2 = new Cylinder(5.0);
        Cylinder cylinder3 = new Cylinder(5.0, 10.0);
        Cylinder cylinder4 = new Cylinder(5.0, 10.0, "green");
        Cylinder cylinder5 = new Cylinder(5.0, "red", 6.0, "blue");
        Cylinder cylinder6 = new Cylinder(10.0, 5.0, "red", 6.0, "blue");
        System.out.println("\nCylinder 1: " + cylinder1);
        System.out.println("Volume of Cylinder 1: " + cylinder1.getVolume());
        System.out.println("\nCylinder 2: " + cylinder2);
        System.out.println("Volume of Cylinder 2: " + cylinder2.getVolume());
        System.out.println("\nCylinder 3: " + cylinder3);
        System.out.println("Volume of Cylinder 3: " + cylinder3.getVolume());
        System.out.println("\nCylinder 4: " + cylinder4);
        System.out.println("Volume of Cylinder 4: " + cylinder4.getVolume());
        System.out.println("\nCylinder 5: " + cylinder5);
        System.out.println("Volume of Cylinder 5: " + cylinder5.getVolume());
        System.out.println("\nCylinder 6: " + cylinder6);
        System.out.println("Volume of Cylinder 6: " + cylinder6.getVolume());
    }
}
