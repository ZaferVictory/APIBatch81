package get_requests;

import base_urls.DummyRestapiExampleUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.DummyRestApiDataPojo;
import pojos.DummyRestapiResponseBodyPojo;
import utils.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get18_ObjectMapper_PojoClass_İle extends DummyRestapiExampleUrl {

    /*
    Given
        URL: https://dummy.restapiexample.com/api/v1/employee/1
    When
        User sends GET Request
    Then
        Status code is 200
    And
        "employee_name" is "Tiger Nixon"
    And
        "employee_salary" is 320800
    And
        "employee_age" is 61
    And
        "status" is "success"
    And
        "message" is "Successfully! Record has been fetched."

     */

    @Test
    public void name() {
        //set the url
        spec.pathParams("1","employee","2",1);

       // set the expected data
        DummyRestApiDataPojo dummyRestApiDataPojo=new DummyRestApiDataPojo("Tiger Nixon",320800,61,"");
        DummyRestapiResponseBodyPojo expectedData=new DummyRestapiResponseBodyPojo("success",dummyRestApiDataPojo,"Successfully! Record has been fetched.");

        System.out.println("expectedData = " + expectedData);

        Response response=given().spec(spec).when().get("/{1}/{2}");
        response.prettyPrint();

       DummyRestapiResponseBodyPojo actualData= ObjectMapperUtils.convertJsonToJava(response.asString(),DummyRestapiResponseBodyPojo.class);

        System.out.println("actualData = " + actualData);

        assertEquals(200,response.statusCode());
        assertEquals(expectedData.getStatus(),actualData.getStatus());
        assertEquals(expectedData.getMessage(),actualData.getMessage());

        assertEquals(expectedData.getData().getEmployee_name(),actualData.getData().getEmployee_name());
        assertEquals(expectedData.getData().getEmployee_salary(),actualData.getData().getEmployee_salary());
        assertEquals(expectedData.getData().getEmployee_age(),actualData.getData().getEmployee_age());
        assertEquals(expectedData.getData().getProfile_image(),actualData.getData().getProfile_image());




    }
}
