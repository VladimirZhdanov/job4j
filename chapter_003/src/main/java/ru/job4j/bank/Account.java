package ru.job4j.bank;

public class Account {

    double values; //Доступ должен быть private
    String reqs;   //Доступ должен быть private, переименовать в requisites

    public Account(double values, String requisites) {
        this.values = values;
        this.reqs = requisites;
    }

    public double getValues() {
        return this.values;
    }


    public String getReqs () {  //убрать пробел перед скобкой, название ...Requisites
        return this.reqs;
    }

    boolean transfer(Account destination, double amount) { //доступ
        boolean success = false;
        if (amount > 0 && amount < this.values && destination != null) {
            success = true;
            this.values -= amount;
            destination.values += amount;
        }
        return success;
    }
 // @Override
    public String toString() {
        String otvet; // return "Account{" + "values=" + values + ", reqs='" + reqs + "\\" + "}";
        otvet = "Account{" + "values=" + values + ", reqs='" + reqs + "\\" + "}";
        return otvet;
    }
    // @Override  , сделать 1 return
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Account account = (Account) o;

        return this.reqs.equals(account.reqs);
    }
    // @Override
    public int hashCode() {
        return this.reqs.hashCode();
    }
}