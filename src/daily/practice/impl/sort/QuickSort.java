package daily.practice.impl.sort;

public class QuickSort {
	public static void main(String... a) {
		//int arr[] = { 6, 9, 4, 6, 5, 3 };
		int arr[] = { 9, 7, 5, 3, 2, 1 };
		quickSort(arr, 0, 5);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public static void quickSort(int arr[], int begin, int end) {
		if (begin < end) {
			int partitionIndex = partition(arr, begin, end);
			System.out.println("partition index: " + partitionIndex);
			for (int i = 0; i < arr.length; i++) {
				System.out.print(" "+arr[i]);
			}
			System.out.println();
			quickSort(arr, begin, partitionIndex - 1);
			quickSort(arr, partitionIndex + 1, end);
		}
	}

	/*
	 * This function takes last element as pivot, places the pivot element at its
	 * correct position in sorted array, and places all smaller (smaller than pivot)
	 * to left of pivot and all greater elements to right of pivot
	 */
	public static int partition(int arr[], int low, int high) {
		int pivot = arr[high];
		int i = (low - 1); // index of smaller element
		for (int j = low; j < high; j++) {
			System.out.println("pivot: "+pivot+" i: "+i +" j:" +j);
			// If current element is smaller than or
			// equal to pivot
			if (arr[j] <= pivot) {
				i++;

				// swap arr[i] and arr[j]
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
			for (int k = 0; k < arr.length; k++) {
				System.out.print(" "+arr[k]);
			}
			System.out.println();
		}

		// swap arr[i+1] and arr[high] (or pivot)
		int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;

		return i + 1;
	}
}
