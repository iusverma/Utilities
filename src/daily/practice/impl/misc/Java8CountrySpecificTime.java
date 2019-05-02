package daily.practice.impl.misc;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class Java8CountrySpecificTime {
	
	public static void main(String ...args) {
		System.out.println("-------------------------------------------------");
		System.out.println("Sydney: "+getCurrentTimeStamp("Australia/Sydney"));
		System.out.println("-------------------------------------------------");
		System.out.println("Chicago: "+getCurrentTimeStamp("America/Chicago"));
		System.out.println("-------------------------------------------------");
		System.out.println("GMT: "+getCurrentTimeStamp("Etc/GMT"));
		System.out.println("-------------------------------------------------");
		System.out.println("Singapore: "+getCurrentTimeStamp("Asia/Singapore"));
		System.out.println("-------------------------------------------------");
		System.out.println("Darwin: "+getCurrentTimeStamp("Australia/Darwin"));
		System.out.println("-------------------------------------------------");
		System.out.println("India: "+getCurrentTimeStamp("Asia/Calcutta"));
		System.out.println("-------------------------------------------------");
		//temp();
	}

	private static Date getCurrentTimeStamp(String zone) {
		Instant instant = Instant.now();
		ZoneId zoneId = ZoneId.of( zone );
		ZonedDateTime zdt = ZonedDateTime.ofInstant( instant , zoneId );
		//System.out.println("zdt: "+zdt);

		Calendar local = new GregorianCalendar();
		//System.out.println("calendar: "+local.getTime());
		local.set(Calendar.YEAR, zdt.getYear());
		local.set(Calendar.MONTH, zdt.getMonth().getValue()-1);
		local.set(Calendar.DATE, zdt.getDayOfMonth());
		local.set(Calendar.HOUR, zdt.getHour());
		local.set(Calendar.MINUTE, zdt.getMinute());
		local.set(Calendar.SECOND, zdt.getSecond());
		return local.getTime();
	}
}
