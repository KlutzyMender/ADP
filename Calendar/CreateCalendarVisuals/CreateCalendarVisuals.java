import finddatefindtime.FindDateFindTime;

public class CreateCalendarVisuals
{
public static void main(String[] args)
{
        FindDateFindTime d = new FindDateFindTime();

        System.out.println("Year: " + d.currentYear());
        System.out.println("Month: " + d.currentMonth());
        System.out.println("Day: " + d.currentDay());

        System.out.print("test: " + d.lengthOfAllMonthsInYear(2021)[0]);

}
}
