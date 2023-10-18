package inventory;

import java.time.LocalDate;

public class Avocado extends Produce {

    public Avocado(int quantityLbs, LocalDate datePurchased, LocalDate expirationDate, String location){
        super(quantityLbs, datePurchased, expirationDate, location);
    }

}
