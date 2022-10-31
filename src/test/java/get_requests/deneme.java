package get_requests;

import base_urls.ReqresBaseUrl;
import base_urls.RestfulBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.equalTo;

public class deneme extends ReqresBaseUrl {
     /*
   Given
          https://reqres.in/api/unknown/
   When
        I send GET Request to the URL
   Then

        1)Status code is 200 Durum kodu 200
        2)Print all pantone_values >>Tüm pantone_değerlerini yazdır
        3)Print all ids greater than 3 on the console>>Konsolda 3'ten büyük tüm kimlikleri yazdır
          Assert that there are 3 ids greater than 3>>3'ten büyük 3 kimlik olduğunu iddia edin>>
        4)Print all names whose ids are less than 3 on the console>>Kimlikleri 3'ten küçük olan tüm adları konsolda yazdırın
          Assert that the number of names whose ids are less than 3 is 2>>Kimlikleri 3'ten küçük olan isimlerin sayısının 2 olduğunu iddia edin.
*/

    //Set the Url
//Set The Expected Data
//Send The Request and Get The Response
//Do Assertion

    @Test
    public void deneme01() {

        //Set the Url
        spec.pathParams("first","unknown");

//Set The Expected Data

//Send The Request and Get The Response
        Response response=given().spec(spec).when().get("/{first}");
        response.prettyPrint();
//Do Assertion
       // 1)Status code is 200 Durum kodu 200
        assertEquals(200,response.statusCode());
       // 2)Print all pantone_values >>Tüm pantone_değerlerini yazdır
        JsonPath jsonPath=response.jsonPath();
        System.out.println(jsonPath.getList("data.pantone_value"));
       // 3)Print all ids greater than 3 on the console>>Konsolda 3'ten büyük tüm kimlikleri yazdır
       List<Integer> ids=jsonPath.getList("data.findAll{it.id>3}.id");
        System.out.println("ids = " + ids);
       // Assert that there are 3 ids greater than 3>>3'ten büyük 3 kimlik olduğunu iddia edin>>
       // 4)Print all names whose ids are less than 3 on the console>>Kimlikleri 3'ten küçük olan tüm adları konsolda yazdırın
       // Assert that the number of names whose ids are less than 3 is 2>>Kimlikleri 3'ten küçük olan isimlerin sayısının 2 olduğunu iddia edin.






    }
}
