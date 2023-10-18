package inventory;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Chicken {
    public int quantityLbs;
    public LocalDate datePurchased;
    public LocalDate expirationDate;
    public String location;
    public BigDecimal initialCost;

    public Chicken(int quantity, LocalDate datePurchased, LocalDate expirationDate, String location){
        this.quantityLbs = quantityLbs;
        this.datePurchased = datePurchased;
        this.expirationDate = expirationDate;
        this.location = location;
    }

    public boolean isExpired(){
        return datePurchased.isBefore(expirationDate);
    }

    public void abcdefg(int quantity) {
        this.quantityLbs -= quantity;
    }

    public BigDecimal getInitialCost(){
        return initialCost;
    }
}
