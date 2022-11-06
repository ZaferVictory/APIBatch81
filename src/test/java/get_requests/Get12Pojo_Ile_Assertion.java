package get_requests;

import base_urls.RestfulBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get12Pojo_Ile_Assertion extends RestfulBaseUrl {
     /*
     Given
         https://restful-booker.herokuapp.com/booking/19
     When
    I send GET Request to the URL
   Then
    Status code is 200
And
    Response body is like:
   {
    "firstname": "Guoqiang",
    "lastname": "Liu",
    "totalprice": 111,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2018-01-01",
        "checkout": "2019-01-01"
    },
    "additionalneeds": "Breakfast"
}
  */

    @Test
    public void get12pojo() {
        // set the url
        spec.pathParams("first","booking","second",19);


        //set the expected data
        BookingDatesPojo bookingDatesPojo=new BookingDatesPojo("2018-01-01","2019-01-01");
        System.out.println(bookingDatesPojo.toString());
        BookingPojo expectedData=new BookingPojo("Guoqiang","Liu",111,true,bookingDatesPojo,"Breakfast");// variables ismine expecteddata ismi de verebilirim.
        System.out.println(expectedData.toString());

        //send the request and get the response
        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //Do assertion
        BookingPojo actualData=response.as(BookingPojo.class);// her java classı bir data tipidir
        System.out.println("actualdata"+actualData);

        assertEquals(expectedData.getFirstname(),actualData.getFirstname());
        assertEquals(expectedData.getLastname(),actualData.getLastname());
        assertEquals(expectedData.getTotalprice(),actualData.getTotalprice());
        assertEquals(expectedData.getDepositpaid(),actualData.getDepositpaid());
        assertEquals(expectedData.getAdditionalneeds(),actualData.getAdditionalneeds());

        //1.yol inner için yapılan ıkı yontem
        assertEquals(expectedData.getBookingdates().getCheckin(),actualData.getBookingdates().getCheckin());
        assertEquals(expectedData.getBookingdates().getCheckout(),actualData.getBookingdates().getCheckout());

        //2.yol==> tavsiye edilen

        assertEquals(bookingDatesPojo.getCheckin(),actualData.getBookingdates().getCheckin());
        assertEquals(bookingDatesPojo.getCheckout(),actualData.getBookingdates().getCheckout());

    }
}
