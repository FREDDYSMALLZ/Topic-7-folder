import java.util.Calendar;
import java.util.GregorianCalendar;

public class Chapter13Exercise {
	private static Calendar calendar;

	public static void main(String[] args) {
	
		if (args.length > 2 || args.length == 0) {
            System.out.println("Invalid arguments");
            System.out.println("Usage: Chapter13Exercise 2017");
            System.exit(1);
        }

        int year;
        if (args.length == 1) {
            year = Calendar.getInstance().get(Calendar.YEAR);
        } else {
            year = new Integer(args[1]);
        }
        int month = Integer.parseInt(args[0]) - 1;
        calendar = new MyCalendar(year, month, 1);
        calendar.set(Calendar.DATE, 1);

        printMonth();
    }

    public static void printMonth() {
        printMonthTitle();

        printMonthBody();
    }

    public static void printMonthTitle() {
        System.out.println("         " + ((MyCalendar) calendar).getMonthName()
                + " " + calendar.get(Calendar.YEAR));
        System.out.println("-----------------------------");
        System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
    }

    public static void printMonthBody() {
                int startDay = calendar.get(Calendar.DAY_OF_WEEK) - 1;

        int numberOfDaysInMonth = ((MyCalendar) calendar).daysInMonth();

        int i = 0;
        for (i = 0; i < startDay; i++)
            System.out.print("    ");

        for (i = 1; i <= numberOfDaysInMonth; i++) {
            System.out.printf("%4d", i);

            if ((i + startDay) % 7 == 0)
                System.out.println();
        }

        System.out.println();
    }

	}
 class MyCalendar extends GregorianCalendar {


	public MyCalendar(int year, int month, int dayOfMonth) {
        super(year, month, dayOfMonth);

    }

    public String getMonthName() {
        return getMonthName(get(MONTH));
    }

    public static String getMonthName(int month) {
        String monthName =" ";

        switch (month) {
            case 1: monthName = "January"; break;
            case 2: monthName = "February"; break;
            case 3: monthName = "March"; break;
            case 4: monthName = "April"; break;
            case 5: monthName = "May"; break;
            case 6: monthName = "June"; break;
            case 7: monthName = "July"; break;
            case 8: monthName = "August"; break;
            case 9: monthName = "September"; break;
            case 10: monthName = "October"; break;
            case 11: monthName = "November"; break;
            case 12: monthName = "December"; break;
            
        }

        return monthName;
    }

    public static String getDayOfWeekName(int day) {
        String dayOfWeekName = " ";

        day = day % 7;

        switch (day) {
            case 1: dayOfWeekName = "Sunday"; break;
            case 2: dayOfWeekName = "Monday"; break;
            case 3: dayOfWeekName = "Tuesday"; break;
            case 4: dayOfWeekName = "Wednesday"; break;
            case 5: dayOfWeekName = "Thursday"; break;
            case 6: dayOfWeekName = "Friday"; break;
            case 7: dayOfWeekName = "Saturday"; break;
          
        }

        return dayOfWeekName;
    }

    public int daysInMonth() {
        switch (get(MONTH)) {
            case 0:
            case 2:
            case 4:
            case 6:
            case 7:
            case 9:
            case 11:
                return 31;
            case 1:
                if (isLeapYear(get(YEAR))) return 29;
                else return 28;
            case 3:
            case 5:
            case 8:
            case 10:
                return 30;
            default: return 0;
        }
    }
 }



