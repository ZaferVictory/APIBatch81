package post_requests;

import base_urls.ReqresBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.ReqresBodyPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post07PojoClass_Ile extends ReqresBaseUrl {
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
        ReqresBodyPojo expectedData=new ReqresBodyPojo("morpheus","leader");

        //send the url and set the response
       Response response=  given().spec(spec).contentType(ContentType.JSON).body(expectedData).post("/{1}");

       //do assertion

        ReqresBodyPojo actualData=response.as(ReqresBodyPojo.class);

        assertEquals(expectedData.getName(),actualData.getName());
        assertEquals(expectedData.getJob(),actualData.getJob());


    }
}
