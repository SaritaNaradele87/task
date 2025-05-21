package net.javaguide.banking.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguide.banking.Dto.AccountDTO;
import net.javaguide.banking.service.AccountService;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    
    @GetMapping("/all")
    public ResponseEntity<List<AccountDTO>> getAll(){
    	List<AccountDTO> list=accountService.getAll();
    	
    	return ResponseEntity.ok(list);    	
    }
    
    @PostMapping("/add")
    public ResponseEntity<AccountDTO> addAccount(@RequestBody AccountDTO accountDto) {
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<AccountDTO> getAccountById(@PathVariable Long id) {
        return new ResponseEntity<>(accountService.getAccountById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDTO> deposit(@PathVariable Long id, @RequestBody Map<String, Double> request) {
        Double amount = request.get("amount");
        AccountDTO accountDto = accountService.deposit(id, amount);
        return ResponseEntity.ok(accountDto);
    }
    
    

    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDTO> withdraw(@PathVariable Long id, @RequestBody Map<String, Double> request) {
        Double amount = request.get("amount");
        AccountDTO accountDto = accountService.withdraw(id, amount);
        return ResponseEntity.ok(accountDto);
    }
    
    @DeleteMapping("/id")
    public ResponseEntity<String> delete(@PathVariable Long id){
	accountService.deleteAccount(id);
	return ResponseEntity.ok("account deleted successfully");
    	
    	
    }
}


