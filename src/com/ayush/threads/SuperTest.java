package com.ayush.threads;

class Main{
        int x = 10;
}

public class SuperTest extends Main{
        public void vox(){
                super.x = 20;
                System.out.println(super.x);
        }
        public static void main(){
                new SuperTest().vox();
        }
}