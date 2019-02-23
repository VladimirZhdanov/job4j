package ru.job4j.exam;

import java.util.ArrayList;

public class CoffeeMachine {

    public int[] changes(int value, int price) throws InsufficientFundsException {
        int change = value - price;
        if (change < 0) {
            throw new InsufficientFundsException("Insufficient funds, Could you please put additional money?");
        }
        ArrayList<Integer> array = new ArrayList<>();
        while (change >= 10) {
            change -= 10;
            array.add(10);
        }
        while (change >= 5) {
            change -= 5;
            array.add(5);
        }
        while (change >= 2) {
            change -= 2;
            array.add(2);
        }
        while (change > 0) {
            change -= 1;
            array.add(1);
        }
        return array.stream().mapToInt(x -> x).toArray();
    }
    /*public static void main(String[] args) {
        CoffeeMachine cf = new CoffeeMachine();
        int[] sa = cf.changes(100, 101);
        for (int i = 0; i < sa.length; i++) {
            System.out.println(sa[i]);
        }
    }*/
}
