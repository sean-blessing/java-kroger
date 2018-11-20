import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Set;

public class TimeZoneApp {

	public static void main(String[] args) {
		LocalDate ld = LocalDate.now();
		LocalDateTime ldt = LocalDateTime.now();
		
		System.out.println("Current Date:  "+ld);
		System.out.println("Current DateTime:  "+ldt);

		ZonedDateTime zdt = ZonedDateTime.now();
		
		System.out.println("Zoned Current DateTime:  "+zdt);
		
		ZonedDateTime ezdt = ZonedDateTime.now(ZoneId.of("Europe/Paris"));
		System.out.println("Zoned Current DateTime Paris:  "+ezdt);
		
//		System.out.println("List of all available zones:  ");
//		Set<String> zoneIds = ZoneId.getAvailableZoneIds();
//		zoneIds.stream().forEach(System.out::println);
		
		System.out.println("Get a current date then change the timezone:");
		ldt = LocalDateTime.now();
		System.out.println("current: "+ldt);
		ZoneId zid = ZoneId.of("Europe/Paris");
		zdt = ZonedDateTime.of(ldt,zid);
		zdt = ldt.atZone(zid);  // this also works
		System.out.println("Europe / Paris:  "+zdt);
		System.out.println("convert the zoneddatetime to a date w/out time...");
		ld = zdt.toLocalDate();
		System.out.println("just the date:  "+ld);
		
		System.out.println("Get a current date then change the timezone:");
		ldt = LocalDateTime.now();
		System.out.println(ldt);
		ZonedDateTime zdt2 = ZonedDateTime.now();
		ZonedDateTime zdt3 = zdt2.withZoneSameInstant(zid);
		System.out.println(zdt3);
		
		
	}

}
