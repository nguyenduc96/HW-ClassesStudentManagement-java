package controller;

import model.Classes;
import model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentManagement implements IGeneralManagement<Student> {
    public static List<Student> students = new ArrayList<>();

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
            checkDisplay(student);
        }
    }

    public void checkDisplay(Student student) {
        if (student.getClasses() != null) {
            System.out.println("Mã sinh viên : " + student.getId() + ", Họ và tên : " + student.getName() +
                    ", Ngày sinh : " + student.getDateOfBirth() + ", Điểm : " + student.getPoint() +
                    ", Mã lớp : " + student.getClasses().getId() + ", Lớp : " + student.getClasses().getName());
        } else {
            System.out.println("Mã sinh viên : " + student.getId() + ", Họ và tên : " + student.getName() +
                    ", Ngày sinh : " + student.getDateOfBirth() + ", Điểm : " + student.getPoint());
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

    @Override
    public void readFile(String path) {
        try {
            students.clear();
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                String[] strings = line.split(",");
                String id = strings[0];
                String name = strings[1];
                String dateOfBirth = strings[2];
                double point = Double.parseDouble(strings[3]);
                Student student = new Student(id, name, dateOfBirth, point);
                students.add(student);
                if (!strings[4].equals("null")) {
                    student.setClasses(new Classes(strings[4], strings[5]));
                }
            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            System.err.println("Đường dẫn không đúng hoặc file không tồn tại.");
        }
    }

    @Override
    public void writeFile(String path) {
        try {
            FileWriter fileWriter = new FileWriter(path);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Student student : students) {
                bufferedWriter.write(student.toString() + "\n");
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            System.err.println("Đường dẫn không đúng hoặc file không tồn tại.");
        }
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
