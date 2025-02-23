public class MyCircle {
    private MyPoint center;
    private int radius;

    public MyCircle() {
    }

    public MyCircle(MyPoint center, int radius) {
        this.center = center;
        this.radius = radius;
    }

    public MyCircle(int x, int y, int radius) {
        this.center = new MyPoint(x,y);
        this.radius = radius;
    }

    public MyPoint getCenter() {
        return center;
    }

    public void setCenter(MyPoint center) {
        this.center = center;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getCenterX(){
        return this.center.getX();
    }
    public int getCenterY(){
        return this.center.getY();
    }

    public void setCenterX(int x){
        this.center.setX(x);
    }

    public void setCenterY(int y){
        this.center.setX(y);
    }

    public int[] getCenterXY() {
        return this.center.getXY();
    }

    public void setCenterXY(int x, int y) {
        this.center.setXY(x,y);
    }

    public double getArea(){
        return Math.pow(this.radius, 2) * Math.PI;
    }

    public double getCircumference(){
        return this.radius * 2 * Math.PI;
    }

    public double distance(MyCircle another){
        return this.center.distance(another.center);
    }

    @Override
    public String toString() {
        return "MyCircle[" + "radius=" +radius+",center=" + this.center.toString() + ']';
    }
}
