package io.pivotal.microservices.accounts;

import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 
 * @author Govind Raju
 * 
 *
 */
@RunWith(SpringRunner.class)
@EnableAutoConfiguration
@SpringBootTest(classes = AccountsConfiguration.class, properties = { "eureka.client.enabled=false" })
public class AccountsControllerIntegrationTests extends AbstractAccountControllerTests {

}
