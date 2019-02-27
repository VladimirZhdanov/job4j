package ru.job4j.exam;

import java.util.ArrayList;
import java.util.stream.Stream;

public class CoffeeMachine {
    private int ten = 10;
    private int countOfTen;

    private int five = 5;
    private int countOfFive;

    private int two = 2;
    private int countOfTwo;

    private int one = 1;
    private int countOfOne;
    int[] buffer;

    public CoffeeMachine(int countOfTen, int countOfFive, int countOfTwo, int countOfOne) {
        this.countOfTen = countOfTen;
        this.countOfFive = countOfFive;
        this.countOfTwo = countOfTwo;
        this.countOfOne = countOfOne;
    }


    private boolean check(int value, int price) throws InsufficientFundsException {
        boolean result = false;
        int change = value - price;
        if (change < 0) {
            throw new InsufficientFundsException("Insufficient funds, Could you please put additional money?");
        }
        ArrayList<Integer> array = new ArrayList<>();
        while (change >= ten && countOfTen > 0) {
            change -= ten;
            array.add(ten);
            countOfTen--;
        }
        while (change >= five && countOfFive > 0) {
            change -= five;
            array.add(five);
            countOfFive--;
        }
        while (change >= two && countOfTwo > 0) {
            change -= two;
            array.add(two);
            countOfTwo--;
        }
        while (change > 0 && countOfOne > 0) {
            change -= one;
            array.add(one);
            countOfOne--;
        }

        int sum = array.stream().mapToInt(x -> x).sum();
        if (sum == value - price) {
            buffer = array.stream().mapToInt(x -> x).toArray();
            result = true;
        }
        return result;
    }

    public int[] changes(int value, int price) throws InsufficientFundsException {
        if (check(value, price)) {
            return buffer;
        } else {
            return new int[] {value};
        }
    }
    /*public static void main(String[] args) {
        CoffeeMachine cf = new CoffeeMachine(10, 1, 5, 2, 2, 5, 1, 3);
        int[] sa = cf.changes(100, 70);
        for (int i = 0; i < sa.length; i++) {
            System.out.println(sa[i]);
        }
    }*/
}
