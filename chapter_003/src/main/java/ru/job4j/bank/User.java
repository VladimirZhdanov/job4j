package ru.job4j.bank;

public class User {
    private String name;
    private String passport;
    private int age;

    public User(String name, String password, int age) {
        this.name = name;
        this.passport = password;
        this.age = age;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public String getPassport() {
        return passport;
    }

    public int getAge() {
        return age;
    }
}
