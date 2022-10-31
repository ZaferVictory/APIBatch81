package get_requests;

import base_urls.RestfulBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.testng.AssertJUnit.*;

public class Get04b extends RestfulBaseUrl {

     /*
    Given
        https://restful-booker.herokuapp.com/booking?firstname=Almedin&lastname=Alikadic
    When
        User sends get request to the URL
    Then
        Status code is 200
And
   Among the data there should be someone whose firstname is "Almedin" and lastname is "Alikadic"

 */
    //Set the Url
//Set The Expected Data
//Send The Request and Get The Response
//Do Assertion


    @Test
    public void get04() {
        //Set the Url
        spec.pathParams("first","booking").queryParams("firstname","Andrey","lastname","Hernandez");

        //Set The Expected Data

        //Send The Request and Get The Response
            Response response=given().spec(spec).when().get("/{first}");
            response.prettyPrint();

        //Do Assertion
        //assertEquals(200,response.statusCode());
        //assertTrue(response.asString().contains("bookingid"));

    }
}
