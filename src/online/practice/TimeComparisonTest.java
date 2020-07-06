package online.practice;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

class TimeComparisonTest {
	
	public TimeComparison tc = new TimeComparison();
	Calendar c1 = new GregorianCalendar(2020, 6 ,7);
	
	@BeforeClass
	void init(){
		setData(c1, 6, 7, 19, 30, 56, 123);
	}

	// One day before
	@Test
	void test1() {
		System.out.println("test1");
		Calendar c2 = new GregorianCalendar(2020, 6, 6);
		//setData(c2, 5, 7, 19, 19, 50, 456);
		System.out.println(tc.moreThanAnHour(c2, c1));
	}

	// Same day but 2 hour before
	@Test
	void test2() {
		System.out.println("test2");
		c1.add(Calendar.HOUR,-8);
		Calendar c2 = new GregorianCalendar(2020, 6, 7);
		c2.add(Calendar.HOUR,-10);
		System.out.println(tc.moreThanAnHour(c2, c1));
	}
	
	// Same day but 1 hour before
	@Test
	void test3() {
		System.out.println("test3");
		c1.add(Calendar.HOUR,-3);
		Calendar c2 = new GregorianCalendar(2020, 6, 7);
		c2.add(Calendar.HOUR,-4);
		System.out.println(tc.moreThanAnHour(c2, c1));
	}
	
	// Same day but 30 mins before
	@Test
	void test4() {
		System.out.println("test4");
		Calendar c2 = new GregorianCalendar(2020, 6, 7);
		c2.add(Calendar.HOUR,-3);
		c2.add(Calendar.MINUTE,-35);
		System.out.println(tc.moreThanAnHour(c2, c1));
	}

	// Same day same time
	@Test
	void test5() {
		System.out.println("test5");
		System.out.println(tc.moreThanAnHour(c1, c1));
	}
	// Same day 15 mins after
	@Test
	void test6() {
		System.out.println("test6");
		c1.add(Calendar.HOUR,-3);
		c1.add(Calendar.MINUTE,-25);
		Calendar c2 = new GregorianCalendar(2020, 6, 7);
		c2.add(Calendar.HOUR,-3);
		c2.add(Calendar.MINUTE,-15);
		System.out.println(tc.moreThanAnHour(c2, c1));
	}
	// Same day but 1 hour after
	@Test
	void test7() {
		System.out.println("test7");
		c1.add(Calendar.HOUR,-3);
		Calendar c2 = new GregorianCalendar(2020, 6, 7);
		c2.add(Calendar.HOUR,-2);
		System.out.println(tc.moreThanAnHour(c2, c1));
	}
	// Same day but 1 day after
	@Test
	void test8() {
		System.out.println("test8");
		c1.add(Calendar.HOUR,-3);
		c1.add(Calendar.MINUTE,-15);
		Calendar c2 = new GregorianCalendar(2020, 6, 8);
		c2.add(Calendar.HOUR,-3);
		c2.add(Calendar.MINUTE,-35);
		System.out.println(tc.moreThanAnHour(c2, c1));
	}

	private void setData(final Calendar c,int date, int month, int hour, int min, int sec, int ms){
		c.set(Calendar.DATE, date);
		c.set(Calendar.YEAR, 2020);
		c.set(Calendar.MONTH, month);
		c.set(Calendar.HOUR, hour);
		c.set(Calendar.MINUTE, min);
		c.set(Calendar.SECOND, sec);
		c.set(Calendar.MILLISECOND, ms);
	}
}
