package Extras.ConcurrencyStuff.SynchronizedDemo;


class NoThreadedSend extends Thread {
    private String msg;
    Sender sender;

    NoThreadedSend(String m, Sender obj) {
        msg = m;
        sender = obj;
    }

    public void run() {
        sender.send(msg);
    }
}

class NoSyncDemo {
    public static void main(String[] args) {
        Sender snd = new Sender();
        NoThreadedSend t1 = new NoThreadedSend("Hi", snd);
        NoThreadedSend t2 = new NoThreadedSend("haha", snd);
        NoThreadedSend t3 = new NoThreadedSend("who are you", snd);
        NoThreadedSend t4 = new NoThreadedSend("Bye", snd);


        // As we can see, once we go into the Sender class,
        // all four threads would 'rob' the Sender instance, and
        // print out the stuff not in order we want

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        // wait for thread to end
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
