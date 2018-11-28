
/*
 * @author Govind Raju
 */

package io.pivotal.microservices.accounts;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;

public class AccountsControllerTests extends AbstractAccountControllerTests {

	protected static final Account theAccount = new Account(ACCOUNT_1,
			ACCOUNT_1_NAME,ACCOUNT_1_LOCATION);

	protected static class TestAccountRepository implements AccountRepository {

		@Override
		public Account findByNumber(String accountNumber) {
			if (accountNumber.equals(ACCOUNT_1))
				return theAccount;
			else
				return null;
		}

		@Override
		public List<Account> findByOwnerContainingIgnoreCase(String partialName) {
			List<Account> accounts = new ArrayList<Account>();

			if (ACCOUNT_1_NAME.toLowerCase().indexOf(partialName.toLowerCase()) != -1)
				accounts.add(theAccount);

			return accounts;
		}

		@Override
		public int countAccounts() {
			return 1;
		}
		
		@Override
		public List<Account> findByLocation(String location) {
			List<Account> location1 = new ArrayList<Account>();
			if (ACCOUNT_1_LOCATION.equals(location))
				location1.add(theAccount);
			return location1;
		}
	}

	protected TestAccountRepository testRepo = new TestAccountRepository();

	@Before
	public void setup() {
		accountController = new AccountsController(testRepo);
	}
}
