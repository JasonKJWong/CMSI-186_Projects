Public class CountTheDays { 

Public static void main (Strings args[]){

    long day1 = Long.parseLong(args[0]);
    long day2 = Long.parseLong(args[1]);
    long month1 = Long.parseLong(args[2]);
    long month2 = Long.parseLong(args[3]);
    long year1 = Long.parseLong(args[4]);
    long year2 = Long.parseLong(args[5]);
  
    long finalBetween = 0;
  
  
    if (args.length > 6 || args.length < 6){
      System.out.println("Error, Invalid");
      
    } else if (CalendarStuff.dateEquals(month1, day1, year1, month2, day2, year2) == true){
      System.out.println("Error, the dates that were inputted are equal");
    
    } else if (CalendarStuff.isValidDate(month1, day1, year1, month2, day2, year2) == true){
      System.out.println("Error, the dates that were inputted are invalid");
    }
  long finalBetween = CalendarStuff.daysBetween(month1, day1, year1, month2, day2, year2)
    System.out.println("The days in between the two inputted dates are: " + finalBetween");
                       }
  }
  
