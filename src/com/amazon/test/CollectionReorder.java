package com.amazon.test;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

public class CollectionReorder {

	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	public List<String> reorderLines(int logFileSize, List<String> logLines) {
		List<String> temp = new LinkedList<>();
		List<String> fin = new LinkedList<>();

		HashMap<String, String> map = new HashMap<String, String>();
		for (int i = 0; i < logLines.size(); i++) {
			String tmp = logLines.get(i);
			System.out.println(temp);
			int ind = 0;
			for (int j = 0; j < tmp.length(); j++) {
				if (tmp.charAt(j) == ' ') {
					ind = j + 1;
					break;
				}
			}
			String act = tmp.substring(ind);
			map.put(act, tmp);
			System.out.println(act);
			Pattern p = Pattern.compile("[a-z]");
			Matcher m = p.matcher(act);
			while (m.find()) {
				temp.add(act);
				break;
			}
		}
		Collections.sort(temp);
		for (int i = 0; i < logLines.size(); i++) {
			String tmp = logLines.get(i);
			System.out.println(temp);
			int ind = 0;
			for (int j = 0; j < tmp.length(); j++) {
				if (tmp.charAt(j) == ' ') {
					ind = j + 1;
					break;
				}
			}
			String act = tmp.substring(ind);
			Pattern p = Pattern.compile("[0-9]");
			Matcher m = p.matcher(act);
			while (m.find()) {
				temp.add(act);
				break;
			}
		}
		System.out.println(temp);
		for (int i = 0; i < temp.size(); i++) {
			fin.add(map.get(temp.get(i)));
		}
		System.out.println(fin);
		return fin;
	}
	// METHOD SIGNATURE ENDS

	public static void main(String... a) {

	}
}
