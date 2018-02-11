package interviews;

public class LISTest {
	private static String lis = "";

	private static int findLisLenth(int a[], int len){
		int largest = 0;
		for(int j=0;j<len;j++){
			String s = "";
			if((len-j)<s.length()){
				break;
			}
			for(int i=j;i<len-1;i++){
				s+= a[i];
				//s+=largest;
				if(a[i]>largest){
					largest = a[i];
				}
				if(largest>a[i+1]){
					System.out.println("s: "+s);
					if(s.length()>lis.length()){
						lis = s;
					}
					continue;
				}
			}
		}
		if(a[len-1]>largest){
			lis+=a[len-1];
		}
		System.out.println("largest: "+largest);
		System.out.println("Longest increasing sequence is: "+lis);
		return lis.length();
	}

	public static void main(String args[]){
		//int a[] = {1,4,5,2,6};
		//int a[] = {4,1,5,2,6};
		//int a[] = {1,4,2,5,6};
		int a[] = {1,4,2,3,5,6};
		int lisLen = findLisLenth(a,a.length);
		System.out.println("Length of longest increasing sequence is: "+lisLen);
	}
}
