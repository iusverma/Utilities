package interviews;
import java.util.Stack;

public class LISTest2 {

	private static int findLisLenth(int a[], int len){
		Stack<Integer> lis = new Stack<>();
		for(int i=0;i<len;i++){
			if((len-i)<lis.size()){
				break;
			}
			Stack<Integer> s = new Stack<>();
			for(int j=i;j<len;j++){
				if(s.empty()){
					s.push(a[j]);
				}else if(s.peek()<a[j]){
					s.push(a[j]);
				}
			}
			if(s.size() > lis.size()){
				lis = s;
			}
		}
		System.out.println("Longest increasing sequence is: "+lis);
		return lis.size();
	}

	public static void main(String args[]){
		int a1[] = {1,4,5,2,6};
		System.out.println("Sequence: {1,4,5,2,6}");
		System.out.println("Length of longest increasing sequence is: "+findLisLenth(a1,a1.length));
		int a2[] = {4,1,5,2,6};
		System.out.println("Sequence: {4,1,5,2,6}");
		System.out.println("Length of longest increasing sequence is: "+findLisLenth(a2,a2.length));
		int a3[] = {1,2,1,0,1,2,5,6,7,9};
		System.out.println("Sequence: {1,2,1,0,1,2,5,6,7,9}");
		System.out.println("Length of longest increasing sequence is: "+findLisLenth(a3,a3.length));
		int a4[] = {1,4,2,3,5,6};
		System.out.println("Sequence: {1,4,2,3,5,6}");
		System.out.println("Length of longest increasing sequence is: "+findLisLenth(a4,a4.length));
	}
}
