package inventory;

import java.time.LocalDate;

public class Chicken extends Produce{

    public Chicken(int quantityLbs, LocalDate datePurchased, LocalDate expirationDate, String location){
        super(quantityLbs, datePurchased, expirationDate, location);
    }
}
