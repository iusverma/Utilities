package com.ayush.threads;

//import java.lang.Thread;

/* These class is named as Thread6/Thread6Sep
 * because these are created on 6 Sep 2017.
 */
class Thread6 implements Runnable{
        public void run(){
                System.out.println("Thread Name: " +Thread.currentThread().getName());
                System.out.println("Thread ID: " +Thread.currentThread().getId());
                System.out.println("Is Alive: " +Thread.currentThread().isAlive());
                for(int i=0;i<10;i++){
                        System.out.println(Thread.currentThread().getName() + "-" +i);
                        try{
                                Thread.sleep(1000);
                        }catch(Exception e){
                                // do nothing
                        }
                }
        }
}

public class Thread6Sep{
        public static void main(String [] args){
                Thread6 t61 = new Thread6();
                Thread t1 = new Thread(t61);
                t1.setName("AYUSH");

                Thread6 t62 = new Thread6();
                Thread t2 = new Thread(t62);
                t2.setName("MEGHA");

                Thread6 t63 = new Thread6();
                Thread t3 = new Thread(t63);
                t3.setName("AYUSME");

                t1.start();
                t2.start();
                t3.start();
        }
}