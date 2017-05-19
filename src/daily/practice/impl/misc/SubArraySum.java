package daily.practice.impl.misc;

import java.util.Map;
import java.util.HashMap;

public class SubArraySum{
	static void subArraySum(int arr[], int n, int sum){
		Map<Integer, Integer> map = new HashMap<>();
		
		int currSum = 0;
		
		for(int i=0;i<n;i++){
			System.out.println("currSum: " +currSum);
			currSum = currSum + arr[i];
			System.out.println("currSum: " +currSum);
			System.out.println("sum: " +sum);
			
			if(currSum == sum){
				System.out.println("Sum found between indexes " + 0 
					+" to " +i);
					return;
			}

			int mapKey = currSum - sum;
			System.out.println("Finding in map: " +mapKey);
			if(map.containsKey(mapKey)){
				System.out.println("Sum found between indexes " 
					+map.get(mapKey) + 1 
					+" to " +i);
					return;
			}
			System.out.println("Inserting in map: " + currSum +", " +i);
			map.put(currSum, i);
		}
	}
	
	public static void main(String args[]){
		int arr[] = {10,2,-2,-20,10};
		int n = arr.length;
		int sum = -10;
		subArraySum(arr,n,sum);
	}
}