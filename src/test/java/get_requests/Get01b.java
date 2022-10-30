package get_requests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get01b {
    /*
       Given
           https://reqres.in/api/users/3
       When
           User sends a GET Request to the url
       Then
           HTTP Status Code should be 200
       And
           Content Type should be JSON
       And
           Status Line should be HTTP/1.1 200 OK
    */
    @Test
    public  void get01(){
        //  I)  Set the URL,
        //Set the URL
        String url = "https://reqres.in/api/users/3";

        // II) Set the expected Data (beklenen datanin olusturulmasi, Post, Put, Patch)-- bununla ilgili bir sey ıstemıyor
        //Set The Expected Data

        // III) Type code to send request ( Talep gondermek icin kod yazimi)
        //Send The Request and Get The Response
        Response response = given().when().get(url);// url' gitti yanıtı aldı ve cevabı response'nin içine atti
        response.prettyPrint();


        //Do Assertion

//        HTTP Status Code should be 200
//        Content Type should be JSON
//        Status Line should be HTTP/1.1 200 OK

        response.// bunu assertionlarla da yapabılırım assertequals(200,response.statusCode()) hepsini bu sekılde de yapabılırım
                // assert true ıle de olur
                then().
                statusCode(200).
                contentType(ContentType.JSON).
                statusLine("HTTP/1.1 200 OK");
    }
}
