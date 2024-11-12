package multithreading.SynchronizationWithWaitNotify;

import java.util.stream.IntStream;

public class implementSynchronization {
    synchronized void method1() {
        IntStream.rangeClosed(1, 10)
                .forEach(ct -> {
                    System.out.println("ct = "+ct+" .. synchronized method -- method 1");
                    if (ct == 5) {
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
    }

    void method2() {
        synchronized (this) {
            IntStream.rangeClosed(1, 10)
                    .forEach(ct -> {
                        System.out.println("ct = " + ct + " .. synchronized block -- method 2");
                    });

            notify();
        }
    }

    public static void main(String[] args) {
        implementSynchronization instance1 = new implementSynchronization();
        Thread t1 = new Thread(instance1::method1);
        Thread t2 = new Thread(instance1::method2);

        t1.start();
        t2.start();

    }
}
