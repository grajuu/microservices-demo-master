package io.pivotal.microservices.accounts;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.pivotal.microservices.exceptions.AccountNotFoundException;

/**
 * A RESTFul controller for accessing account information.
 * 
 * @author Govind Raju
 */
@RestController
public class AccountsController {

	protected Logger logger = Logger.getLogger(AccountsController.class
			.getName());
	protected AccountRepository accountRepository;

	/**
	 * 
	 * @param accountRepository
	 *            An account repository implementation.
	 */
	@Autowired
	public AccountsController(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;

		logger.info("AccountRepository says system has "
				+ accountRepository.countAccounts() + " accounts");
	}

	/**
	 * Fetch an account with the specified account number.
	 * 
	 * @param accountNumber
	 *            A numeric, 9 digit account number.
	 * 
	 */
	@RequestMapping("/accounts/{accountNumber}")
	public Account byNumber(@PathVariable("accountNumber") String accountNumber) {

		logger.info("accounts-service byNumber() invoked: " + accountNumber);
		Account account = accountRepository.findByNumber(accountNumber);
		logger.info("accounts-service byNumber() found: " + account);

		if (account == null)
			throw new AccountNotFoundException(accountNumber);
		else {
			return account;
		}
	}

	/**
	 * 
	 * Getting by name for using the name string 
	 */
	@RequestMapping("/accounts/owner/{name}")
	public List<Account> byOwner(@PathVariable("name") String partialName) {
		logger.info("accounts-service byOwner() invoked: "
				+ accountRepository.getClass().getName() + " for "
				+ partialName);

		List<Account> accounts = accountRepository
				.findByOwnerContainingIgnoreCase(partialName);
		logger.info("accounts-service byOwner() found: " + accounts);

		if (accounts == null || accounts.size() == 0)
			throw new AccountNotFoundException(partialName);
		else {
			return accounts;
		}
	}
	
	/**
	 * 
	 * Getting by Location for using the name string 
	 * We can send one more variables from request mapping like limit in pay load 
	 * or we can make a object for ( n ) variables  
	 * 
	 * @RequestMapping("/accounts/location/{location}/{"requir_limit"}")
	 */
	
	
	@RequestMapping("/accounts/location/{location}")
	public List<Account> byLocation(@PathVariable("location") String location){
		logger.info("accounts-service byLocation() invoked: "
				+ accountRepository.getClass().getName() + " for "
				+ location);
		List<Account> accounts = accountRepository
				.findByLocation(location);
		
		/*     Un-comment for validation  
		 *     -- This for checking the limit 
		 *     --  We are checking this in Object side because we Load the Entity in container
		 *     -- For that count() method will useful "select count" 
		 *     
		 * if (accounts.size() < requir_limit) {
			throw new AccountNotFoundException(location);
		}*/
			
		logger.info("accounts-service location() found: " + accounts);
		if (accounts == null || accounts.size() == 0)
			throw new AccountNotFoundException(location);
		else {
			return accounts;
			}
	}  
}
