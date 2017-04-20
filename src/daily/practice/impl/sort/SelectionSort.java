package daily.practice.impl.sort;

class SelectionSort{
	public static void sort(int arr[]){
		int length = arr.length;
		for(int i = 0;i<length;i++){
			for(int j = i+1;j<length;j++){
				if(arr[i]>arr[j]){
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		for(int i = 0;i<length;i++){
			System.out.println(arr[i]);
		}
	}
	
	public static void main(String args[]){
		int [] arr1 = {6,3,7,55,44,22,77,99,76,89,00,87,134,23,6};
		sort(arr1);
		int [] arr2 = {875985,583457,38759375,875895,756524,498204,482094,928402,478745};
		sort(arr2);
	}
}