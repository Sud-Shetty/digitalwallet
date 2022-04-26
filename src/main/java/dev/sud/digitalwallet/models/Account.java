package dev.sud.digitalwallet.models;

import dev.sud.digitalwallet.utility.AccountNumberGenerator;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.TreeSet;

@Getter
@Setter
public class Account {
    private int accountNumber;
    private User user;
    private long balance;
    private Set<Transaction> transactions;

    public Account(String name,long balance){
        this.user=new User(name);
        this.balance=balance;
        this.accountNumber= AccountNumberGenerator.getNextAccountNumber();
        this.transactions=new TreeSet<>((a,b) -> a.getDate().compareTo(b.getDate()));
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber=" + accountNumber +
                ", name=" + this.user.getName() +
                ", balance=" + balance +
                ", transactions=" + transactions +
                '}';
    }
}
