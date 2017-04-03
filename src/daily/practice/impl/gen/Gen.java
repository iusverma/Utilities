package daily.practice.impl.gen;

public class Gen<T>{
	T obj;
	

	Gen(T o){
		obj = o;
	}

	T getObj(){
		return obj;
	}

	void showType(){
		System.out.println("Type of T is = "+obj.getClass().getName());
	}

	// Testing Gen Class
	public static void main(String args[]){
		Gen<Integer> iObj = new Gen<Integer>(2014);
		iObj.showType();
		System.out.println("Value of iObj = "+iObj.getObj());

		Gen<String> strObj = new Gen<String>("ayusme");
		strObj.showType();
		System.out.println("Value of iObj = "+strObj.getObj()	);
	}
}