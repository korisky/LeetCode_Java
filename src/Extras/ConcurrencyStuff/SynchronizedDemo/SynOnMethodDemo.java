package Extras.ConcurrencyStuff.SynchronizedDemo;


class SyThreadedSend extends Thread {
    private String msg;
    SynSender sender;

    SyThreadedSend(String m, SynSender obj) {
        msg = m;
        sender = obj;
    }

    public void run() {
        synchronized (sender) {
            sender.send(msg);
        }
    }
}

class SynSender {
    public void send(String msg) {
        synchronized (this) {
            System.out.println("Sending\t" + msg);
            try {
                Thread.sleep(5);
            } catch (Exception e) {
                System.out.println("Thread Interrupted");
            }
            System.out.println("\n" + msg + "Sent");
        }
    }
}

public class SynOnMethodDemo {
    public static void main(String[] args) {
        SynSender snd = new SynSender();
        SyThreadedSend t1 = new SyThreadedSend("Hi", snd);
        SyThreadedSend t2 = new SyThreadedSend("Haha", snd);
        SyThreadedSend t3 = new SyThreadedSend("who are you", snd);
        SyThreadedSend t4 = new SyThreadedSend("Bye", snd);

        // what we find out here is:
        // thread might start not in order (t1, t4, t2, t3)
        // But, when we use synchronize, that specific part MUST finished,
        // after another thread call it.

        // which mean: we can only get: send.. ..is send, send.. .. is send
        // But, without synchronize, we might get: sendA, sendB, B is send, A is send

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
