import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

public class TimeZoneApp2 {

	public static void main(String[] args) {
	
		
		ZonedDateTime zdt = ZonedDateTime.now();
		System.out.println(zdt);
		
		ZonedDateTime july4 = ZonedDateTime.of(2018, 7, 4, 12, 0, 0, 0, ZoneId.of("America/New_York"));
		System.out.println(july4);
		
		ZonedDateTime ezdt = ZonedDateTime.now(ZoneId.of("Europe/Paris"));
		System.out.println("Zoned Current DateTime Paris:  "+ezdt);
		
		ZonedDateTime azdt = ZonedDateTime.now(ZoneId.of("America/Phoenix"));
		System.out.println("Zoned Current DateTime Arizona:  "+azdt);
		System.out.println("List of all available zones:  ");
		Set<String> zoneIds = ZoneId.getAvailableZoneIds();
		zoneIds.stream().forEach(System.out::println);

		ZonedDateTime ldt = ZonedDateTime.now();
		System.out.println();
		ZoneId zid = ZoneId.of("America/Phoenix");
		ZonedDateTime azzdt = ldt.of(ldt.toLocalDateTime(), zid);
		System.out.println(azzdt);
		
	}

}
