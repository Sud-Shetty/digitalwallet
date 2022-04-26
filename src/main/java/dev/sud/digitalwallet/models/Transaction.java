package dev.sud.digitalwallet.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Transaction {
    private int from;
    private int to;
    private long amount;
    private Date date;

    public Transaction(int from, int to, long amount, Date date){
        this.from=from;
        this.to=to;
        this.amount=amount;
        this.date=date;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "from=" + from +
                ", to=" + to +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }
}
