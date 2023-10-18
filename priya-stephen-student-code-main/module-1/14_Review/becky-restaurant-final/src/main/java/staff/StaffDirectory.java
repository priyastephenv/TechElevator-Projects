package staff;

import java.util.ArrayList;
import java.util.List;

/*
 * Class to track employees
 * Need a way to add, remove, and update employees
 */
public class StaffDirectory {
    List<Employee> employees;

    public StaffDirectory(){
        employees = new ArrayList<>();
    }

    public List<Employee> getEmployees(){
        return this.employees;
    }
}
