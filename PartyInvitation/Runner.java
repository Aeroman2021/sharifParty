package PartyInvitation;

import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {

        System.out.println("===================================================================");
        System.out.println("=============Welcome to the sharifParty application================");
        System.out.println("===================================================================");

        sharifUniversity sharifUniversity = new sharifUniversity();
        Scanner input = new Scanner(System.in);

        while (true) {

            System.out.println("Please select a number : ");
            System.out.println("1) Add employee");
            System.out.println("2) get employee ID to add spouse");
            System.out.println("3) get employee ID to print marital status");
            System.out.println("4) print whether an employee with ID is invited or not");
            System.out.println("5) print the list of invited employees");
            System.out.println("6) Exit the program");

            int type = input.nextInt();

            switch (type) {
                case 1 -> {

                    System.out.println("Enter Employee's name");
                    String name = input.next();
                    System.out.println("Please enter the  longitude of the employee");
                    double longitude = input.nextDouble();   // 35.707
                    System.out.println("Please enter the latitude of the employee");
                    double latitude = input.nextDouble();   // 51.327
                    System.out.println("Is this employee married or not? if yes, type yes.");
                    String maritalStatus = input.next();
                    Employee employee = new Employee();

                    employee.setId();
                    employee.setName(name);
                    employee.setEmployeeLocation(longitude,latitude);
                    employee.setMarried(maritalStatus.equalsIgnoreCase("yes"));

                    sharifUniversity.insertEmployee(employee);
                    System.out.println("Distance from University = " + employee.getEmployeeLocation() + " Km");
                    System.out.println("=======================================================");
                }

                case 2 -> {
                    System.out.println("=======================================================");
                    System.out.println("Enter the ID of Employee");
                    int ID = input.nextInt();
                    sharifUniversity.addSpouse(ID);
                    System.out.println("=======================================================");
                }

                case 3 -> {
                    System.out.println("=======================================================");
                    System.out.println("Enter the IDs of the employee");
                    int ID = input.nextInt();
                    sharifUniversity.spouseFinder(ID);
                    System.out.println("=======================================================");
                }

                case 4 -> {
                    System.out.println("========================================================");
                    System.out.println("Enter the ID of the employee");
                    int ID = input.nextInt();
                    if (sharifUniversity.isInvited(ID))
                        System.out.println(" The owner of this ID is not invited.");
                    else
                        System.out.println("Yes, The owner of this ID is not invited.");
                    System.out.println("=======================================================");
                }

                case 5 -> {
                    System.out.println("=======================================================");
                    sharifUniversity.printInvitedEmployees();
                    System.out.println("=======================================================");
                }

                case 6 -> {
                    System.out.println("Exiting the application");
                    System.exit(0);
                }

                default -> {
                    System.out.println("Incorrect input, Please Enter a correct Number");
                }
            }
        }
    }
}