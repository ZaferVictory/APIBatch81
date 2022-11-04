package post_requests;

import base_urls.JsonplaceholderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post01_ExpectedMap_Ve_ActualMap_AssertionYapma extends JsonplaceholderBaseUrl {
    /*
    Given
      1)  https://jsonplaceholder.typicode.com/todos
      2)  {
            "userId": 55,
            "title": "Tidy your room",
            "completed": false
           }
   When
    I send POST Request to the Url
   Then
       Status code is 201
   And
       response body is like {
                               "userId": 55,
                               "title": "Tidy your room",
                               "completed": false,
                               "id": 201
                               }
*/

    @Test
    public void post01() {
        //set the url
        spec.pathParam("1","todos");

        //set the expected data
        JsonPlaceHolderTestData obj=new JsonPlaceHolderTestData();
        Map<String,Object>expecteddata=obj.expectedDataMethod(55,"Tidy your room",false);

        // 3. Send The Request And Get The Response
        Response response=given().spec(spec).contentType(ContentType.JSON).body(expecteddata).when().post("/{1}");
        response.prettyPrint();

        // 4. Do Assertion
        Map<String,Object>actualData=response.as(HashMap.class);

        assertEquals(expecteddata.get("completed"),actualData.get("completed"));
        assertEquals(expecteddata.get("title"),actualData.get("title"));
        assertEquals(expecteddata.get("userId"),actualData.get("userId"));


    }
}
