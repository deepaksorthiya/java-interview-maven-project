package com.example.designprinciples;

public class SolidDpExample {

    public static void main(String[] args) {
        TransactionLogger logger = new ConsoleTransactionLogger();
        Account checkingAccount = new CheckingAccount(logger);
        checkingAccount.deposit(1000);
        checkingAccount.withdraw(500);
        System.out.println(checkingAccount.getBalance());

        TransactionManager checkingTransactionManaget = new TransactionManager(checkingAccount);
        double checkingBalance = checkingTransactionManaget.checkBalance();
        checkingTransactionManaget.performDeposit(1000);
        checkingTransactionManaget.performWithdrawal(500);
        System.out.println(checkingBalance);

        Account savingsAccount = new SavingsAccount(logger);
        savingsAccount.deposit(1000);
        savingsAccount.withdraw(500);
        System.out.println(savingsAccount.getBalance());

        TransactionManager savingTransactionManager = new TransactionManager(savingsAccount);
        double savingBalance = savingTransactionManager.checkBalance();
        savingTransactionManager.performDeposit(1000);
        savingTransactionManager.performWithdrawal(500);
        System.out.println(savingBalance);
    }

    // Interface for accounts
    interface Account {
        void deposit(double amount);

        void withdraw(double amount);

        double getBalance();
    }

    // Interface for transaction logging
    interface TransactionLogger {
        void logTransaction(String transactionDetails);
    }

    // Checking Account
    static class CheckingAccount implements Account {
        private double balance;
        private TransactionLogger transactionLogger;

        public CheckingAccount(TransactionLogger logger) {
            this.transactionLogger = logger;
        }

        public void deposit(double amount) {
            balance += amount;
            transactionLogger.logTransaction("Deposited $" + amount + " into Checking Account");
        }

        public void withdraw(double amount) {
            if (balance >= amount) {
                balance -= amount;
                transactionLogger.logTransaction("Withdrawn $" + amount + " from Checking Account");
            } else {
                System.out.println("Insufficient funds");
            }
        }

        public double getBalance() {
            return balance;
        }
    }

    // Savings Account
    static class SavingsAccount implements Account {
        private double balance;
        private TransactionLogger transactionLogger;

        public SavingsAccount(TransactionLogger logger) {
            this.transactionLogger = logger;
        }

        public void deposit(double amount) {
            balance += amount;
            transactionLogger.logTransaction("Deposited $" + amount + " into Savings Account");
        }

        public void withdraw(double amount) {
            if (balance >= amount) {
                balance -= amount;
                transactionLogger.logTransaction("Withdrawn $" + amount + " from Savings Account");
            } else {
                System.out.println("Insufficient funds");
            }
        }

        public double getBalance() {
            return balance;
        }
    }

    // Simple console-based transaction logger
    static class ConsoleTransactionLogger implements TransactionLogger {
        public void logTransaction(String transactionDetails) {
            System.out.println(transactionDetails);
        }
    }

    // Class to perform transactions
    static class TransactionManager {
        private Account account;

        public TransactionManager(Account account) {
            this.account = account;
        }

        public void performDeposit(double amount) {
            account.deposit(amount);
        }

        public void performWithdrawal(double amount) {
            account.withdraw(amount);
        }

        public double checkBalance() {
            return account.getBalance();
        }
    }
}

