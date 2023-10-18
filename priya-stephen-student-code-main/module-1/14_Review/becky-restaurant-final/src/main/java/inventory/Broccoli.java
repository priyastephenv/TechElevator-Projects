package inventory;

import java.time.LocalDate;

public class Broccoli extends Produce{

    public Broccoli(int quantityLbs, LocalDate datePurchased, LocalDate expirationDate, String location){
        super(quantityLbs, datePurchased, expirationDate, location);
    }
}
