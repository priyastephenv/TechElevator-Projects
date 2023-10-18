package inventory;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Produce {
    public int quantityLbs;
    public LocalDate datePurchased;
    public LocalDate expirationDate;
    public String location;
    public String type;
    public BigDecimal initialCost;

    /*
     * TODO: Add overlapping methods later
     */
    public Produce(int quantityLbs, LocalDate datePurchased, LocalDate expirationDate, String location){
        this.quantityLbs = quantityLbs;
        this.datePurchased = datePurchased;
        this.expirationDate = expirationDate;
        this.location = location;
    }

    public boolean isExpired(){
        return datePurchased.isBefore(expirationDate);
    }

    public void decrementQuantity(int quantity) {
        this.quantityLbs -= quantity;
    }

    public BigDecimal getInitialCost(){
        return initialCost;
    }
}
