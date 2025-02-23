class TestMain{
    public static void main(String[] args) {
        MyTriangle myTriangle = new MyTriangle(new MyPoint(5, 5), new MyPoint(15, 15), new MyPoint(5,25));
        System.out.println(myTriangle.getPerimeter());
        System.out.println(myTriangle.getType());
        System.out.println(myTriangle.getV1());
        System.out.println(myTriangle.getV2());
        System.out.println(myTriangle.getV3());
        System.out.println(myTriangle.toString());
    }
}