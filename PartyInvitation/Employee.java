package PartyInvitation;

public class Employee {

    private int id;
    private String name;
    private boolean isMarried;
    static int counter;

    //Coordinates of the Sharif University
    static final double sharifLongitude = 35.7036;
    static final double sharifLatitude = 51.3115;

    private double latitude;
    private double longitude;
    private double location;


    public int getId() {
        return id;
    }

    public void setId() {
        this.id = counter++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isMarried() {
        return isMarried;
    }

    public void setMarried(boolean married) {
        isMarried = married;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

// Find the distance of each Employee from the University
    public void setEmployeeLocation(double longitude, double latitude) {

        double radianLongitude = Math.toRadians(longitude);
        double radianLatitude = Math.toRadians(latitude);
        double sharifRadianLongitude = Math.toRadians(35.7036);
        double sharifRadianLatitude = Math.toRadians(51.3115);
        double deltaLong = radianLatitude - sharifRadianLatitude;
        double deltaLat = radianLongitude - sharifRadianLongitude;

        double a = Math.pow(Math.sin(deltaLat / 2), 2) + (Math.cos(radianLatitude) * Math.cos(sharifRadianLatitude) *
                Math.pow(Math.sin(deltaLong / 2), 2));
        double c = 2 * Math.asin(Math.sqrt(a));

        this.location = Math.round(6371 * c);
    }

    public double getEmployeeLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", distance(Km)" + location +
                '}';
    }
}
