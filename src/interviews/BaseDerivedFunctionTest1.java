package interviews;

public class BaseDerivedFunctionTest1{
	
	private static void main(String args[]){
	
    Base b = new Derived();

    // This will print b.i = 10,
    // Reason: b is original a Base class variable
    // and it will refer to member variables in Base
    // TODO: Later
    //System.out.println("b.i = " +b.i);

    // This will print following
    // Base.method1()
    // Base.method2()
    // Reason: b is initialized using Derived new, so
    // it should have called method1 in Derived class
    // But since method1 is not overridden in Derived,
    // method1 is called from Base.
    // However since method1 is called from Base, then
    // method2 exposed to the flow is also from scope of
    // Base, hence method2 is called from Base, even though
    // it was overridden in Derived.
    b.method1();

    // This will print Derived.method2()
    // Reason: b is initized with a new Derived and
    // method2 is overriden, hence when a call to method2
    // is made using b, it will call methid2 from Derived.
    b.method2();
	}
}
