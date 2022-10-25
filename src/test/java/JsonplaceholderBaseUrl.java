import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import org.testng.annotations.BeforeMethod;

public class JsonplaceholderBaseUrl {
   protected RequestSpecification spec;


    @Before
   public void setup(){
       spec=new RequestSpecBuilder().setBaseUri("https://jsonplaceholder.typicode.com").build();

   }

}
