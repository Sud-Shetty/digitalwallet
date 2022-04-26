package dev.sud.digitalwallet.dao;

import dev.sud.digitalwallet.models.Account;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class WalletDao {
    private Map<Integer, Account> accountMap;

    public WalletDao(){
        this.accountMap=new HashMap<>() ;
    }
}
