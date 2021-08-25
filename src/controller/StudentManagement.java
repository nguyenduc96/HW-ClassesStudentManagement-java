package controller;

import model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentManagement implements IGeneralManagement<Student> {
    public static List<Student> students = new ArrayList<>();

    static {
        students.add(new Student("m1", "Duc Nguyen Huynh", "30/09/1996", 1, "001"));
        students.add(new Student("m2", "Anh Nguyen Tuan", "11/08/1995", 4, "001"));
        students.add(new Student("m3", "Thanh Trieu Van", "21/12/1996", 5, "002"));
        students.add(new Student("m4", "Dung Nguyen Kim", "19/11/1998", 6, "002"));
        students.add(new Student("m5", "Manh Khong Van", "25/07/2000", 8, "001"));
        students.add(new Student("m6", "Hieu Nguyen Cong", "14/05/1999", 9, "002"));
        students.add(new Student("m7", "Cuong Chu Cong", "09/02/1997", 7, "001"));
        students.add(new Student("m8", "Van Nguyen Khanh", "02/09/1998", 2, "001"));
    }

    @Override
    public void addNew(Student student) {
        students.add(student);
    }

    @Override
    public void delete(int index) {
        students.remove(index);
    }

    @Override
    public void displayAll() {
        for (Student student : students) {
            System.out.println("Mã sinh viên : " + student.getId() + ", Họ và tên : " + student.getName() +
                    ", Ngày sinh : " + student.getDateOfBirth() + ", Điểm : " + student.getPoint() +
                    ", Mã lớp : " + student.getClassId());
        }
    }

    @Override
    public void update(int index, Student student) {
        students.set(index, student);
    }

    @Override
    public int findIndex(String id) {
        int index = -1;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(id)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public void sortPoint() {
        Student student;
        int pos;
        for (int i = 1; i < students.size(); i++) {
            student = students.get(i);
            pos = i;
            while (pos > 0 && student.getPoint() > students.get(pos - 1).getPoint()) {
                students.set(pos, students.get(pos - 1));
                pos--;
            }
            students.set(pos, student);
        }
    }
}
