package post_requests;

import base_urls.ReqresBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Post07Map_Ile extends ReqresBaseUrl {

    /*
        Given
            1) https://reqres.in/api/users
            2) {
                "name": "morpheus",
                "job": "leader"
                }
        When
            I send POST Request to the Url
        Then
            Status code is 201
            And response body should be like {
                                                "name": "morpheus",
                                                "job": "leader",
                                                "id": "496",
                                                "createdAt": "2022-10-04T15:18:56.372Z"
                                              }
*/

    @Test
    public void post07() {

        //set the url
        spec.pathParam("1","users");

        //set the expected data
        Map<String,String> expectedData=new HashMap<>();
        expectedData.put("name","morpheus");
        expectedData.put("job","leader");
        System.out.println("expectedData = " + expectedData);

        //send the request and set the url
        Response response=given().spec(spec).contentType(ContentType.JSON).body(expectedData).post("/{1}");
        response.prettyPrint();

        //do assertion
        Map<String,String>actualData=response.as(HashMap.class);
        System.out.println(actualData);

        assertEquals(expectedData.get("name"),actualData.get("name"));
        assertEquals(expectedData.get("job"),actualData.get("job"));

    }
}
