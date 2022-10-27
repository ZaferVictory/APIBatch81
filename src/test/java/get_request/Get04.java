package get_request;

import base_url.JsonplaceholderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Get04 extends JsonplaceholderBaseUrl {
/*
    Given
        https://jsonplaceholder.typicode.com/todos
    When
   I send a GET request to the Url
 And
     Accept type is "application/json"
 Then
     HTTP Status Code should be 200
 And
     Response format should be "application/json"
 And
     There should be 200 todos
 And
     "quis eius est sint explicabo" should be one of the todos title
 And
     2, 7, and 9 should be among the userIds
 */

    @Test
    public void get01() {
        //1.adım set the url
        spec.pathParam("first","todos");


        //2.adım set the expected data>> bununla alakalı bır veri yo put patch poss


        // send the request and get the response>> talebini gonder cevabını al seklınde ılerlıyor
        Response response=given().spec(spec).when().and().accept(ContentType.JSON).get("/{first}");
        response.prettyPrint();

        /* assertion kısmı then den sonra başlıyor, then e kadar her şey request(talep,istek)*/
        //4.Do assertion  then kısmına geldim

        response.then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("id",hasSize(200),"title",hasItem("quis eius est sint explicabo"),// herhangi ıtem da bu var mı
                      "userId",hasItems(2,7,9) );


    }
}
