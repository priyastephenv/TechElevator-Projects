import inventory.Avocado;
import inventory.FoodInventory;
import staff.Employee;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Restaurant {
    private List<Employee> employees;
    private FoodInventory foodInventory;

    public void start() {
        System.out.println("starting the restaurant app!");

        initializeInventory();

        /*
         * Menu to show total orders. Filter options, by date?
         */
        showOrders();

        /*
         * Menu to display the total revenue
         */
        System.out.println("Total revenue is: " + calculateTotalRevenue());
    }

    private void initializeInventory(){
        this.foodInventory = new FoodInventory();
        this.foodInventory.addProduce(new Avocado(30, LocalDate.of(2023, 7, 20), LocalDate.of(2023, 7, 25), "San Diego"));
    }

    private void showOrders() {
        System.out.println("No Orders yet!");
    }

    private BigDecimal calculateTotalRevenue(){
        // TODO: Gotta figure this out :P

        return null;
    }
}
