package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class BookingDatesPojo {
    //1 tum keyler ıcın private variablesler olusturalım
    private String checkin;
    private String checkout;

    //2) tum parametrelerle ve parametresiz constructerlar olusturyoruz

    public BookingDatesPojo(String checkin, String checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public BookingDatesPojo() {

    }

    //3) public getter ve setter metodlarını olusturuyoruz.

    public String getCheckin() {

        return checkin;
    }

    public void setCheckin(String checkin) {

        this.checkin = checkin;
    }

    public String getCheckout() {

        return checkout;
    }

    public void setCheckout(String checkout) {

        this.checkout = checkout;
    }


    //4) to string metodunu olusturuyoruz

    @Override
    public String toString() {
        return "BookingDatesPojo{" +
                "checkin='" + checkin + '\'' +
                ", checkout='" + checkout + '\'' +
                '}';

    }
}
