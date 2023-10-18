package inventory;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Avocados {
    private int quantityLbs;
    private LocalDate datePurchased;
    private LocalDate expirationDate;
    private String location;
    private BigDecimal initialCost;

    public Avocados(int quantityLbs, LocalDate datePurchased, LocalDate expirationDate, String location){
        this.quantityLbs = quantityLbs;
        this.datePurchased = datePurchased;
        this.expirationDate = expirationDate;
        this.location = location;
    }

    public boolean isExpired(){
        return datePurchased.isBefore(expirationDate);
    }

    public int amountAvocados(int quantityLbs) {
        this.quantityLbs -= quantityLbs;

        return this.quantityLbs;
    }

    public BigDecimal getInitialCost(){
        return initialCost;
    }
}
