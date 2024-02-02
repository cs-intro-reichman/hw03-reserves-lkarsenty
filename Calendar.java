public class Calendar1 {	
    
	static int dayOfMonth = 1;   
	static int month = 1;
	static int year = 1900;
	static int dayOfWeek = 2;     // 1.1.1900 was a Monday
	static int nDaysInMonth = 31; // Number of days in January
	

	public static void main(String args[]) {
		int givenyear = Integer.parseInt(args[0]);
	    int debugDaysCounter = 0; 
		int sundaysCount = 0;
	 	
		
   	 while (year <= givenyear) {
   	     advance();
   	     debugDaysCounter++;
			if (year == givenyear) {
				if (dayOfWeek == 1){
					System.out.println(dayOfMonth + "/" + month + "/" + year + " Sunday");
				} else {
					System.out.println(dayOfMonth + "/" + month + "/" + year);
				}
			}
     }
			
		
	}
	

	private static void advance() {

	dayOfWeek++;
	dayOfMonth++;

    if (dayOfWeek > 7) {
        dayOfWeek = 1;
     }   

        if (dayOfMonth > nDaysInMonth) {
            dayOfMonth = 1;
            month++;
			

            if (month > 12) {
                month = 1;
                year++;

             } 
		
		nDaysInMonth = nDaysInMonth(month, year);  
            
        }
}
		 
    // Returns true if the given year is a leap year, false otherwise.
	private static boolean isLeapYear(int year) {
	    boolean isLeapYear;
		isLeapYear = ((year % 400 ) == 0) || (((year % 4) == 0) && ((year % 100)!= 0));
			
		return isLeapYear;
	}
	 

	private static int nDaysInMonth(int month, int year) {
   	 	int days;

   	 	switch(month) {
       	 case 2:
        	    days = isLeapYear(year) ? 29 : 28;
        	    break;
      	 case 4:
       	 case 6:
       	 case 9:
       	 case 11:
            days = 30;
            break;
        default:
            days = 31;
    	}
   		return days;
 	}
}
