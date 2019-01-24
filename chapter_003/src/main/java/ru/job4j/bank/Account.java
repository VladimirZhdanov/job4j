package ru.job4j.bank;

public class Account {

    private double values;
    private String requisites;

    public Account(double values, String requisites) {
        this.values = values;
        this.requisites = requisites;
    }

    public double getValues() {
        return this.values;
    }

    public String getRequisites() {
        return this.requisites;
    }

    public boolean transfer(Account destination, double amount) {
        boolean success = false;
        if (amount > 0 && amount <= this.values && destination != null) {
            success = true;
            this.values -= amount;
            destination.values += amount;
        }
        return success;
    }

    @Override
    public String toString() {
        return "Account{" + "values=" + values + ", requisites='" + requisites + "\\" + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Account account = (Account) o;

        return this.requisites.equals(account.requisites);
    }

    @Override
    public int hashCode() {
        return this.requisites.hashCode();
    }
}