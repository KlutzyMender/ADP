import java.time.LocalDate;
import java.time.LocalTime;

public class FindDate_FindTime
{
public static void main(String[] args)
{
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();

        System.out.println("Date: " + date + "; Time: " + time);
}
}
