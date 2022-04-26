package dev.sud.digitalwallet.utility;

public class AccountNumberGenerator {
    private static int accountNumber=1;

    public static int getNextAccountNumber(){
        return ++accountNumber;
    }
}
