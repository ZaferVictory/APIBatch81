package post_requests;

import base_urls.JsonplaceholderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.JsonPlaceHolderPojo;
import utils.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post05ObjectMapper_Pojo extends JsonplaceholderBaseUrl {
/*
         Given
           1) https://jsonplaceholder.typicode.com/todos
           2) {
                 "userId": 55,
                 "title": "Tidy your room",
                 "completed": false
               }
            I send POST Request to the Url
        Then
            Status code is 201
        And
            response body is like  {
                                    "userId": 55,
                                    "title": "Tidy your room",
                                    "completed": false,
                                    "id": 201
                                    }
     */

    @Test
    public void post05ObjectMapper() {

        //set the url
        spec.pathParam("first","todos");

        //set the expected data
        JsonPlaceHolderPojo expectedData=new JsonPlaceHolderPojo(55,"Tidy your room",false);

        // send the request and SET the response
       Response response= given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("/{first}");
        response.prettyPrint();

        //Do assertion
        JsonPlaceHolderPojo actualdata=ObjectMapperUtils.convertJsonToJava(response.asString(), JsonPlaceHolderPojo.class);
        System.out.println("actualdata = " + actualdata);

        assertEquals(201,response.getStatusCode());
        assertEquals(expectedData.getUserId(),actualdata.getUserId());
        assertEquals(expectedData.getTitle(),actualdata.getTitle());
        assertEquals(expectedData.getCompleted(),actualdata.getCompleted());
    }
}
