package Extras.ThreadStuff.SynchronizedDemo;

class Sender {
    public void send(String msg) {
        System.out.println("Sending\t" + msg);
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            System.out.println("Thread Interrupted");
        }
        System.out.println("\n" + msg + "Sent");
    }
}

class ThreadedSend extends Thread {
    private String msg;
    Sender sender;

    ThreadedSend(String m, Sender obj) {
        msg = m;
        sender = obj;
    }

    public void run() {
        synchronized (sender) {
            sender.send(msg);
        }
    }
}

class SyncDemo {
    public static void main(String[] args) {
        Sender snd = new Sender();
        ThreadedSend t1 = new ThreadedSend("Hi", snd);
        ThreadedSend t2 = new ThreadedSend("Haha", snd);
        ThreadedSend t3 = new ThreadedSend("who are you", snd);
        ThreadedSend t4 = new ThreadedSend("Bye", snd);

        // we only have one Sender instance, thread 1 and 2 would try to 'rub'
        // to use it. After we use synchronize, that would not happen
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (Exception e) {
            System.out.println("Interrupted");
        }
    }
}
