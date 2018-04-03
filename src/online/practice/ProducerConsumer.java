package online.practice;

import java.util.LinkedList;

public class ProducerConsumer {

	public static void main(String...a) {
		final PC pc = new PC();
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				pc.produce();
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				pc.consume();
			}
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static class PC{
		LinkedList<Integer> list = new LinkedList<>();
		int capacity = 3;
		
		public void produce() {
			int value = 0 ;
			while(true) {
				synchronized(this) {
					while(list.size() == capacity) {
						try {
							wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					System.out.println("Producer Produced - " +value);
					list.add(value++);
					
					notify();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		
		public void consume() {
			while(true) {
				synchronized(this) {
					while(list.size() == 0) {
						try {
							wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					System.out.println("Consumer Consumed - " +list.remove(list.removeFirst()));
					
					notify();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
}
