package com.banking.javabankingapplication.bankuser;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<BankUser> users = new ArrayList<>();

    public void addUser(BankUser user) {
        users.add(user);
    }

}
