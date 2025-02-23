import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

class TestMain {

    public static boolean isLeapYear(int year) {
        if(year % 400 == 0){
            return true;
        }
        if (year % 4 == 0 && year % 100 != 0){
            return true;
        }
        return false;
    }

    public static boolean isValidDate(int year, int month, int day) {
        String dateString = String.format("%d-%d-%d", year, month, day);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(dateString);
        } catch (ParseException pe) {
            return false;
        }
        return true;
    }

    public static int getDayOfWeek(int year, int month, int day) {
        String[] weeks = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

        String dateString = String.format("%d-%d-%d", year, month, day);
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);

        } catch (ParseException ex) {
            Logger.getLogger(MyDate.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        dateString = new SimpleDateFormat("EEEE").format(date);
        int d=0;
        for(String week: weeks){
            if(week.equals(dateString)) break;
            d++;
        }
        return d;
    }

    public static void main(String[] args) {
        MyDate d1 = new MyDate(2016, 2, 28);
        System.out.println(d1);
        System.out.println(d1.nextDay());
        System.out.println(d1.nextDay());
        System.out.println(d1.nextMonth());
        System.out.println(d1.nextYear());

        MyDate d2 = new MyDate(2019, 1, 2);
        System.out.println(d2);
        System.out.println(d2.previousDay());
        System.out.println(d2.previousDay());
        System.out.println(d2.previousMonth());
        System.out.println(d2.previousYear());

        MyDate d3 = new MyDate(2012, 2, 29);
        System.out.println(d3.previousYear());
        MyDate d4 = new MyDate(2029, 4, 31);
        MyDate d5 = new MyDate(2011, 2, 29);
        System.out.println(d4);
        System.out.println(d5);
        System.out.println(getDayOfWeek(2099, 10, 31));
        System.out.println(isValidDate(2099, 10, 32));
    }
}