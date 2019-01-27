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

    public boolean addUser(User user) {
        boolean res = false;
        if (this.treemap.putIfAbsent(user, new ArrayList<>()) == null) {
            res = true;
        }
        return res;
    }

    public boolean deleteUser(User user) {
        boolean res = false;
        if (this.treemap.remove(user) != null) {
            res = true;
        }
        return res;
    }

    public boolean addAccount(User user, Account account) {
        boolean res = false;
        final ArrayList<Account> accounts = this.treemap.get(user);
        if (accounts != null && !accounts.contains(account)) {
            accounts.add(account);
            res = true;
        }
        return res;
    }

    public boolean deleteAccountByRequisites(User user, String requisites) {
        boolean res = false;
        final ArrayList<Account> accounts = treemap.get(user);
        if (accounts != null) {
            for (int i = 0; i < accounts.size(); i++) {
                if (accounts.get(i).getRequisites().equals(requisites)) {
                    accounts.remove(i);
                    res = true;
                    break;
                }
            }
        }
        return res;
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