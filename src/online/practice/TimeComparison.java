package online.practice;

import java.util.Calendar;

public class TimeComparison {

	
	public boolean moreThanAnHour(final Calendar time1, final Calendar time2) {
		System.out.println("time1: "+time1.getTime());
		System.out.println("time2: "+time2.getTime());
		System.out.println("*** date ***");
		System.out.println(time1.get(Calendar.DATE));
		System.out.println(time2.get(Calendar.DATE));
		System.out.println("*** time ***");
		System.out.println(time1.get(Calendar.HOUR));
		System.out.println(time2.get(Calendar.HOUR));
		if(time1.get(Calendar.DATE) < time2.get(Calendar.DATE)) {
			return true;
		}else if(time1.get(Calendar.DATE) == time2.get(Calendar.DATE)
				&& 1 < time2.get(Calendar.HOUR) - time1.get(Calendar.HOUR)) {
			return true;
		}
		return false;
	}
}
