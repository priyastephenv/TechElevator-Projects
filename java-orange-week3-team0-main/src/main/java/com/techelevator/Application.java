package com.techelevator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    private List<Department> departments = new ArrayList<>();
    private List<Employee> employees = new ArrayList<>();
    private Map<String, Project> projects = new HashMap<>();


    /**
     * The main entry point in the application
     * @param args
     */
    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }

    private void run() {
        // create some departments
        createDepartments();

        // print each department by name
        printDepartments();

        // create employees
        createEmployees();

        // give Angie a 10% raise, she is doing a great job!
        employees.get(1).raiseSalary(10);
        // print all employees
        printEmployees();

        // create the TEams project
        createTeamsProject();
        // create the Marketing Landing Page Project
        createLandingPageProject();

        // print each project name and the total number of employees on the project
        printProjectsReport();
    }

    /**
     * Create departments and add them to the collection of departments
     */
    private void createDepartments() {

        this.departments.add(new Department(1, "Marketing"));
        this.departments.add(new Department(2, "Sales"));
        this.departments.add(new Department(3, "Engineering"));

    }

    /**
     * Print out each department in the collection.
     */
    private void printDepartments() {
        System.out.println("------------- DEPARTMENTS ------------------------------");
        for(Department eachDepartment : departments){
            System.out.println(eachDepartment.getName());
        }

    }

    /**
     * Create employees and add them to the collection of employees
     */
    private void createEmployees() {
        int randomnumber = 25;
        Employee dean = new Employee();
        dean.setEmployeeId(1);
        dean.setFirstName("Dean");
        dean.setLastName("Johnson");
        dean.setEmail("djohnson@team.com");
        dean.setSalary(60000);
        dean.setDepartment(this.departments.get(2));
        dean.setHireDate("08/21/2020");

        Employee angie = new Employee(2, "Angie", "Smith" , "asmith@teams.com",
                departments.get(2), "08/21/2020");
        Employee margaret = new Employee(3, "Margaret", "Thompson",
                "mthompson@teams.com", this.departments.get(0), "08/21/2020");
        employees.add(dean);
        employees.add(angie);
        employees.add(margaret);

    }

    /**
     * Print out each employee in the collection.
     */
    private void printEmployees() {
        System.out.println("\n------------- EMPLOYEES ------------------------------");
        for(Employee eachEmployee : employees){
            System.out.println(eachEmployee.getFullName() + " (" + eachEmployee.getSalary() + ") " + eachEmployee.getDepartment().getName());
        }
    }

    /**
     * Create the 'TEams' project.
     */
    private void createTeamsProject() {
        Project teams = new Project("TEams", "Project Management Software", "10/10/2020" , "11/10/2020");
        for(Employee eachEmployee : employees){
            if(eachEmployee.getDepartment().getName().equals("Engineering")){
                teams.getTeamMembers().add(eachEmployee);
            }
        }
        projects.put(teams.getName(), teams);
    }

    /**
     * Create the 'Marketing Landing Page' project.
     */
    private void createLandingPageProject() {
        Project landingPage = new Project("Marketing Landing Page", "Lead Capture Landing Page for Marketing",
                "10/10/2020", "10/17/2020");
        for(Employee eachEmployee: employees){
            if(eachEmployee.getDepartment().getName().equals("Marketing")){
                landingPage.getTeamMembers().add(eachEmployee);
            }
        }
        projects.put(landingPage.getName(), landingPage);
    }

    /**
     * Print out each project in the collection.
     */
    private void printProjectsReport() {
        System.out.println("\n------------- PROJECTS ------------------------------");
        for(String eachKey : projects.keySet()){
            Project eachProject = projects.get(eachKey);
            System.out.println(eachProject.getName() + ": " + eachProject.getTeamMembers().size());
        }
    }

}
