package inventory;

import java.time.LocalDate;

public class Rice extends Produce {
    private String type;

    public Rice(int quantityLbs, LocalDate datePurchased, LocalDate expirationDate, String location, String type){
        super(quantityLbs, datePurchased, expirationDate, location);
        this.type = type;
    }

    public boolean isBrownRice(){
        return this.type.equalsIgnoreCase("Brown");
    }
}
