package get_requests;

import base_urls.DummyRestapiExampleUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;

public class Get17_ONEMLI_TestCaseYazimi_ObjectMapper_VePojo_Matcher_HasItem__List_İleKullanimi extends DummyRestapiExampleUrl {
/*
           URL: https://dummy.restapiexample.com/api/v1/employees
           HTTP Request Method: GET Request
           Test Case: Type by using Gherkin Language
           Assert:  i) Status code is 200
                   ii) There are 24 employees
                  iii) "Tiger Nixon" and "Garrett Winters" are among the employees
                   iv) The greatest age is 66
                    v) The name of the lowest age is "Tatyana Fitzpatrick"
                   vi) Total salary of all employees is 6,644,770
    */

    //test case yazımı
        /*
    Given
        https://dummy.restapiexample.com/api/v1/employees

    When
        User sends Get request

    Then
         i) Status code is 200
    And
       ii) There are 24 employees
    And
      iii) "Tiger Nixon" and "Garrett Winters" are among the employees
    And
       iv) The greatest age is 66
    And
        v) The name of the lowest age is "Tatyana Fitzpatrick"
    And
       vi) Total salary of all employees is 6,644,770
     */



    @Test
    public void test17() {

        //set the url
        //spec.pathParams("1","employees");

        //set the expectedData

        //send the request and get the response

        Response response=given().when().get("https://dummy.restapiexample.com/api/v1/employees");
        response.prettyPrint();

        //ii) There are 24 employees
        response.then().assertThat().body("data.employees",hasSize(24),

       // iii) "Tiger Nixon" and "Garrett Winters" are among the employees
        "data.employee_name",hasItems("Tiger Nixon", "Garrett Winters"));

        // iv) The greatest age is 66
       List<Integer> yasList =response.jsonPath().getList("data.employee_age");
        System.out.println("yasList = " + yasList);
        Collections.sort(yasList);//sort metodu ufaktan buyuge dogru sıraladı
        System.out.println("sorted = " + yasList);
        System.out.println(yasList.get(yasList.size()-1));
        assertEquals(66,(int)yasList.get(yasList.size()-1));//int Integer karsılastırdık hata verdi bizde parantez içinde onu da int yaptık

        //v) The name of the lowest age is "Tatyana Fitzpatrick"En küçük yaşın adı "Tatyana Fitzpatrick"
        String lowestageemployee=response.jsonPath().getString("data.findAll{it.employee_age=="+yasList.get(0)+"}.employee_name");//dinamik olarak yazdık.dınamık olarak yazdıgında ıkı artım arasında boyle yazıyorsun
        System.out.println("lowestageemployee = " + lowestageemployee);// burası bana en kucuk yası veriyor            //burası da bunun içinden bana ismini verir
        assertEquals("[Tatyana Fitzpatrick]",lowestageemployee);

        //vi) Total salary of all employees is 6,644,770Tüm çalışanların toplam maaşı 6.644.770
        List<Integer>salaries=response.jsonPath().getList("data.employee_salary");
        System.out.println("salaries = " + salaries);

        //1 yol
        int sum=0;
        for (int w:salaries) {
            sum+=w;
        }
        System.out.println("sum = " + sum);
        assertEquals(6644770,sum);

        // yol
        salaries.stream().reduce(0,Integer::sum);
        System.out.println("sum = " + sum);

        //3.yol
        int sum3=salaries.stream().reduce(0,Math::addExact);
        System.out.println("sum3 = " + sum3);
        assertEquals(6644770,sum3);
    }
}
