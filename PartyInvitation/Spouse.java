package PartyInvitation;

public class Spouse {

    Employee employee = new Employee();
    private int idOfSpouse;
    private String nameOfSpouse;

    public int getIdOfSpouse() {
        return idOfSpouse;
    }

    public void setIdOfSpouse(int employeeID) {
        this.idOfSpouse = employeeID + 10;
    }

    public String getNameOfSpouse() {
        return nameOfSpouse;
    }

    public void setNameOfSpouse(String nameOfSpouse) {
        this.nameOfSpouse = nameOfSpouse;
    }
}
