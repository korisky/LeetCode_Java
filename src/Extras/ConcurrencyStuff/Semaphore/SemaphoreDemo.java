package Extras.ConcurrencyStuff.Semaphore;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class SemaphoreDemo {

    private static final AtomicInteger counter = new AtomicInteger(0);
    private static final Semaphore semaphore = new Semaphore(2);

    public static void main(String[] args) {

        ExecutorService ex = Executors.newFixedThreadPool(10);

        List<CompletableFuture<Void>> futureTaskList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            CompletableFuture<Void> futureTask = CompletableFuture.runAsync(() -> increment(), ex);
            futureTaskList.add(futureTask);
        }

        CompletableFuture<Void> voidAll = CompletableFuture.allOf(futureTaskList.toArray(new CompletableFuture[0]));
        voidAll.join();

        System.out.println("Finished");
    }

    private static void increment() {
        try {
            // use semaphore 只允许一定数量线程同时执行下列代码
            semaphore.acquire();
            int andIncrement = counter.getAndIncrement();
            System.out.println(Thread.currentThread().getName() + " got semaphore and +1 to counter got: " + andIncrement);
            // 暂停
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName() + " now release");
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            System.out.println(Thread.currentThread().getName() + " was interrupted");
        } finally {
            semaphore.release();
        }
    }


}
