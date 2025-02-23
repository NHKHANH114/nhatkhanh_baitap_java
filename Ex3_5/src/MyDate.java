import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
public class MyDate {

    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        String dateString = String.format("%d-%d-%d", year, month, day);
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
        } catch (ParseException ex) {
            Logger.getLogger(MyDate.class.getName()).log(Level.SEVERE, null, ex);
        }
        dateString = new SimpleDateFormat("EEEE d MMM yyyy").format(date);
        return dateString;
    }

    public MyDate nextYear() {
        this.year++;
        return this;
    }

    public MyDate nextMonth() {
        this.month++;
        return this;
    }

    public MyDate nextDay() {
        this.day++;
        return this;
    }

    public MyDate previousYear() {
        this.year--;
        return this;
    }

    public MyDate previousMonth() {
        this.month--;
        return this;
    }

    public MyDate previousDay() {
        this.day--;
        return this;
    }
}