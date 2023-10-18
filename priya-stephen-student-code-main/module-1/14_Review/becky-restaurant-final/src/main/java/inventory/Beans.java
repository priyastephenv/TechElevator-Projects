package inventory;

import java.time.LocalDate;

public class Beans extends Produce {
    private String type;

    public Beans(int quantityLbs, LocalDate datePurchased, LocalDate expirationDate, String location, String type){
        super(quantityLbs, datePurchased, expirationDate, location);
        this.type = type;
    }

    public boolean isBlackBeans(){
        return this.type.equals("Black");
    }
}
