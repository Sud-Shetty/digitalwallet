package dev.sud.digitalwallet.services;

import ch.qos.logback.core.net.SyslogOutputStream;
import dev.sud.digitalwallet.dao.WalletDao;
import dev.sud.digitalwallet.models.Account;
import dev.sud.digitalwallet.models.Transaction;

import java.util.Date;

public class WalletService {

    private WalletDao dao;
    public WalletService(){
        dao=new WalletDao();
    }

    public void createWallet(String name,long amount){
        Account account=new Account(name,amount);
        dao.getAccountMap().put(account.getAccountNumber(),account);
        System.out.println("Wallet created successfully with name="+name+" and Account number= "+account.getAccountNumber());
    }

    public void transfer(int fromAccNum, int toAccNum, long transferAmount){
        if(!validate(fromAccNum,toAccNum,transferAmount))
            return;
        Transaction tran=new Transaction(fromAccNum,toAccNum,transferAmount,new Date());

        Account fromAccount=dao.getAccountMap().get(fromAccNum);
        Account toAccount=dao.getAccountMap().get(toAccNum);

        if((fromAccount.getBalance()-transferAmount) < 0){
            System.out.println("Insufficient balance!");
            return;
        }
        fromAccount.setBalance(fromAccount.getBalance()-transferAmount);
        toAccount.setBalance(toAccount.getBalance()+transferAmount);
        fromAccount.getTransactions().add(tran);
        toAccount.getTransactions().add(tran);
        System.out.println("Transaction successful");
    }

    private boolean validate(int fromAccNum,int toAccNum,long transactionAmount){
        if(fromAccNum == toAccNum){
            System.out.println("Sender and receiver can not be same");
            return false;
        }
        if(!dao.getAccountMap().containsKey(fromAccNum)){
            System.out.println("Invalid sender account number");
            return false;
        }
        if(!dao.getAccountMap().containsKey(toAccNum)) {
            System.out.println("Invalid receiver account number");
            return false;
        }
        if(transactionAmount<0.001) {
            System.out.println("Amount is too low");
            return false;
        }
        return true;
    }

    public void statement(int accNumber){
        Account account=dao.getAccountMap().get(accNumber);
        if(account==null){
            System.out.println("Invalid account number");
            return;
        }
        System.out.println("Statement for Account number :"+accNumber);
        System.out.println("Current balance :"+account.getBalance());
        System.out.println("Your transaction history");
        System.out.println(account.getTransactions());
    }

    public void overview(){
        for(int accNum: dao.getAccountMap().keySet()){
            System.out.print("Balance for account number "+accNum+" is :");
            System.out.println(dao.getAccountMap().get(accNum).getBalance());
        }
    }
}
