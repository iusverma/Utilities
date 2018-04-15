package com.amazon.test;

import java.util.ArrayList;
import java.util.List;

public class MostUsedWords {

	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	static List<String> retrieveMostFrequentlyUsedWords(String literatureText, List<String> wordsToExclude) {
		String words[] = literatureText.split(" ");
		// HashMap<String,Integer> wordCount = new HashMap
		List<String> max = new ArrayList<>();
		int maxCount = 0;
		System.out.println("Total Words: " + words.length);
		for (int i = 0; i < words.length; i++) {
			if (wordsToExclude.contains(words[i])) {
				// is a common word
				// System.out.println(words[i] + " is a common word");
			} else {
				if (max.contains(words[i]))
					continue;
				int lastIndex = 0;
				int count = 0;
				while (lastIndex != -1) {
					lastIndex = literatureText.indexOf(words[i], lastIndex);
					if (lastIndex != -1) {
						count++;
						lastIndex += words[i].length();
					}
				}
				System.out.println(words[i] + ":" + count);
				if (count > maxCount) {
					max.clear();
					max.add(words[i]);
					maxCount = count;
				} else if (count == maxCount) {
					max.add(words[i]);
				}
			}
		}
		System.out.println(max);
		return max;
	}
	// METHOD SIGNATURE ENDS

	public static void main(String... a) {
		String text = "rose is a flower rose is pond a flower rose flower in garden garden garden pond pond rose is a rose is a rose is a rose is a";
		List<String> ex = new ArrayList<>();
		ex.add("rose");
		ex.add("is");
		ex.add("a");
		retrieveMostFrequentlyUsedWords(text, ex);
	}
}