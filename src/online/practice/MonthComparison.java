package online.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MonthComparison {
	public static void main(String...a) {
		List<Integer> months = new ArrayList<>();
		months.add(202003);
		months.add(202001);
		months.add(202002);
		int startMonth;
		int counter=1;
		int nextExpectedMonth;
		Collections.sort(months);
		startMonth = months.get(0);
		System.out.println(getNextExpectedMonth(201911));
		System.out.println(getNextExpectedMonth(201912));
		System.out.println(getNextExpectedMonth(202001));
		System.out.println(getNextExpectedMonth(202002));
		System.out.println(getNextExpectedMonth(202003));
		System.out.println(getNextExpectedMonth(202004));
		System.out.println(getNextExpectedMonth(202005));
		System.out.println(getNextExpectedMonth(202006));
		System.out.println(getNextExpectedMonth(202007));
		System.out.println(getNextExpectedMonth(202008));
		System.out.println(getNextExpectedMonth(202009));
		System.out.println(getNextExpectedMonth(202010));
		System.out.println(getNextExpectedMonth(202011));
		System.out.println(getNextExpectedMonth(202012));
		System.out.println(getNextExpectedMonth(202101));		
	}
	
	private static int getNextExpectedMonth(int startMonth) {
		String startMonthStr = String.valueOf(startMonth);
		Integer month = new Integer(startMonthStr.substring(4));
		if (month==12) {
			return 1;
		} else {
			month++;
			return month;
		}
	}
}
