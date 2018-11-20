import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;

public class DateTimeApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the date time app");

		LocalDate ld = LocalDate.now();
		System.out.println("Current Date = "+ld);
		
		LocalTime lt = LocalTime.now();
		System.out.println("Current Time = "+lt);
		lt = LocalTime.NOON;
		System.out.println(lt);
		
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println("Current DateTime = "+ldt);
		LocalDate ld1 = ldt.toLocalDate();
		
		LocalDate halloween = LocalDate.of(2018, 10, 31);
		LocalDate thanksgiving = LocalDate.parse("2018-11-22");
		LocalDate christmas = LocalDate.of(2018, 12, 25);
		
		System.out.println("Halloween = "+halloween);
		System.out.println("Thanksgiving = "+thanksgiving);
		
		System.out.println(christmas.getMonth());
		System.out.println(christmas.getMonthValue());
		System.out.println(christmas.getDayOfYear());
		System.out.println(christmas.getDayOfWeek());
		
		System.out.println(halloween.isBefore(thanksgiving));
		System.out.println(thanksgiving.compareTo(halloween));
		System.out.println(thanksgiving.compareTo(thanksgiving));
		System.out.println(thanksgiving.compareTo(christmas));
		
		LocalDate newLD = christmas.withMonth(7);
		System.out.println(newLD);
		
		LocalDate newYearsEve = LocalDate.of(2018, 12, 31);
		LocalDate feb28 = newYearsEve.withMonth(2);
		System.out.println(feb28);
		
		LocalDate newDate = feb28.plus(3, ChronoUnit.DAYS);
		System.out.println(newDate);
		
		long days = thanksgiving.until(christmas, ChronoUnit.DAYS);
		System.out.println(days);
		
		days = ChronoUnit.DAYS.between(christmas, halloween);
		System.out.println(days);
		
		DateTimeFormatter df = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
		System.out.println(df.format(christmas));
		
		System.out.println("Bye");
	}

}
