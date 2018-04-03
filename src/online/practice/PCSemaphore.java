package online.practice;

import java.util.concurrent.Semaphore;

/*
class MyQ{
	int item;
	
	static Semaphore semaCon = new Semaphore(0);
	static Semaphore semaPro = new Semaphore(0);
	
	void get() {
		try {
			semaCon.acquire();
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		System.out.println("Consumed - "+item);
		semaPro s.release();
	}
	
	void put(int i) {
		try {
			semaPro.acquire();
		}catch (Exception e) {
			// TODO: handle exception
		}
		this.item = i;
		System.out.println("Produced - "+this.item);
		semaCon.release();
	}
}

class Producer implements Runnable{
	MyQ q;
	Producer(MyQ q){
		this.q = q;
		new Thread(this,"Producer").start();
	}
	public void run() {
		for(int i=0; i < 5; i++) 
			q.put(i);
	}
}

class Consumer implements Runnable{
	MyQ q;
	Consumer(MyQ q){
		this.q = q;
		new Thread(this,"Consumer").start();
	}
	public void run() {
		for(int i=0; i < 5; i++) 
			q.get();
	}
}
*/
public class PCSemaphore {
	public static void main(String...a) {
		/*
        // creating buffer queue
        MyQ q = new MyQ();
         
        // starting consumer thread
        new Consumer(q);
         
        // starting producer thread
        new Producer(q);
        */
	}

}
