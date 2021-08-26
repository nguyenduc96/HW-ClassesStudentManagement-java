package model;

public class Student {
    private String id;

    private String name;

    private String dateOfBirth;

    private double point;

    private Classes classes;

    public Student() {
    }

    public Student(String id, String name, String dateOfBirth, double point) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.point = point;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + dateOfBirth + "," + point + "," +classes;
    }
}
