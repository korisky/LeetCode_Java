package Extras.ThreadStuff.MultiThreadCom;

import java.util.LinkedList;

public class ProducerConsumerProblem {

    // This class has a list, producer (adds items to list
    // and consumber (removes items).
    public static class PC {
        LinkedList<Integer> list = new LinkedList<>();
        int capacity = 5;

        public void produce() throws InterruptedException {
            int value = 0;
            while (true) {
                synchronized (this) {
                    while (list.size() == capacity)
                        wait();
                    // if storage is full, we need to stop production
                    System.out.println("Producer produced-" + value);
                    list.add(value++);
                    notify(); // wake up consumer
                    Thread.sleep(1000);
                }
            }
        }

        public void consume() throws InterruptedException {
            while (true) {
                synchronized (this) {
                    while (list.size() == 0)
                        wait();
                    // consumer cannot consume any product if the store is empty
                    int val = list.removeFirst();
                    System.out.println("Consumer consume-" + val);
                    notify(); // wake up producer
                    Thread.sleep(1000);
                }
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        PC use =new PC();

        Thread p1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    use.produce();
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        Thread c1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    use.consume();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Thread c2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    use.consume();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        p1.start();
        c1.start();
        c2.start();

        p1.join();
        c1.join();
        c2.join();
    }
}
