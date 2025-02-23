import java.util.Arrays;

class TestMain{
    public static void main(String[] args) {
        MyLine myLine = new MyLine(new MyPoint(0, 1), new MyPoint(3, 4));
        System.out.println(myLine.getLength());
        System.out.println(myLine.getGradient());
        System.out.println(myLine.toString());
        System.out.println(Arrays.toString(myLine.getBeginXY()));
        System.out.println(Arrays.toString(myLine.getEndXY()));
    }
}