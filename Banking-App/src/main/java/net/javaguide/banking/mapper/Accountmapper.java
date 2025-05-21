package net.javaguide.banking.mapper;

import net.javaguide.banking.Dto.AccountDTO;
import net.javaguide.banking.entity.Account;

public class Accountmapper {
	

	
    public static Account mapToAccount(AccountDTO accountDto) {
      Account account= new Account(
            accountDto.getId(),
            accountDto.getAccountHolderName(),
            accountDto.getBalance()
        );
      return account;
    }

    public static AccountDTO mapToAccountDTO(Account account) {
    	
    	AccountDTO accountDto=new AccountDTO( account.getId(),
                account.getAccountHolderName(),
                account.getBalance()
                );
    			
        return accountDto;
           
       
    }
}

