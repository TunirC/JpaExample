package multithreading.SynchronizationOnObject;

public class Bankbalance {
    private double balance;

    public Bankbalance(double balance) {
        this.balance = balance;
    }

    public synchronized void deductBalance(double amount) throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+" attempting to deduct amount: "+amount);
        if (balance >= amount) {
            Thread.sleep(4000);
        } else {
            System.out.println(Thread.currentThread().getName()+ " - insufficient balance");
            return;
        }

        balance = balance - amount;
        System.out.println("Withdrawal completed by "+ Thread.currentThread().getName() +", current balance: "+balance);
    }

    public void addBalance(double amount) {
        System.out.println(Thread.currentThread().getName()+" attempting to add amount: "+amount);
        balance = balance + amount;
    }

    public double getBalance() {
        return balance;
    }
}
