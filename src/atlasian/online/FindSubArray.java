package atlasian.online;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindSubArray {

	private static List<Integer> getList(int[] array) {
		List<Integer> list = new ArrayList<Integer>();
		for (int index = 0; index < array.length; index++) {
			list.add(array[index]);
		}
		return list;
	}

	public static int findArray(int array[], int subArray[]) {
		return Collections.indexOfSubList(getList(array), getList(subArray));
	}

	public static void main(String args[]) {
		int arr[] = { 10, 4, 6, 67, 89, 4 };
		int sarr1[] = { 6, 67 };
		int sarr2[] = { 10 };
		int sarr3[] = { 67, 89, 4 };
		int sarr4[] = { 4, 4 };
		System.out.println(findArray(arr, sarr1));
		System.out.println(findArray(arr, sarr2));
		System.out.println(findArray(arr, sarr3));
		System.out.println(findArray(arr, sarr4));
		System.out.println("===================");
		System.out.println(findSubArrayMine(arr, sarr1));
		System.out.println(findSubArrayMine(arr, sarr2));
		System.out.println(findSubArrayMine(arr, sarr3));
		System.out.println(findSubArrayMine(arr, sarr4));
	}

	public static int findSubArrayMine(int array[], int subArray[]) {
		int arrLen = array.length;
		int subArrLen = subArray.length;
		int pos = -1;

		if (subArrLen > arrLen)
			return pos;

		for (int i = 0; i < arrLen; i++) {
			if (array[i] == subArray[0]) {
				if (arrLen - i < subArrLen)
					return pos;

				for (int j = 0; j < subArrLen; j++) {
					pos = i;
					if (array[i + j] != subArray[j]) {
						pos = -1;
						break;
					}
				}
				return pos;
			}
		}

		return pos;
	}
}
