package com.booking.hackerrank;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.regex.Matcher;
/*
Check if following can be used
import java.text.*;
import java.math.*;
import java.util.regex.*;
*/
import java.util.regex.Pattern;

/*
Input
breakfast beach citycenter location metro view staff price
5
1
2
3
1
2
5
This hotel has a nice view of the citycenter. The location is perfect.
The breakfast is ok. Regarding location, it is quite far from citycenter but price is cheap so it is worth.
Location is excellent, 5 minutes from citycenter. There is also a metro station very close to the hotel.
They said I couldn't take my dog and there were other guests with dogs! That is not fair.
Very friendly staff and good cost-benefit ratio. Its location is a bit far from citycenter.

Output
2
1
*/
public class HotelsRatings {

	/*
	 * Complete the function below.
	 */
	static int[] sort_hotels(String keywords, int[] hotel_ids, String[] reviews) {
		if(hotel_ids.length != reviews.length)
			return null;

		Map<Integer,Integer> hotel_reviews = new TreeMap<>();
		String [] keys = keywords.split(" ");
		for(int i=0;i<reviews.length;i++) {
			for(int j=0;j<keys.length;j++) {
				String review = reviews[i].toLowerCase();
				String key = keys[j].toLowerCase();
				//count of current keyword in review
				int count = 0;
				Pattern p = Pattern.compile(key);
				Matcher m =p.matcher(review);
				while(m.find()) {
					count++;
				}
				int newKeywordCount = count;
				if(hotel_reviews.containsKey(hotel_ids[i])) {
					newKeywordCount = newKeywordCount + hotel_reviews.get(hotel_ids[i]);
				}
				hotel_reviews.put(hotel_ids[i], newKeywordCount);
			}
		}
		System.out.println(hotel_reviews.toString());
		Map<Integer,Integer> sortedMap = sortByValue(hotel_reviews);
		//  = new int[sortedMap.size()];
		//int [] a = sortedMap.values().toArray();
		System.out.println(hotel_reviews.toString());
		/*
        for(Integer key : sortedMap.keySet()) {
            List<Integer> value = sortedMap.get(key);
            List<Map<Integer,Integer>> security = new LinkedList<Map<String,Integer>>();
            for(int ixy = 0; ixy < value.size()-1; ixy++){
            }
        }
        */
		// TODO: Write custom sort based on key
		return null;
	}

	private static Map<Integer, Integer> sortByValue(Map<Integer, Integer> unsortMap) {

        // 1. Convert Map to List of Map
        List<Map.Entry<Integer, Integer>> list =
                new LinkedList<Map.Entry<Integer, Integer>>(unsortMap.entrySet());

        // 2. Sort list with Collections.sort(), provide a custom Comparator
        //    Try switch the o1 o2 position for a different order
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1,
                               Map.Entry<Integer, Integer> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        // 3. Loop the sorted list and put it into a new insertion order Map LinkedHashMap
        Map<Integer, Integer> sortedMap = new LinkedHashMap<Integer, Integer>();
        for (Map.Entry<Integer, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		final String fileName = System.getenv("OUTPUT_PATH");
		BufferedWriter bw = null;
		if (fileName != null) {
			bw = new BufferedWriter(new FileWriter(fileName));
		} else {
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
		}

		int[] res;
		String keywords;
		try {
			keywords = in.nextLine();
		} catch (Exception e) {
			keywords = null;
		}

		int hotel_ids_size = 0;
		hotel_ids_size = Integer.parseInt(in.nextLine().trim());

		int[] hotel_ids = new int[hotel_ids_size];
		for (int i = 0; i < hotel_ids_size; i++) {
			int hotel_ids_item;
			hotel_ids_item = Integer.parseInt(in.nextLine().trim());
			hotel_ids[i] = hotel_ids_item;
		}

		int reviews_size = 0;
		reviews_size = Integer.parseInt(in.nextLine().trim());

		String[] reviews = new String[reviews_size];
		for (int i = 0; i < reviews_size; i++) {
			String reviews_item;
			try {
				reviews_item = in.nextLine();
			} catch (Exception e) {
				reviews_item = null;
			}
			reviews[i] = reviews_item;
		}

		res = sort_hotels(keywords, hotel_ids, reviews);
		/*
		for (int res_i = 0; res_i < res.length; res_i++) {
			bw.write(String.valueOf(res[res_i]));
			bw.newLine();
		}
		*/

		bw.close();
		in.close();
	}
}
