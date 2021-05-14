import finddatefindtime.FindDateFindTime;
// import classes need to draw in java
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.*;
import javax.swing.JFrame;

import java.awt.*;
import java.awt.event.*;

import java.util.ArrayList; // import the ArrayList class

public class CreateCalendarVisuals extends Canvas implements MouseListener
{
  FindDateFindTime d = new FindDateFindTime(); // starts my FindDateFindTime class

  public int calendarDisplayedMonth = d.currentMonth();
  public int calendarDisplayedYear = d.currentYear();

  public final int calendarStarting_X_Location = 100;
  public final int calendarStarting_Y_Location = 100;

  ArrayList<Integer> xArray = new ArrayList<Integer>(); // Create an ArrayList object
  ArrayList<Integer> yArray = new ArrayList<Integer>(); // Create an ArrayList object
  ArrayList<Integer> widthArray = new ArrayList<Integer>(); // Create an ArrayList object
  ArrayList<Integer> heightArray = new ArrayList<Integer>(); // Create an ArrayList object

  CreateCalendarVisuals()
  {
    addMouseListener(this);
  }

  static JFrame frame = new JFrame("My Drawing");
  static Canvas canvas = new CreateCalendarVisuals();

  public static void main(String[] args)
  {
    //starts the canvas
    canvas.setSize(1050, 750);
    frame.add(canvas);
    frame.pack();
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    new CreateCalendarVisuals();
  } // end of main function

  public void paint(Graphics g)
  {
    // FindDateFindTime class...
    makeCalendar(calendarDisplayedMonth, calendarDisplayedYear, g);
    makeTitleBar();
  } // end of paint finction

  // function to draw a box for the date
  public void makeCalendar(int month, int year, Graphics g)
  {
    // variables for the boxes...
    int x = calendarStarting_X_Location; // creats the variable to store the x location of the day boxes on the calendar
    int y = calendarStarting_Y_Location; // creats the variable to store the y location of the day boxes on the calendar
    int width = 110; // creats the variable to store the width of the day boxes on the calendar
    int height = 110; // creats the variable to store the height of the day boxes on the calendar

    // FindDateFindTime class...
    FindDateFindTime d = new FindDateFindTime(); // starts my FindDateFindTime class

    //for(int i = 1; i <= 12; i++)
    //{
      int startOfMonth = d.dayOfWeek(year, month, 1); // find the start of the month
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
      x = calendarStarting_X_Location;
      y += height;

      // starts the loop to wright all the days of month
      for(int w = 0; w < 5; w++)
      {
        //loops and prints the days for the week
        for(int daysofweek = 0; daysofweek < 7; daysofweek++)
        {
          // if the day of month is bigger then the number of days in a month
          // then print 00
          if(dayofmonth > d.lengthOfMonth(year, month))
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
        x = calendarStarting_X_Location;
        y += height;
      }
  } // end of makeCalendar function

  public void drawDateRect(int x, int y, int width, int height, int day, Color boxColor, Graphics g)
  {
    int fontSize = 25; // sents the font size for the text
    String dayString = " "; // creats a String to store the day because you can't print int's

    if(day != 0) // if day == 0 then that is not a date in the month so we print nothing
    {
      dayString += day; // add the day to a String if day is > 0
    }

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
  } // end of drawDateRect function

  public void makeTitleBar()
  {
    Graphics g = getGraphics(); // gets the Graphics class to be able to draw

    g.setColor(Color.LIGHT_GRAY);
    g.fillRect(0, 0, canvas.getWidth(), 100);

    g.setColor(Color.BLACK);
    g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
    g.drawString(d.MonthAsString(calendarDisplayedMonth), 485-d.MonthAsString(calendarDisplayedMonth).length(), 80);

    makeButton(0, 0, 100, 50, Color.GRAY, "<---");
    makeButton(101, 0, 100, 50, Color.GRAY, "--->");
  }

  public void makeButton(int x, int y, int width, int height,  Color boxColor, String symbole)
  {
    Graphics g = getGraphics(); // gets the Graphics class to be able to draw
    g.setFont(new Font("TimesRoman", Font.PLAIN, 20));

    xArray.add(x);
    yArray.add(y);
    widthArray.add(width);
    heightArray.add(height);
    g.setColor(Color.BLACK);
    g.drawRect(x, y, width, height);
    g.setColor(boxColor); // changes the color
    // creates a rect to show the date
    g.fillRect(x, y, width, height); // starts at location x and y and has a width of width
    g.setColor(Color.BLACK);
    g.drawString(symbole, x + width/2 - symbole.length(), height /2 +10);
  } // end of makeButton class

  // this function will run everytime the mouse is clicked
  public void mouseClicked(MouseEvent event)
  {
    Graphics g = getGraphics(); // gets the Graphics class to be able to draw


    //loops through all the buttons that we have made
    for(int i = 0; i < xArray.size(); i++)
    {
      double mouseX = MouseInfo.getPointerInfo().getLocation().x; // makes a variable to store the mouse x location
      double mouseY = MouseInfo.getPointerInfo().getLocation().y; // makes a variable to store the mouse y location

      // if the mouse is within the x position of the button
      if(mouseX >= xArray.get(i) && mouseX <= xArray.get(i) + widthArray.get(i))
      {
        // if the mouse is within the y position of the button
        if(mouseY >= yArray.get(i) && mouseY <= yArray.get(i) + 2*heightArray.get(i))
        {
          // clear the screen below y = 50
          g.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
          // if button 1
          if(i == 0)
          {
            calendarDisplayedMonth -= 1;

            if(calendarDisplayedMonth <= 0)
            {
              calendarDisplayedMonth = 12;
              calendarDisplayedYear -= 1;
            }
            System.out.println(calendarDisplayedMonth);
            // remakes the calendar but one month back
            makeCalendar(calendarDisplayedMonth, calendarDisplayedYear, g);
            makeTitleBar();
            break; // stops the loop
          }
          // if button 2
          if(i == 1)
          {
            calendarDisplayedMonth += 1;

            if(calendarDisplayedMonth >= 13)
            {
              calendarDisplayedMonth = 1;
              calendarDisplayedYear += 1;
            }

            System.out.println(calendarDisplayedMonth);
            // remakes the calendar but one month forward
            makeCalendar(calendarDisplayedMonth, calendarDisplayedYear, g);
            makeTitleBar();
            break; // stops the loop
          }
        }
      }
    }
  }
  // I only need the mouseClicked function but you have to put them all in inorder to work
  // this function will run everytime the mouse is pressed
  public void mousePressed(MouseEvent e){}
  // this function will run everytime the mouse has entered
  public void mouseEntered(MouseEvent e){}
  // this function will run everytime the mouse has exited
  public void mouseExited(MouseEvent e){}
    // this function will run everytime the mouse is released
  public void mouseReleased(MouseEvent e){}
} // end of class
