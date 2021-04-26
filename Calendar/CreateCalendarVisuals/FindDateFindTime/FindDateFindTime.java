package finddatefindtime;

import java.time.LocalDate;
import java.time.DayOfWeek;
import java.time.LocalTime;

public class FindDateFindTime
{
public static void main(String[] args)
{
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();

        System.out.println("Date: " + date + "; Time: " + time);
}

public int dayOfWeek(int year, int month, int day)
{
        LocalDate date = LocalDate.of(year, month, day);

        DayOfWeek d = date.getDayOfWeek();
        return d.getValue();
}
}
