package net.javaguide.banking.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import net.javaguide.banking.Dto.AccountDTO;
import net.javaguide.banking.entity.Account;
import net.javaguide.banking.exception.AccountException;
import net.javaguide.banking.mapper.Accountmapper;
import net.javaguide.banking.repository.AccountRepository;


@Service
public class AccounterviceImpl implements AccountService{

	
	private AccountRepository accountRepository;
	
	
	public AccounterviceImpl(AccountRepository accountRepository) {
	
		this.accountRepository = accountRepository;
	}


	@Override
	public AccountDTO createAccount(AccountDTO accountDto) {
		Account account=Accountmapper.mapToAccount(accountDto);
		// TODO Auto-generated method stub
	Account savedAccount=	accountRepository.save(account);
		return Accountmapper.mapToAccountDTO(savedAccount);
	}

     


	@Override
	public List<AccountDTO> getAll() {
	    List<Account> list = accountRepository.findAll();
	    return list.stream()
	               .map(account -> Accountmapper.mapToAccountDTO(account))
	               .collect(Collectors.toList());
	}



	public AccountDTO deposit(Long id, double amount) {
		// TODO Auto-generated method stub
		Account account = accountRepository.findById(id)
		        .orElseThrow(() -> new AccountException("Account does not exist"));
		      double total= account.getBalance()+ amount;
		    account.setBalance(total);
		    Account savedAccount=accountRepository.save(account);
		    return Accountmapper.mapToAccountDTO(savedAccount);
	
	}


	@Override
	public AccountDTO getAccountById(Long id) {
	    Account account = accountRepository.findById(id)
	        .orElseThrow(() -> new AccountException("Account does not exist"));
	    
	    return Accountmapper.mapToAccountDTO(account);
	}


	@Override
	public AccountDTO withdraw(Long id, double amount) {
		  Account account = accountRepository.findById(id)
			        .orElseThrow(() -> new AccountException("Account does not exist"));
			  
		  
		  if(account.getBalance()<amount) {
			  throw new AccountException("Insufficient Balance");
			  
		  }
		  
		  double total= account.getBalance()-amount;
		  account.setBalance(total);
		// TODO Auto-generated method stub
		  Account withdraw=accountRepository.save(account);
		  
		return Accountmapper.mapToAccountDTO(withdraw);
	}


	@Override
	public void deleteAccount(Long id) {
		// TODO Auto-generated method stub
		 Account account = accountRepository.findById(id)
			        .orElseThrow(() -> new AccountException("Account does not exist"));
                  accountRepository.deleteById(id);		
	}


}
