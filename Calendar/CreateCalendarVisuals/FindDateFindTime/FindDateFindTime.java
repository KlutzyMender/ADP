package finddatefindtime; //creats a package (definds the name of the foler this file is in)

//imports:
import java.util.ArrayList;

import java.time.LocalDate; //import local date to find date
import java.time.DayOfWeek; // import day of week to be able to find the day of the week
import java.time.LocalTime; // import local time to find time

//create a class called FindDateFindTime
public class FindDateFindTime
{
  String[] monthsOfYear = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
  //store the local date class on the variable date
  LocalDate date = LocalDate.now(); // .now finds current date

  //class to find the currentYear
  public int currentYear()
  {
    return date.getYear(); // returns the curent year
  }

  //class to find the currentMonth
  public int currentMonth()
  {
    return date.getMonthValue(); // returns the curent month
  }

  public String MonthAsString(int month)
  {
    month -= 1;
    return monthsOfYear[month];
  }

  //class to find the currentDay
  public int currentDay()
  {
    return date.getDayOfMonth(); // returns the curent Day
  }

  public int lengthOfMonth(int year, int month)
  {
    //store the local date class on the variable date
    LocalDate dateof = LocalDate.of(year, month, 1);

    return dateof.lengthOfMonth();
  }
  // creats a function to find the day of the week for any given day of all time
  // the user will input a date to then find the day of the week that lands on
  public int dayOfWeek(int year, int month, int day)
  {
    //store the local date class on the variable date
    LocalDate dateof = LocalDate.of(year, month, day); // uses the user input to find day of week

    // gets the day of week with the inputed year, month and day
    DayOfWeek dow = dateof.getDayOfWeek();
    return dow.getValue(); // return the day of the week
  }
}
