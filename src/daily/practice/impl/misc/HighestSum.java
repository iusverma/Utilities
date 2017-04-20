package daily.practice.impl.misc;

public class HighestSum {
	private static int solution(int arr[]){
		int length = arr.length;
		int highestSum = -100;
		for(int i=0;i<length-1;i++){
			int tempSum = arr[i] + arr[i+1];
			if(tempSum>highestSum){
				highestSum = tempSum;
			}
		}
		System.out.println("[solution] Highest sum of two consecutive numer is: "+highestSum);
		return highestSum;
	}
	
	public static void main(String args[]){
		int arr[] = {-4,-1,-3,-2,-1};
		System.out.println("[main] Highest sum is: " +solution(arr));
	}
}
