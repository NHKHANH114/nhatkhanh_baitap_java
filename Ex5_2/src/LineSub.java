public class LineSub extends Point {

    private Point end;

    public LineSub(Point begin, Point end) {
        super(begin.getX(), begin.getY());
        this.end = end;
    }

    public LineSub(int beginX, int beginY, int endX, int endY) {
        super(beginX, beginY);
        this.end = new Point(endX, endY);
    }

    @Override
    public String toString() {
        return "LineSub[" + "begin=" + super.toString() + ",end=" + end + ']';
    }

    public Point getBegin() {
        return new Point(super.getX(), super.getY());
    }

    public Point getEnd() {
        return this.end;
    }

    public void setBegin(int beginX, int beginY) {
        setXY(beginX, beginY);
    }

    public void setEnd(int endX, int endY) {
        this.end.setXY(endX, endY);
    }

    public int getBeginX() {
        return getX();
    }

    public int getBeginY() {
        return getY();
    }

    public int getEndX() {
        return this.end.getX();
    }

    public int getEndY() {
        return this.end.getY();
    }

    public void setBeginX(int beginX) {
        setX(beginX);
    }

    public void setBeginY(int beginY) {
        setY(beginY);
    }

    public void setBeginXY(int beginX, int beginY) {
        setXY(beginX, beginY);
    }

    public void setEndX(int endX) {
        this.end.setX(endX);
    }

    public void setEndY(int endY) {
        this.end.setY(endY);
    }

    public void setEndXY(int endX, int endY) {
        this.end.setXY(endX, endY);
    }

    public int getLength() {
        return (int)(Math.sqrt(Math.pow(this.end.getX()-super.getX(), 2)+ Math.pow(this.end.getY()-super.getY(), 2)));
    }
    public double getGradient() {
        return (double)(Math.atan2(this.end.getY()-super.getY(), this.end.getX()-super.getX()));
    }
}