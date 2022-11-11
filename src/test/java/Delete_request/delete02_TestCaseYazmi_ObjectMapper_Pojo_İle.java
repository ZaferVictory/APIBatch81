package Delete_request;

import base_urls.DummyRestapiExampleUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.DummyREstApiDeletePojo;
import utils.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class delete02_TestCaseYazmi_ObjectMapper_Pojo_İle extends DummyRestapiExampleUrl {
    /*
     URL: https://dummy.restapiexample.com/api/v1/delete/2
     HTTP Request Method: DELETE Request
     Test Case: Type by using Gherkin Language
     Assert:     i) Status code is 200
                 ii) "status" is "success"
                 iii) "data" is "2"
                 iv) "message" is "Successfully! Record has been deleted"
       */

 /*
    Given
    URL: https://dummy.restapiexample.com/api/v1/delete/2
    When
    User sends Delete Request and gets response
    Then
    i) Status code is 200
    And
    ii) "status" is "success"
    And
    iii) "data" is "2"
    And
    iv) "message" is "Successfully! Record has been deleted"

  */
    @Test
    public void test02() {

//set the url
        spec.pathParams("1","delete","2","2");
        //set the expecteddata
        DummyREstApiDeletePojo expecteddata=new DummyREstApiDeletePojo("success","2","Successfully! Record has been deleted");
        System.out.println("expecteddata = " + expecteddata);

        //send the url and get the response

        Response response=given().spec(spec).when().delete("/{1}/{2}");
        response.prettyPrint();

        //do assertion
        //DummyREstApiDeletePojo actualData=response.as(DummyREstApiDeletePojo.class);//Gson bu işte

        DummyREstApiDeletePojo actualData = ObjectMapperUtils.convertJsonToJava(response.asString(),DummyREstApiDeletePojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200,response.getStatusCode());
        assertEquals(expecteddata.getStatus(),actualData.getStatus());
        assertEquals(expecteddata.getData(),actualData.getData());
        assertEquals(expecteddata.getMessage(),actualData.getMessage());


        /*
        pojo class ve objectMapper ıle yaptık
        */
    }
}
