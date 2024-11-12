package multithreading.SynchronizationOnObject;

public class Runner {
    public static void main(String[] args) throws InterruptedException {
        Bankbalance bankbalance = new Bankbalance(5000D);

        Thread thread1 = new Thread(() -> {
            while (bankbalance.getBalance() > 0) {
                try {
                    bankbalance.deductBalance(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "Thread-1");

        Thread thread2 = new Thread(() -> {
            while (bankbalance.getBalance() > 0) {
                try {
                    bankbalance.deductBalance(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "Thread-2");

        thread1.start();
        thread2.start();

    }
}
