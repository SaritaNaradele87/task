package net.javaguide.banking.service;

import java.util.List;

import net.javaguide.banking.Dto.AccountDTO;
import net.javaguide.banking.entity.Account;

public interface AccountService {
         AccountDTO createAccount(AccountDTO accountDto);
         AccountDTO deposit(Long id,double amount);
         AccountDTO getAccountById(Long id);
        List<AccountDTO>getAll();
        AccountDTO withdraw(Long id,double amount);
        void deleteAccount(Long id);
}
