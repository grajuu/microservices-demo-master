# microservices-demo 
# For Simple rest call  

 ##  For Terralogic 
 
 Processs to run 
 
  Get it the Root location 
 
java -jar target/microservices-demo-2.0.0.RELEASE.jar registration

java -jar target/microservices-demo-2.0.0.RELEASE.jar accounts

java -jar target/microservices-demo-2.0.0.RELEASE.jar web

++---------------------------------------------------------------------------------------------------------------------++
AccountsController.java -->      You can find the expected logic
AccountNotFoundException.java ---> Custmized Runtime Exception.
SearchCriteria.java   ------> Server side validation
AccountRepository.java --->  public interface AccountRepository extends Repository<Account, Long>  for all custmized DB actions .
protected static class TestAccountRepository implements AccountRepository  :: Implemented for making available for all micro services.
                                 											For only this Demo only
                                 								-- Conditional logic was Commented for (N) count --  			
++---------------------------------------------------------------------------------------------------------------------++  

URL:   http://localhost:1111/  :For Eureka DashBoard
URL:   http://192.168.0.100:3333/accounts/location/usa   :For specific Location 

URL:   http://192.168.0.100:3333/

URL:  http://192.168.0.100:3333/accounts/search  : Account Search 

URL:  :http://192.168.0.100:2222/actuator/beans   : Actuator Beans 
URL : http://192.168.0.100:2222/actuator    End Points 
URL : http://192.168.0.100:2222/actuator/mappings    Mappings 
++----------------------------------------------------------------------------------------------------------------------++

Spring :Eureka , Netflex API, MicroService 

DB : H2 Memory DB

        You can configure with your desire DB like MYSQL and etc in the following conf file 
        
  ---  db-config.properties      
  -- data.sql
  -- schema.sql
  
  ++---------------------------------------------------------------------------------------------------------------------++
  
  Autogenereted Gradle also available but not si=ure all dependencies are available 
  
  +--------------------------------------------------------------------------------------------------------------------------++
  
  There might be JaxB parse exception will appear if you on java 9 :  but no worry in you can still move on
  +--------------------------------------------------------------------------------------------------------------- 
    
        



                              											


 

 


														



