package get_requests;

import base_urls.GoRestBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.GoRestPojo;
import pojos.GorestDataPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get13Pojo extends GoRestBaseUrl {
/*
        Given
            https://gorest.co.in/public/v1/users/2508
        When
            User send GET Request to the URL
        Then
            Status Code should be 200
        And
            Response body should be like
          {
            "meta": null,
            "data": {
                "id": 2508,
                "name": "Sharmila Deshpande VM",
                "email": "deshpande_sharmila_vm@becker.name",
                "gender": "female",
                "status": "active"
                 }
          }
    */

    @Test
    public void get13Pojo() {
        //set the url
        spec.pathParams("first","users","second",2508);

        //set the expected data
        GorestDataPojo gorestDataPojo=new GorestDataPojo(2508,"Sharmila Deshpande VM","deshpande_sharmila_vm@becker.name","female","active");

        GoRestPojo expectedData=new GoRestPojo(null,gorestDataPojo);

        //send the request and get the response

       Response response= given().spec(spec).when().get("/{first}/{second}");
       response.prettyPrint();

        //Do assertion

        GoRestPojo actualData=response.as(GoRestPojo.class);

        assertEquals(200,response.statusCode());
        assertEquals(expectedData.getMeta(),actualData.getMeta());
        assertEquals(gorestDataPojo.getId(),actualData.getData().getId());
        assertEquals(gorestDataPojo.getName(),actualData.getData().getName());
        assertEquals(gorestDataPojo.getEmail(),actualData.getData().getEmail());
        assertEquals(gorestDataPojo.getGender(),actualData.getData().getGender());
        assertEquals(gorestDataPojo.getStatus(),actualData.getData().getStatus());

    }
}
