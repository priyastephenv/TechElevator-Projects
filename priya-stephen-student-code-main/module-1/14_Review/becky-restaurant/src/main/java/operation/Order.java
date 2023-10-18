package operation;

import menu.Item;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Order {
    private List<Item> purchaseItems;
    private BigDecimal totalCost;
    private BigDecimal tip;
    private long id;
    private LocalDate date;

    public List<Item> getPurchaseItems() {
        return purchaseItems;
    }

    public void setPurchaseItems(List<Item> purchaseItems) {
        this.purchaseItems = purchaseItems;
    }

    public BigDecimal getTotalCost() {

        // TODO: Loop over each purchase item and add a total sum of costs

        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public BigDecimal getTip() {
        return tip;
    }

    public void setTip(BigDecimal tip) {
        this.tip = tip;
    }
}
