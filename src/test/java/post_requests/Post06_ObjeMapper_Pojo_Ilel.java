package post_requests;

import base_urls.DummyRestapiExampleUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.DummyRestApiDataPojo;
import pojos.DummyRestapiResponseBodyPojo;
import utils.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post06_ObjeMapper_Pojo_Ilel extends DummyRestapiExampleUrl {

    /*
       URL: https://dummy.restapiexample.com/api/v1/create
       HTTP Request Method: POST Request
       Request body:
                     {
                        "employee_name": "Tom Hanks",
                        "employee_salary": 111111,
                        "employee_age": 23,
                        "profile_image": "Perfect image",
                        "id": 4891
                     }
       Test Case: Type by using Gherkin Language
       Assert:
                i) Status code is 200
                ii) Response body should be like the following
                    {
                        "status": "success",
                        "data": {
                            "employee_name": "Tom Hanks",
                            "employee_salary": 111111,
                            "employee_age": 23,
                            "profile_image": "Perfect image",
                            "id": 4891
                        },
                        "message": "Successfully! Record has been added."
                    }
     */

    @Test
    public void post06() {

            //Set the Url
            spec.pathParam("first","create");

            //Set the Expected Data
            DummyRestApiDataPojo expectedData = new DummyRestApiDataPojo("Tom Hanks",111111,23,"Perfect image");

            System.out.println("expectedData = " + expectedData);

            //Send the POST Request and Get the Response
            Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("/{first}");
            response.prettyPrint();

            //do assertion
       DummyRestapiResponseBodyPojo actualData= ObjectMapperUtils.convertJsonToJava(response.asString(),DummyRestapiResponseBodyPojo.class);

       assertEquals(expectedData.getEmployee_name(),actualData.getData().getEmployee_name());
       assertEquals(expectedData.getEmployee_salary(),actualData.getData().getEmployee_salary());
       assertEquals(expectedData.getEmployee_age(),actualData.getData().getEmployee_age());
       assertEquals(expectedData.getProfile_image(),actualData.getData().getProfile_image());

/*
        "status": "success",
                "data":
        message": "Successfully! Record has been added."


        bunlar karsıdan gelen cevaplar bunları da dogrulamamı ısterlerse  DummyRestapiResponseBodyPojo cllasından
        obje olustururum onda expected data adını veririm ancak benden sadece
        
         "employee_name": "Tom Hanks",
        "employee_salary": 111111,
        "employee_age": 23,
        "profile_image": "Perfect image", bu bolumu dogrulamamı ıstıyor.
 */



        }
}
