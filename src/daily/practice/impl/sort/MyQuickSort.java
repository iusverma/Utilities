package daily.practice.impl.sort;

public class MyQuickSort {
	public static void main(String...a) {
		int arr[] = {6,9,4,6,5,3};
		quickSort(arr,0,5);
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
	}

	public static void quickSort(int arr[], int begin, int end) {
	    if (begin < end) {
	        int partitionIndex = partition(arr, begin, end);
	        System.out.println("partition index: "+partitionIndex);
	        quickSort(arr, begin, partitionIndex-1);
	        quickSort(arr, partitionIndex+1, end);
	    }
	}
	
	private static int partition(int arr[], int begin, int end) {
	    int pivot = arr[end];
	    for(int i=begin;i<end;i++) {
	    	System.out.println("pivot: "+pivot);
	    	if(arr[begin] > pivot) {
	    		
	    	}
	    }
	    return pivot;
	}
}
