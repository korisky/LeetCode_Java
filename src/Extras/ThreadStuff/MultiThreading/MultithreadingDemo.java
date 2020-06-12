package Extras.ThreadStuff.MultiThreading;

public class MultithreadingDemo implements Runnable {

    @Override
    public void run() {
        try {
            System.out.println("Thread" + Thread.currentThread().getId() + " is running");
        } catch (Exception e) {
            System.out.println("Exception is caught");
        }
    }
}


