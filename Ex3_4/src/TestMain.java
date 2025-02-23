class TestMain{
    public static void main(String[] args) {
        MyTime myTime = new MyTime(23,59,59);
        System.out.println(myTime);
        myTime.nextHour();
        System.out.println(myTime);
        myTime.nextSecond();
        System.out.println(myTime);
    }
}