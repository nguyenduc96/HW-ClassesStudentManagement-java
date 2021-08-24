package controller;

import model.Classes;
import model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentManagement implements IGeneralManagement<Student> {
    public static List<Student> students = new ArrayList<>();

    static {
        students.add(new Student("m1", "duc", "30/09/1996", 1, "001"));
        students.add(new Student("m2", "anh", "30/09/1996", 4,"001"));
        students.add(new Student("m3", "thanh", "30/09/1996", 5, "002"));
        students.add(new Student("m4", "hanh", "30/09/1996", 6, "002"));
        students.add(new Student("m5", "manh", "30/09/1996", 8, "001"));
        students.add(new Student("m6", "manh", "30/09/1996", 9, "001"));
        students.add(new Student("m7", "manh", "30/09/1996", 7, "001"));
        students.add(new Student("m8", "manh", "30/09/1996", 2, "001"));
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
            System.out.println(student);
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
