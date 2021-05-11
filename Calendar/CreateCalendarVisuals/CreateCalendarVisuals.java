import finddatefindtime.FindDateFindTime;
// import classes need to draw in java
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.*;
import javax.swing.JFrame;

public class CreateCalendarVisuals extends Canvas
{
  public static void main(String[] args)
  {
    //starts the canvas
    JFrame frame = new JFrame("My Drawing");
    Canvas canvas = new CreateCalendarVisuals();
    canvas.setSize(1050, 750);
    frame.add(canvas);
    frame.pack();
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public void paint(Graphics g)
  {
    makeCalendar(g);
    //drawDateRect(0, 0, 150, 150, 0, Color.BLUE,  g);
    //drawDateRect(150, 0, 150, 150, 1, Color.GRAY,  g);
  }

  // function to draw a box for the date
  public void makeCalendar(Graphics g)
  {
    // variables for the boxes...
    int x = 0; // creats the variable to store the x location of the day boxes on the calendar
    int y = 0; // creats the variable to store the y location of the day boxes on the calendar
    int width = 110; // creats the variable to store the width of the day boxes on the calendar
    int height = 110; // creats the variable to store the height of the day boxes on the calendar

    // FindDateFindTime class...
    FindDateFindTime d = new FindDateFindTime(); // starts my FindDateFindTime class


    //for(int i = 1; i <= 12; i++)
    //{
      int startOfMonth = d.dayOfWeek(2021, 5, 1); // find the start of the month
      int dayofmonth = 1; // variable to store the day of the month to be printed

      //prints 0 for all the days leading up to the first of the month
      // som means start of month but i have already used that variable
      for(int som = 0; som < startOfMonth; som++)
      {
        drawDateRect(x, y, width, height, 0, Color.GRAY,  g);
        x += width;
      }

      //start a while loop to print all days in the first week
      while(startOfMonth != 7)
      {
        // prints the day in the first week
        drawDateRect(x, y, width, height, dayofmonth, Color.DARK_GRAY,  g);

        x += width;
        dayofmonth++;
        startOfMonth++;
      }
      x = 0;
      y += height;

      // starts the loop to wright all the days of month
      for(int w = 0; w < 5; w++)
      {
        //loops and prints the days for the week
        for(int daysofweek = 0; daysofweek < 7; daysofweek++)
        {
          // if the day of month is bigger then the number of days in a month
          // then print 00
          if(dayofmonth > d.lengthOfMonth(2021, 5))
          {
            //prints 00 to represent the days that are not in that month
            drawDateRect(x, y, width, height, 0, Color.GRAY,  g);
            x += width;
          }
          //prints all the days of the month
          else
          {
            // if the day in less then 10 print a zero at the start to make them all 2 digit
            if(dayofmonth < 10)
            {
              //print the day of the month ith a 0 at the start
              drawDateRect(x, y, width, height, dayofmonth, Color.DARK_GRAY,  g);

              x += width;
              dayofmonth++;
            }
            // if the number is greater then 0
            else
            {
              //prin the days of the month
              drawDateRect(x, y, width, height, dayofmonth, Color.DARK_GRAY,  g);

              x += width;
              dayofmonth++;
            }
          }
        }
        // starts a new line for the new week
        x = 0;
        y += height;
      }
    //}

  } // end of function

  public void drawDateRect(int x, int y, int width, int height, int day, Color boxColor, Graphics g)
  {
    int fontSize = 25;

    String dayString = "";
    dayString += day;

    g.setColor(boxColor); // changes the color
    // creates a rect to show the date
    g.fillRect(x, y, width, height); // starts at location x and y and has a width of width

    g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize)); // sets a new font
    g.setColor(Color.WHITE); // changes the color
    // if day has 2 characters then move to the left by 2* the font size
    if(day >= 10)
    {
      g.drawString(dayString, x + width - (fontSize*2), y + fontSize); // prints the day of the month
    }
    //if the day is only one character then move to the left by fontSize
    else
    {
      g.drawString(dayString, x + width - fontSize, y + fontSize); // prints the day of the month
    }
  }
} // end of class
