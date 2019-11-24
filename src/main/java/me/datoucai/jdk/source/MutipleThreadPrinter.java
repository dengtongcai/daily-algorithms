package me.datoucai.jdk.source;

public class MutipleThreadPrinter implements Runnable {
    int flag;

    static int total = 0;

    public MutipleThreadPrinter(int flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        while (total < 20) {
            synchronized (MutipleThreadPrinter.class) {
                if (total % 3 == flag) {
                    System.out.println(total++);
                    MutipleThreadPrinter.class.notifyAll();
                    continue;
                }

                try {
                    MutipleThreadPrinter.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();

                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new MutipleThreadPrinter(0)).start();
        new Thread(new MutipleThreadPrinter(1)).start();
        new Thread(new MutipleThreadPrinter(2)).start();
    }
}
