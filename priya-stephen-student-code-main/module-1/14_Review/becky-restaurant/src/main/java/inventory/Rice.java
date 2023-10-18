package inventory;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Rice {
    public int quantityLbs;
    public LocalDate datePurchased;
    public LocalDate expirationDate;
    public String location;
    public String type;
    public BigDecimal initialCost;

    public Rice(int quantity, LocalDate datePurchased, LocalDate expirationDate, String location, String type){
        this.quantityLbs = quantityLbs;
        this.datePurchased = datePurchased;
        this.expirationDate = expirationDate;
        this.location = location;
        this.type = type;
    }

    public boolean isExpired(){
        return datePurchased.isBefore(expirationDate);
    }

    public void abcdefg(int quantity) {
        this.quantityLbs -= quantity;
    }

    public boolean isBrownRice(){
        return this.type.equalsIgnoreCase("Brown");
    }

    public BigDecimal getInitialCost(){
        return initialCost;
    }
}
