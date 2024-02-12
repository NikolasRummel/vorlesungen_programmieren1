package de.dhbw.nikolas.exercise.classes;

import java.util.UUID;

public class Account {

    private UUID id;
    private String owner;
    private double balance;
    private double limit;


    public Account(UUID id, String owner, double balance, double limit) {
        this.id = id;
        this.owner = owner;
        this.balance = balance;
        this.limit = limit;
    }

    public Account(String owner, double balance, double limit) {
        this.id = UUID.randomUUID();
        this.owner = owner;
        this.balance = balance;
        this.limit = limit;
    }

    public Account(String owner, double balance) {
        this.id = UUID.randomUUID();
        this.owner = owner;
        this.balance = balance;
        this.limit = 20000;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && (balance - amount >= limit)) {
            balance -= amount;
        } else {
            System.out.println("Not enough money or amount is negative");
        }
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", owner='" + owner + '\'' +
                ", balance=" + balance +
                ", limit=" + limit +
                '}';
    }

    public static void main(String[] args) {
        Account account = new Account("Nikolas", 1000);
        account.deposit(250);
        System.out.println(account.getBalance());
        account.withdraw(4500);
        System.out.println(account.getBalance());
        System.out.println(account);
    }
}
