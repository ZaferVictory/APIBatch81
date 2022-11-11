package put_requests;

import base_urls.DummyRestapiExampleUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.DummyRestApiDataPojo;
import pojos.DummyRestapiResponseBodyPojo;
import utils.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class put02_TestCaseYazmi_Pojo_ObjectMapper_İle extends DummyRestapiExampleUrl {

    /*
        URL: https://dummy.restapiexample.com/api/v1/update/21
       HTTP Request Method: PUT Request
       Request body: {
                        "employee_name": "Ali Can",
                        "employee_salary": 111111,
                        "employee_age": 23,
                        "profile_image": "Perfect image"
                     }
       Test Case: Type by using Gherkin Language
       Assert:
                i) Status code is 200
                ii) Response body should be like the following
                    {
                        "status": "success",
                        "data": {
                            "employee_name": "Ali Can",
                            "employee_salary": 111111,
                            "employee_age": 23,
                            "profile_image": "Perfect image"
                        },
                        "message": "Successfully! Record has been updated."
                    }
     */

    //test case yazımı

    /*
    given
    URL: https://dummy.restapiexample.com/api/v1/update/21
    {
                        "employee_name": "Ali Can",
                        "employee_salary": 111111,
                        "employee_age": 23,
                        "profile_image": "Perfect image"
                     }
    
    when
    usersend pur request
    
    then
    "status": "success",
    
    and 
Response body should be like the following
                    {
                        "status": "success",
                        "data": {
                            "employee_name": "Ali Can",
                            "employee_salary": 111111,
                            "employee_age": 23,
                            "profile_image": "Perfect image"
                        },
                        "message": "Successfully! Record has been updated."
                    }
     */

    @Test
    public void put02() {
        //set the url
        spec.pathParams("1","update","2","21");
        
        //set the expected data
        DummyRestApiDataPojo dummyRestApiDataPojo=new DummyRestApiDataPojo("Ali Can",111111,23,"Perfect image");
        DummyRestapiResponseBodyPojo expecteddata=new DummyRestapiResponseBodyPojo("success",dummyRestApiDataPojo,"Successfully! Record has been updated.");
        System.out.println("expecteddata = " + expecteddata);

       // send the url and get the response
        Response response=given().spec(spec).contentType(ContentType.JSON).body(dummyRestApiDataPojo).put("/{1}/{2}");
        response.prettyPrint();

        DummyRestapiResponseBodyPojo actualData=ObjectMapperUtils.convertJsonToJava(response.asString(),DummyRestapiResponseBodyPojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200,response.statusCode());
        assertEquals(expecteddata.getStatus(),actualData.getStatus());
        assertEquals(expecteddata.getMessage(),actualData.getMessage());

        assertEquals(expecteddata.getData().getEmployee_name(),actualData.getData().getEmployee_name());
        assertEquals(expecteddata.getData().getEmployee_salary(),actualData.getData().getEmployee_salary());
        assertEquals(expecteddata.getData().getEmployee_age(),actualData.getData().getEmployee_age());
        assertEquals(expecteddata.getData().getProfile_image(),actualData.getData().getProfile_image());

        
    }
}
