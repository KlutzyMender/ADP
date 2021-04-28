package finddatefindtime; //creats a package (definds the name of the foler this file is in)

//imports:
import java.util.ArrayList;

import java.time.LocalDate; //import local date to find date
import java.time.DayOfWeek; // import day of week to be able to find the day of the week
import java.time.LocalTime; // import local time to find time

//create a class called FindDateFindTime
public class FindDateFindTime
{
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

  //class to find the currentDay
  public int currentDay()
  {
    return date.getDayOfMonth(); // returns the curent Day
  }

  public int[] lengthOfAllMonthsInYear(int year)
  {
    //creat an array to store each lenght of each month
    int[] lengthOfMonthsArray = new int[12];
    //starts a loop to find the lenght of each month for the given year
    for(int i = 1; i < 13; i++)
    {
      //adds the months lenght to the array
      lengthOfMonthsArray[i-1] = lengthOfMonth(year, i);
    }

    return lengthOfMonthsArray; // returns the lengthOfallMonths
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
