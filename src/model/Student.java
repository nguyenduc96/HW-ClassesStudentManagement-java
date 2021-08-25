package model;

public class Student {
    private String id;

    private String name;

    private String dateOfBirth;

    private double point;

    private String classId;

    public Student() {
    }

    public Student(String id, String name, String dateOfBirth, double point, String classId) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.point = point;
        this.classId = classId;
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

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Mã sinh viên : '" + id + '\'' +
                ", Họ và tên : '" + name + '\'' +
                ", Ngày sinh : '" + dateOfBirth + '\'' +
                ", Điểm : '" + point + '\'' +
                ", Mã lớp học : '" + classId + '\'' +
                '}';
    }
}
