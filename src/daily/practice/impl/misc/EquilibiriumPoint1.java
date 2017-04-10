//package daily.practice.impl.misc;

public class EquilibiriumPoint1{

	public static void solution(int arr[]){
		int length = arr.length;
		for(int i=0;i<length;i++){
			int sumLeft = 0;
			int sumRight = 0;
			for(int j=0;j<i;j++){
				sumLeft = sumLeft + arr[j];
			}
			for(int j=i+1;j<length;j++){
				sumRight = sumRight + arr[j];
			}
			System.out.println("Sum Left: "+sumLeft);
			System.out.println("Sum Right: " +sumRight);
			if(sumLeft == sumRight){
				System.out.println(i);
			}
		}
	}

	public static void main(String args[]){
		int arr[] = {-1,3,-4,5,1,-6,2,1};
		solution(arr);
	}
}
