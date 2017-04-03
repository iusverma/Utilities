package daily.practice.impl.gen;

public class TwoGen<T, V>{
	T obj1;
	V obj2;
	
	TwoGen(T o1, V o2){
		obj1 = o1;
		obj2 = o2;
	}

	T getObj1(){
		return obj1;
	}

	V getObj2(){
		return obj2;
	}

	void showType(){
		System.out.println("Type of T is = "+obj1.getClass().getName());
		System.out.println("Type of V is = "+obj2.getClass().getName());
	}

	// Testing TwoGen Class
	public static void main(String args[]){
		TwoGen<Integer, String> iObj = new TwoGen<Integer, String>(2014, "ayusme");
		iObj.showType();
		System.out.println("Value of iObj = "+iObj.getObj1() +", " +iObj.getObj2());
	}
}