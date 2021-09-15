package PartyInvitation;

import java.util.Scanner;

public class sharifUniversity {

    private int employeeCounter;
    private int spouseCounter;
    private Employee[] employees;
    private Spouse[] spouses;
    private int numberOfEmployee = 10;

    Scanner scanner = new Scanner(System.in);

    public sharifUniversity() {
        this.employees = new Employee[numberOfEmployee];
        spouses = new Spouse[numberOfEmployee];
    }

    public void insertEmployee(Employee employee) {

        // In the case that the employee array is full the capacity will be increased by one.
        if (employeeCounter > employees.length) {
            Employee[] newemployees = new Employee[numberOfEmployee++];
            for (int i = 0; i < employees.length; i++) {
                newemployees[i] = employees[i];
            }
            this.employees = newemployees;
        }

        for (Employee value : employees) {
            if (value != null && value.getId() == employee.getId()) {
                System.out.println("Sorry, the this ID is exist.");
                return;
            }
        }
        employees[employeeCounter++] = employee;
        System.out.println("The Employee with ID " + employee.getId() + " added successfully. ");

    }

    public Employee[] employeeList() {
        return employees;
    }

    public int getEmployeeCounter() {
        return employeeCounter;
    }

// check whether the employee is invited or not.
    private boolean employeeIsInvited(Employee employee) {
        return (employee.isMarried() && employee.getEmployeeLocation() < 30);
    }


// adding spouse to the employee
    public void addSpouse(int employeeID) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getId() == employeeID && employees[i].isMarried()) {
                Spouse spouse = new Spouse();
                System.out.println("Enter name of spouse");
                String name = scanner.next();
                spouse.setNameOfSpouse(name);
                spouse.setIdOfSpouse(employeeID);
                spouses[employeeID] = spouse;
                System.out.println("The spouse with ID " + spouse.getIdOfSpouse() + " added successfully. ");
                return;
            }
        }
    }


// Find employee's spouse by passing employeeID
    public void spouseFinder(int employeeID) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getId() == employeeID && employees[i].isMarried()) {
                String spouseName = spouses[i].getNameOfSpouse();
                int spouseID = spouses[i].getIdOfSpouse();
                System.out.println("The employee with name " + employees[i].getName() + " married to " + spouseName);
                return;
            }
        }
    }


    public boolean searchByID(int ID) {
        for (Employee employee : employees) {
            if (employee.getId() == ID)
                return true;
        }
        return false;
    }

    public boolean isInvited(int employeeID) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getId() == employeeID) {
                if (employeeIsInvited(employees[i]))
                    return true;
            }
        }
        return false;
    }

    public void printInvitedEmployees() {
        for (Employee currentEmployee : employees) {
            if (currentEmployee != null && employeeIsInvited(currentEmployee))
                System.out.println(currentEmployee);
        }
    }

}