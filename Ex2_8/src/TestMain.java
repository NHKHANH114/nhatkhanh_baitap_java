import java.util.Arrays;

class TestMain{
    public static void main(String[] args) {
        MyCircle myCircle = new MyCircle(new MyPoint(5, 8), 6);
        System.out.println(myCircle.distance(new MyCircle(new MyPoint(30,46),2)));
        System.out.println(myCircle.getArea());
        System.out.println(myCircle.getCircumference());
        System.out.println(myCircle.toString());
        System.out.println(Arrays.toString(myCircle.getCenterXY()));
    }
}