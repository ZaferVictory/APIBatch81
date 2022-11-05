package post_requests;

import base_urls.JsonplaceholderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.JsonPlacehOlderPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post3Pojo extends JsonplaceholderBaseUrl {

    /*
         Given
            https://jsonplaceholder.typicode.com/todos
            {
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
    public void post03Pojo() {


        //set the url
        spec.pathParam("first","todos");

        //Set The Expected Data
        JsonPlacehOlderPojo expectedData=new JsonPlacehOlderPojo(55,"Tidy your room",false);
        System.out.println("expectedData "+expectedData);

        //send the post request and get the response
       Response response= given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("/{first}");
       response.prettyPrint();
       
       //Do assertion
        JsonPlacehOlderPojo actualData=response.as(JsonPlacehOlderPojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200,response.statusCode());
        assertEquals(expectedData.getUserId(),actualData.getUserId());
        assertEquals(expectedData.getTitle(),actualData.getTitle());
        assertEquals(expectedData.getCompleted(),actualData.getCompleted());




        //@JsonIgnoreProperties(ignoreUnknown = true) actual data altında
        // sonradan gelen Id vardı expected data altında bu ıd yok o yuzden failed veriyordu.
        // bizde bu classla ıd'yı ayırdık. yok saydık artık gorunmeyecek




    }
}
