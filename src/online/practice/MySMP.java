package online.practice;

import java.util.concurrent.Semaphore;

class MyQueue{
	private int value = 0;
	private static Semaphore pSemaphore = new Semaphore(1);
	private static Semaphore cSemaphore = new Semaphore(0);
	
	public void put(int i) {
		try {
			pSemaphore.acquire();
			
			value = i;
			
			System.out.println("Produced: "+value);
			
			cSemaphore.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void get() {
		try {
			cSemaphore.acquire();

			System.out.println("Consumed: "+value);
			
			pSemaphore.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class MSMPProducer implements Runnable{
	MyQueue mq = new MyQueue();
	MSMPProducer(MyQueue q){
		this.mq = q;
		new Thread(this, "Producer").start();
	}

	@Override
	public void run() {
		for(int i=0;i<10;i++)
			mq.put(i);
	}
}

class MSMPConsumer implements Runnable{
	MyQueue mq = new MyQueue();
	MSMPConsumer(MyQueue q){
		this.mq = q;
		new Thread(this, "Producer").start();
	}

	@Override
	public void run() {
		for(int i=0;i<10;i++)
			mq.get();
	}
}

public class MySMP {
	public static void main(String...a) throws InterruptedException {
		MyQueue mq = new MyQueue();
		new MSMPConsumer(mq);
		//Thread.sleep(1000);
		new MSMPProducer(mq);
	}
}
