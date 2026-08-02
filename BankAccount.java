public class BankAccount {
    private boolean isOpen = false;
    private int balance = 0;

    public void open() throws BankAccountActionInvalidException {
        if (isOpen) {
            throw new BankAccountActionInvalidException("Account already open");
        }
        isOpen = true;
        balance = 0;
    }

    public void close() throws BankAccountActionInvalidException {
        if (!isOpen) {
            throw new BankAccountActionInvalidException("Account already closed");
        }
        isOpen = false;
    }

    public synchronized int getBalance() throws BankAccountActionInvalidException {
        if (!isOpen) {
            throw new BankAccountActionInvalidException("Account closed");
        }
        return balance;
    }

    public synchronized void deposit(int amount) throws BankAccountActionInvalidException {
        if (!isOpen) {
            throw new BankAccountActionInvalidException("Account closed");
        }
        if (amount < 0) {
            throw new BankAccountActionInvalidException("Cannot deposit negative amount");
        }
        balance += amount;
    }

    public synchronized void withdraw(int amount) throws BankAccountActionInvalidException {
        if (!isOpen) {
            throw new BankAccountActionInvalidException("Account closed");
        }
        if (amount < 0) {
            throw new BankAccountActionInvalidException("Cannot withdraw negative amount");
        }
        if (amount > balance) {
            throw new BankAccountActionInvalidException("Cannot withdraw more money than is available");
        }
        balance -= amount;
    }
}