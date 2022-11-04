package test_data;

import java.util.HashMap;
import java.util.Map;

public class RestfullTestData {

    public Map<String, String> bookingdatesMetod(String checkin, String checkout) {
        Map<String, String> bookingdatesMetod = new HashMap<>();
        bookingdatesMetod.put("checkin", checkin);
        bookingdatesMetod.put("checkout", checkout);


        return bookingdatesMetod;
    }

    public Map<String, Object> expecteddataMetod(String firstname, String lastname, Integer totalprice, Boolean depositpaid, Map<String, String> bookingdates) {
        Map<String, Object> expecteddataMetod = new HashMap<>();
        expecteddataMetod.put("firstname", firstname);
        expecteddataMetod.put("lastname", lastname);
        expecteddataMetod.put("totalprice", totalprice);
        expecteddataMetod.put("depositpaid", depositpaid);
        expecteddataMetod.put("bookingdates", bookingdates);

        return expecteddataMetod;
    }
}
