public class Account {
    private double balance;
    private int version;

    public Account(double balance, int version) {
        this.balance = balance;
        this.version = version;
    }

    public synchronized void updateBalance(double newBalance, int newVersion) {
        if (newVersion == version) {
            balance = newBalance;
            version = newVersion;
            System.out.println("Balance updated successfully.");
        } else {
            System.out.println("Concurrent modification detected. Retry update.");
        }
    }

    public double getBalance() {
        return balance;
    }

    public int getVersion() {
        return version;
    }
}
