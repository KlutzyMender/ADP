import finddatefindtime.FindDateFindTime;

public class CreateCalendarVisuals
{
public static void main(String[] args)
{
        FindDateFindTime d = new FindDateFindTime();

        System.out.println("Year: " + d.currentYear());
        System.out.println("Month: " + d.currentMonth());
        System.out.println("Day: " + d.currentDay());

        System.out.println("test: " + d.lengthOfMonth(2021, 1));
        System.out.println("test: " + d.dayOfWeek(2021, 1, 31));
        System.out.println("test: " + d.dayOfWeekForStartAndEndOfMonths(2021)[1]);

}
}
