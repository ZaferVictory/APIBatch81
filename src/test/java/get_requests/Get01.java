package get_requests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class Get01 {
    /*
    1) Postman, manuel API testleri icin kullandik,
    2) Otomasyon testleri icin de Rest Assured Library kullancagiz.
    3) Otomasyon testlerimizi yaparken asagidaki adimlari izliyoruz;
        a) Gereksimleri anlamak,
        b) Test Case yaziyoruz
            i) Test Case yaziminda "Gherkin" dilini kullanacagiz. Bizler yazilim diline hakim olsak da, karsimizdaki
            kisiler hakim olmayabilir ama Gherkin ile yazilan testleri anlamak ta zorluk ├žekmeyeceklerdir.
            Gherkin dilinde kullanacagimiz keywordler;

            - Given : On kosullar,
            - When  : Yapilacak aksiyonlar icin (get(), put(), post(), patch() ve delete() )
            - Then  : Istek yaptiktan (request gonderdikten sonra) dogrulama
            - And   : Coklu islemlerde kullanacagiz

        c) Test Kodlarimizi Yazmaya Baslayacagiz

            I)  Set the URL,
            II) Set the expected Data (beklenen datanin olusturulmasi, Post, Put, Patch)
            III) Type code to send request ( Talep gondermek icin kod yazimi)
            IV) Do Assertion (dogrulama yapmak)
     */


    /*
    Given
            https://restful-booker.herokuapp.com/booking/101
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
    public void get01() {

        //  I)  Set the URL,
        String url = "https://restful-booker.herokuapp.com/booking/101";

        // II) Set the expected Data (beklenen datanin olusturulmasi, Post, Put, Patch)
        // Bizden post, put ya da patch istenmedigi icin bu case de kullanmayacagiz.
        // III) Type code to send request ( Talep gondermek icin kod yazimi)
        Response response=given().when().get(url);
        response.prettyPrint();

        // IV) Do Assertion (dogrulama yapmak)

        response.then().assertThat().statusCode(200).and().contentType("application/json").and().statusLine("HTTP/1.1 200 OK");

        // Status Code konsola yazdiralim
        System.out.println("Status Code : "+response.getStatusCode());

        // Content Type konsola yazdiralim
        System.out.println("Content Type : "+ response.getContentType());

        // Status Line konsola yaziralim
        System.out.println("Status Line : "+response.getStatusLine());

        // Header konsola yazdiralim
        System.out.println("Header : "+response.getHeader("Server"));

        // Headers konsola yazdiralim
        System.out.println("Headers : "+response.getHeaders());

        // Time konsola yazdiralim
        System.out.println("Time : "+response.getTime());

    }


}
