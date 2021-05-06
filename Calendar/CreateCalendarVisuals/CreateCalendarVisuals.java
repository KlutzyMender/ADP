import finddatefindtime.FindDateFindTime;

public class CreateCalendarVisuals
{
  public static void main(String[] args)
  {
    FindDateFindTime d = new FindDateFindTime();

    System.out.println("This months Calendar:");
    for(int i = 1; i <= 12; i++)
    {
      int startOfMonth = d.dayOfWeek(2021, i, 1); // find the start of the month
      int dayofmonth = 1; // variable to store the day of the month to be printed

      //prints 0 for all the days leading up to the first of the month
      // som means start of month but i have already used that variable
      for(int som = 0; som < startOfMonth; som++)
      {
        System.out.print("00, ");
      }

      //start a while loop to print all days in the first week
      while(startOfMonth != 7)
      {
        // prints the day in the first week
        System.out.print("0" + dayofmonth + ", ");
        dayofmonth++;
        startOfMonth++;
      }
      System.out.println(" "); // creates a new line for the next week

      // starts the loop to wright all the days of month
      for(int w = 0; w < 5; w++)
      {
        //loops and prints the days for the week
        for(int daysofweek = 0; daysofweek < 7; daysofweek++)
        {
          // if the day of month is bigger then the number of days in a month
          // then print 00
          if(dayofmonth > d.lengthOfMonth(2021, i))
          {
            //prints 00 to represent the days that are not in that month
            System.out.print("00, ");
          }
          //prints all the days of the month
          else
          {
            // if the day in less then 10 print a zero at the start to make them all 2 digit
            if(dayofmonth < 10)
            {
              //print the day of the month ith a 0 at the start
              System.out.print("0" + dayofmonth + ", ");
              dayofmonth++;
            }
            // if the number is greater then 0
            else
            {
              //prin the day of the month
              System.out.print(dayofmonth + ", ");
              dayofmonth++;
            }
          }
        }
        // starts a new line for the new week
        System.out.println(" ");
      }

      System.out.println("\n \n \n");
    }

  }
}
