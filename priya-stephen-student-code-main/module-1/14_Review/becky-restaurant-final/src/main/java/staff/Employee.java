package staff;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Employee {
    private BigDecimal salary;
    private boolean isPartTime;
    private long hoursWorked;
    private List<LocalDate> datesWorked;
    private List<Integer> hoursWorkedOnDate;
    private double totalRevenue;

    public Employee(){
        datesWorked = new ArrayList<>();
        hoursWorkedOnDate = new ArrayList<>();
    }

    public long getHoursWorked(){
        return hoursWorked;
    }

    public void submitTimeCard(LocalDateTime startDateTime, LocalDateTime endDateTime){
        // TODO: Figure this out :P
    }

    public void getTotalRevenue(){
        // TODO: Figure this calculation out :P
    }
}
