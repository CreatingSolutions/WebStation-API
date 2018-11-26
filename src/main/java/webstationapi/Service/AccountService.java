package webstationapi.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webstationapi.Entity.Account;
import webstationapi.Repository.AccountRepository;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public void getAll() {
        Iterable<Account> all = this.accountRepository.findAll();

        for (Account a : all) {
            System.out.println("UUID => " + a.getId());
        }

    }

}
