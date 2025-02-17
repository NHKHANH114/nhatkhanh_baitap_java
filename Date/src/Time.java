
public class Time {
    private int hour;
    private int minute;
    private int second;

    public Time(int hour, int minute, int second){
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public void setTime(int hour, int minute, int second){
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }
    public Time nextSecond() {
        second++;
        if (second == 60) {
            second = 0;
            minute++;
        }
        if (minute == 60) {
            minute = 0;
            hour++;
        }
        if (hour == 24) {
            hour = 0;
        }
        return new Time(hour, minute, second);
    }
    public Time previousSecond() {
        int newHour = hour;
        int newMinute = minute;
        int newSecond = second - 1;

        if (newSecond < 0) {
            newSecond = 59;
            newMinute--;
        }
        if (newMinute < 0) {
            newMinute = 59;
            newHour--;
        }
        if (newHour < 0) {
            newHour = 23;
        }

        return new Time(newHour, newMinute, newSecond);
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", hour, minute, second); // Format the time as HH:MM:SS
    }
}
