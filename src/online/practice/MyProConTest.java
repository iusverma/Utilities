package online.practice;

import java.util.ArrayList;
import java.util.List;

class MyProCon{
	List<Integer> intList = new ArrayList<>();
	int capacity = 3;
	
	public void produce() throws InterruptedException {
		int value = 0;
		synchronized(this) {
			while(true) {
				if(intList.size()==capacity) {
					wait();
				}
				value++;
				System.out.println("Produced: "+value);
				intList.add(value);
				
				// To notifying other sleeping threads
				notifyAll();
				
				// For seeing results effectively
				Thread.sleep(1000);
			}
		}
	}

	public void consume() throws InterruptedException {
		synchronized(this) {
			while(true) {
				if(intList.size()==0) {
					wait();
				}
				System.out.println("Consumed: "+intList.remove(0));
				
				// To notifying other sleeping threads
				notifyAll();
				
				// For seeing results effectively
				Thread.sleep(1000);
			}
		}
	}
}
public class MyProConTest {
	public static void main(String...a) {
		final MyProCon mpc = new MyProCon();
	
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				try {
					mpc.consume();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				try {
					mpc.produce();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		t1.start();
		t2.start();
	}
}
