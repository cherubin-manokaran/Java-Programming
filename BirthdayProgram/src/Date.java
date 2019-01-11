/**
 * @author Cherubin Manokaran
 * Programming Assignment 2
 * Date Class
 * cmanokaran@brandeis.edu
 */
public class Date {
	// The Date class is called to create a date object
	// Creates a date object for today's date 
	// Returns the year, month and day and returns the complete date as a string
    // Tests if a date is equal to another date and if the input year was a leap year
	// Returns the number of days in a month
	// Returns the day of week
	private int year = 1753;
	private int month = 1;
	private int day = 1;
	private int dayOfWeek = 0;
	private final int YEAR_OF_EPOCH = 1970;
	private final int MONTHS_IN_YEAR = 12;
	private final int FIRST_DAY_WEEK = 0;
	private final int LAST_DAY_WEEK = 6;
	String[] daysInWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
	
	// Creates a date object
	public Date(int year, int month, int day){
		this.year = year;
		this.month = month;
		this.day = day;
	}
	// Creates an object for today's date
	public Date(){
		int count = 0;
		while (this.year < YEAR_OF_EPOCH)
			this.nextDay();
		while (count < TeacherDate.getDaysSinceEpoch()){
			this.nextDay();
			count++;
		}
	}
	// Returns year
	public int getYear(){
		return this.year;
	}
	// Returns month
	public int getMonth(){
		return this.month;
	}
	// Returns day
	public int getDay(){
		return this.day;
	}
	// Returns date as string
	public String toString(){
		return this.year + "/" + this.month + "/" + this.day;
	}
	// Checks if the input object is an instance of Date
	// Returns true if the two dates are equal
	public boolean equals(Object input){
		if (input instanceof Date){
			Date dateToCompare = (Date) input;
			if ((this.year == dateToCompare.year) && (this.month == dateToCompare.month) && (this.day == dateToCompare.day))
				return true;
			else
				return false;
		}
		else
			return false;
	}
	// Returns true 
	public boolean isLeapYear(){
		if (this.year % 4 == 0 && this.year % 100 != 0 || this.year % 4 == 0)
			return true;
		else
			return false;
	}
	// Returns the number of days in a month
	public int daysInMonth(){
		// Checks if month has 31 days
		if ((this.month % 2 == 1 && this.month <= 7) || (this.month % 2 == 0 && this.month > 7))
			return 31;
		// Checks if month has 30 days
		else if (this.month == 4 ||  this.month == 6 || this.month == 9 || this.month == 11)
			return 30;
		// Checks if month is February and date occurred in a leap year
		else if (this.isLeapYear() && this.month == 2)
			return 29;
		else
			return 28;
	}
	public void nextDay(){
		// Checks if day less than the number of days in that month
		if (this.getDay() <= this.daysInMonth() - 1)
			this.day++;
		else {
			this.day = 1;
			this.month++;
		}
		// Checks if month is less than the number of months in a year
		if (this.getMonth() > this.MONTHS_IN_YEAR){
			this.month = 1;
			this.year++;
		}
	}
	public String getDayOfWeek(){
		Date startDate = new Date(1970, 1, 1);
		this.dayOfWeek = 3;
		
		// Increments by one day until input date has been reached
		while ((startDate.year < this.year) || (startDate.month < this.month)  || (startDate.day < this.day)) {
			startDate.nextDay();
			this.dayOfWeek++;
			if (this.dayOfWeek > LAST_DAY_WEEK)
				this.dayOfWeek = FIRST_DAY_WEEK;
		}
		return this.daysInWeek[this.dayOfWeek];
	}
}
