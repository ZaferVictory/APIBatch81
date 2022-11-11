package Delete_request;

import base_urls.JsonplaceholderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import utils.ObjectMapperUtils;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Delete01Map_actualData_ObjectMapperUtils_convertJsonToJava_response_asString_HashMap_class extends JsonplaceholderBaseUrl {
    /*
        Given
            https://jsonplaceholder.typicode.com/todos/198
        When
	 		I send DELETE Request to the Url
	 	Then
		 	Status code is 200
		 	And Response body is { }
     */

    @Test
    public void delete01() {
// set the url
        spec.pathParams("first","todos","second",198);

        //set the expected data
        Map<String,String>expectedData=new HashMap<>();

        // send the request and get the response

       Response response= given().spec(spec).when().delete("/{first}/{second}");
       response.prettyPrint();

       //do assertion
        Map actualData=ObjectMapperUtils.convertJsonToJava(response.asString(), HashMap.class);

        assertEquals(200,response.statusCode());

        //1.yol
        assertEquals(expectedData,actualData);

        //2.yol
        assertTrue(actualData.isEmpty());

        //3yol
        assertEquals(0,actualData.size());




    }
}
