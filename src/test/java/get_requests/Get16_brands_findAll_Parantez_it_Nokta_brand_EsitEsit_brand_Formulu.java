package get_requests;

import base_urls.AutomationExerciseBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get16_brands_findAll_Parantez_it_Nokta_brand_EsitEsit_brand_Formulu extends AutomationExerciseBaseUrl {
     /*
        Given
            https://automationexercise.com/api/brandsList
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be "text/html; charset=utf-8"
        And
            Status Line should be HTTP/1.1 200 OK
        And
        Number of H&M brands must be equal to Polo(H&M marka sayısı Polo marka sayısına eşit olmalı)
             */

    @Test
    public void get16() {
        //1. Set The URL
        spec.pathParam("first","brandsList");

// 2. Set The Expected Data ( put, post, patch)

// 3. Send The Request And Get The Response
        Response response=given().spec(spec).get("/{first}");
       // response.prettyPrint(); cevap html formatında dondugu için yazdırmadı yazdırabilmek için Json formatoında olması lazım
                                 //43-44 satırda json formatına dondurduk ondan sonra yazdırdı
    // 4. Do Assertion
        response.then().assertThat().statusCode(200).contentType("text/html; charset=utf-8").
                statusLine("HTTP/1.1 200 OK");

        JsonPath jsonPath = response.jsonPath();
        jsonPath.prettyPrint();
        
        List<String>actualDataHM= jsonPath.getList("brands.findAll{it.brand=='H&M'}.brand");
        System.out.println("actualDataHM = " + actualDataHM);
        List<String>actualDataPolo= jsonPath.getList("brands.findAll{it.brand=='Polo'}.brand");
        System.out.println("actualDataPolo = " + actualDataPolo);

        assertEquals(actualDataHM.size(),actualDataPolo);//Fail eşit olmadıgı için fail verdi



    }
}
