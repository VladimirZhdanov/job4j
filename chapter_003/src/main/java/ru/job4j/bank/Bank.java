package ru.job4j.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Bank
 *
 * @author Vladimir Zhdanov (mailto:constHomeSpb@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Bank {
    private TreeMap<User, ArrayList<Account>> treemap = new TreeMap<>();

    public TreeMap<User, ArrayList<Account>> getTreemap() {
        return treemap;
    }

    public void addUser(User user) {
        this.treemap.putIfAbsent(user, new ArrayList<>());
    }

    public void deleteUser(User user) {
        this.treemap.remove(user);
    }

    public void addAccount(User user, Account account) throws BankException {
        try {
            for (Account value : this.treemap.get(user)) {
                if (value.getRequisites() == account.getRequisites()) {
                    throw new BankException("The requisites already is used.");
                }
            }
            this.treemap.get(user).add(account);
        } catch (NullPointerException e) {
            System.out.println("User is not found: " + e);
        } catch (BankException e) {
            System.out.println(e);
        }
    }

    public void deleteAccountByRequisites(User user, String requisites) {
        try {
            for (Account value : this.treemap.get(user)) {
                if (value.getRequisites() == requisites) {
                    this.treemap.get(user).remove(value);
                }
            }
        } catch (NullPointerException e) {
            System.out.println("User is not found: " + e);
        }
    }

    public User getUserByPassport(String passport) {
        User result = null;
        for (User user : this.treemap.keySet()) {
            if (user.getPassport().equals(passport)) {
                result = user;
            }
        }
        return result;
    }

    public List<Account> getUserAccounts(String passport) {
        return this.treemap.get(getUserByPassport(passport));
    }

    public Account getAccountByRequisiteFromUserPassport(String passport, String requisite) {
        List<Account> accounts = getUserAccounts(passport);
        Account result = null;
        for (Account acc : accounts) {
            if (acc.getRequisites().equals(requisite)) {
                result = acc;
            }
        }
        return result;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                  String destPassport, String destRequisite, double amount) {
        User user1 = getUserByPassport(srcPassport);
        User user2 = getUserByPassport(destPassport);
        Account account1 = getAccountByRequisiteFromUserPassport(srcPassport, srcRequisite);
        Account account2 = getAccountByRequisiteFromUserPassport(destPassport, destRequisite);
        return this.treemap.get(user1).contains(account1)
                && this.treemap.get(user2).contains(account2)
                && account1.transfer(account2, amount);
    }

    @Override
    public String toString() {
        return "Bank{" + "accounts=" + treemap + "}";
    }
}