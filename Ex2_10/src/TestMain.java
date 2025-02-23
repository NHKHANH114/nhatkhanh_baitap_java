class TestMain{
    public static void main(String[] args) {
        MyRectangle myRectangle = new MyRectangle(new MyPoint(4,8), new MyPoint(14,2));
        System.out.println(myRectangle.getArea());
        System.out.println(myRectangle.getPerimeter());
        System.out.println(myRectangle);
        System.out.println(myRectangle.getFullPoint());
    }
} 