/**
 *  File name     :  CalendarStuff.java
 *  Purpose       :  Provides a class with supporting methods for CountTheDays.java program
 *  Author        :  B.J. Johnson (prototype)
 *  Date          :  2017-01-02 (prototype)
 *  Author        :  Jason Wong
 *  Date          :  1-20-2016
 *  Description   :  This file provides the supporting methods for the CountTheDays program which will
 *                   calculate the number of days between two dates.  It shows the use of modularization
 *                   when writing Java code, and how the Java compiler can "figure things out" on its
 *                   own at "compile time".  It also provides examples of proper documentation, and uses
 *                   the source file header template as specified in the "Greeter.java" template program
 *                   file for use in CMSI 186, Spring 2017.
 *  Notes         :  None
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ----------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-01-02  B.J. Johnson  Initial writing and release
 */
public class CalendarStuffEmpty {

   private static final int SUNDAY    = 0;
   private static final int MONDAY    = SUNDAY    + 1;
   private static final int TUESDAY   = MONDAY    + 1;
   private static final int WEDNESDAY = TUESDAY   + 1;
   private static final int THURSDAY  = WEDNESDAY + 1;
   private static final int FRIDAY    = THURSDAY  + 1;
   private static final int SATURDAY  = FRIDAY    + 1;

   private static final int JANUARY    = 0;
   private static final int FEBRUARY   = JANUARY   + 1;
   private static final int MARCH      = FEBRUARY  + 1;
   private static final int APRIL      = MARCH     + 1;
   private static final int MAY        = APRIL     + 1;
   private static final int JUNE       = MAY       + 1;
   private static final int JULY       = JUNE      + 1;
   private static final int AUGUST     = JULY      + 1;
   private static final int SEPTEMBER  = AUGUST    + 1;
   private static final int OCTOBER    = SEPTEMBER + 1;
   private static final int NOVEMBER   = OCTOBER   + 1;
   private static final int DECEMBER   = NOVEMBER  + 1;

   private static int[]    days        = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

   public CalendarStuffEmpty() {
      System.out.println( "Constructor called..." );
   }

   public static boolean isLeapYear( long year ) {
     if (year % 400 == 0 || year%100!=0 && year % 4 == 0){
       return true;
     }
      return false;
   }

   public static long daysInMonth( long month, long year ) {
     if(month==2 && isLeapYear(year)){
        return 29;
     } else {
      return days [(int)month-1];
   }

   public static boolean dateEquals( long month1, long day1, long year1, long month2, long day2, long year2 ) {
     if (day1==day2 && month1==month2 && year1=year2){
      return true;
    }
      return false;
   }

   public static int compareDate( long month1, long day1, long year1, long month2, long day2, long year2 ) {
      return 0;
   }


public static boolean isValidDate( long month, long day, long year ) {
 if (year <=0 || day<1 || day > daysInMonth(month,year) || month> 12 || month< 1){
 return false;
 }
       return true;
    }

   public static String toMonthString( int month ) {
      switch( month - 1 ) {
         default: throw new IllegalArgumentException( "Illegal month value given to 'toMonthString()'." );
      }
   }

   public static String toDayOfWeekString( int day ) {
      switch( day - 1 ) {
         default: throw new IllegalArgumentException( "Illegal day value given to 'toDayOfWeekString()'." );
      }
   }
public static long daysBetween( long month1, long day1, long year1, long month2, long day2, long year2 ) {

      long dayTest = (day2 - day1);
      long monthTest = ((month2 - month1) *30);
      long yearTest = ((year2 - year1) * 365);
      long daysBetween1 = dayTest + monthTest + yearTest;

      long dayTestb = (day1 - day2);
      long monthTestb = ((month1 - month2)*30);
      long yearTestb = ((year1 - year 2)*365);
      long daysBetweenb = dayTestb + monthTestb + yearTestb;

      if (year2 - year1 >= 0 && year2 =! 2 && year1 =! 2){
        return daysBetween1;

      } else if (year1 - year2 >= 0 && year2 =! 2 && year1 =! 2){
         return dayBetweenb;

      } else if (year2 - year1 >= 0 && year2 == 2){
        return yearTest + dayTest;

      } else if (year1 - year2 >= 0 && year1 == 2){
        return yearTestb + dayTestb;
        
      } else if (year2 - year1 >= 0 && year2 == 2 && year1 == 2){
        return yearTest + dayTest;

      } else if (year1- year2 >= 0 && year2 == 2 && year1 == 2){
        return yearTestb + dayTestb;
      }
      return 0;
   }
}
