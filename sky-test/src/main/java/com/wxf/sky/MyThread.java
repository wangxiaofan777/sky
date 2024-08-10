package com.wxf.sky;

/**
 * @author Wxf
 * @since 2024-08-07 19:09:35
 **/
public class MyThread extends Thread {

    @Override
    public synchronized void run() {

        System.out.println("myThread:" + isInterrupted());
        try {
            sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();

        System.out.println("main before: " + myThread.isInterrupted());
        myThread.interrupt();
        System.out.println("main after: " + myThread.isInterrupted());

        myThread.join();

        System.out.println("main : " + myThread.isInterrupted());

    }
}
