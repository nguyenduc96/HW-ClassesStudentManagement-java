package view;

import controller.StudentManagement;
import exception.NumberPointException;
import exception.UniqueIdException;
import model.Student;

import java.util.List;
import java.util.Scanner;

public class StudentMain {
    private Scanner scanner = new Scanner(System.in);
    public static StudentManagement studentManagement = new StudentManagement();

    public void runStudentMain() {
        String choice = "";
        int choiceNumber = -1;
        do {
            menu();
            do {
                try {
                    System.out.println("Mời bạn chọn : ");
                    choice = scanner.nextLine();
                    choiceNumber = Integer.parseInt(choice);
                } catch (NumberFormatException e) {
                    System.err.println("Bạn phải nhập vào số");
                }
            } while (choice.equals(""));
            switch (choiceNumber) {
                case 1: {
                    studentManagement.displayAll();
                    break;
                }
                case 2: {
                    findStudentInfo();
                    break;
                }
                case 3: {
                    Student student = initStudent();
                    studentManagement.addNew(student);
                    break;
                }
                case 4: {
                    updateStudentInfo();
                    break;
                }
                case 5: {
                    deleteStudentInfo();
                    break;
                }
                case 6: {
                    sortList();
                    break;
                }
                case 7: {
                    displayTopPoint();
                    break;
                }
                case 8: {
                    studentManagement.writeFile("studentinfo.txt");
                    System.out.println("OK");
                    break;
                }
                case 9: {
                    studentManagement.readFile("studentinfo.txt");
                    System.out.println("OK");
                    break;
                }
                case 0: {
                    break;
                }
                default: {
                    System.err.println("SỐ NHẬP KHÔNG TRONG MENU. MỜI NHẬP LẠI");
                    break;
                }
            }
        } while (choiceNumber != 0);
    }

    private void displayTopPoint() {
        System.out.println("TOP 5 sinh viên điểm cao nhất");
        studentManagement.sortPoint();
        for (int i = 0; i < 5; i++) {
            Student student = studentManagement.students.get(i);
            studentManagement.checkDisplay(student);
        }
    }


    private void sortList() {
        String inputChoice = "";
        int choiceSubMenu = -1;
        do {
            subMenu();
            do {
                try {
                    System.out.println("Mời chọn : ");
                    inputChoice = scanner.nextLine();
                    choiceSubMenu = Integer.parseInt(inputChoice);
                } catch (NumberFormatException e) {
                    System.err.println("Bạn phải nhập vào số");
                }
            } while (inputChoice.equals(""));
            switch (choiceSubMenu) {
                case 1: {
                    insertionSortAtoZ();
                    choiceSubMenu = 0;
                    break;
                }
                case 2: {
                    insertionSortZtoA();
                    choiceSubMenu = 0;
                    break;
                }
                default: {
                    System.out.println("SỐ BẠN NHẬP KHÔNG CO TRONG MENU MỜI NHẬP LẠI");
                    break;
                }
            }
        } while (choiceSubMenu != 0);
    }

    private void findStudentInfo() {
        System.out.println("Nhập mã sinh viên muốn tìm kiếm");
        String id = scanner.nextLine();
        int index = studentManagement.findIndex(id);
        if (index != -1) {
            System.out.println(studentManagement.students.get(index).toString());
        } else {
            System.err.println("Không tìm thấy sinh viên có mã sinh viên : " + id);
        }
    }

    private void deleteStudentInfo() {
        System.out.println("Nhập mã sinh viên muốn xóa thông tin : ");
        String id = scanner.nextLine();
        int index = studentManagement.findIndex(id);
        if (index != -1) {
            studentManagement.delete(index);
        } else {
            System.err.println("Không tìm thấy sinh viên có mã sinh viên : " + id);
        }
    }

    private void updateStudentInfo() {
        System.out.println("Nhập mã sinh viên muốn sửa thông tin : ");
        String id = scanner.nextLine();
        int index = studentManagement.findIndex(id);
        Student student = initStudent();
        if (index != -1) {
            studentManagement.update(index, student);
        } else {
            System.err.println("Không tìm thấy sinh viên có mã sinh viên : " + id);
        }
    }

    private void subMenu() {
        System.out.println("--------SẮP XẾP DANH SÁCH HỌC VIÊN--------");
        System.out.println("1. Sắp sếp từ A -> Z");
        System.out.println("2. Sắp sếp từ Z -> A");
        System.out.println("0. Quay lại");
        System.out.println("-------------------------------------------");
    }

    private Student initStudent() {
        String id = "";
        do {
            try {
                id = inputStudentId();
            } catch (UniqueIdException e) {
                System.err.println("Mã sinh viên này đã tồn tại. Mời nhập lại");
            }
        } while (id.equals(""));
        System.out.println("Họ và tên : ");
        String name = scanner.nextLine();
        System.out.println("Ngày sinh : ");
        String dateOfBirth = scanner.nextLine();
        String pointInput = "";
        double point = -1;
        do {
            try {
                System.out.println("Nhập điểm : ");
                pointInput = scanner.nextLine();
                point = inputPoint(pointInput);
            } catch (NumberFormatException e) {
                System.err.println("Điểm nhập vào phải là dạng số. Hãy nhập lại");
            } catch (NumberPointException e) {
                System.err.println("Điểm nhập vào phải từ 0 đến 10. Hãy nhập lại");
            }
        } while (pointInput.equals(""));
        return new Student(id, name, dateOfBirth, point);
    }

    private double inputPoint(String pointInput) throws NumberPointException {
        double point = -1;
        point = Double.parseDouble(pointInput);
        if (point < 0 || point > 10) {
            throw new NumberPointException();
        }
        return point;
    }

    private String inputStudentId() throws UniqueIdException {
        System.out.println("Mã sinh viên : ");
        String id = scanner.nextLine();
        if (studentManagement.findIndex(id) != -1) {
            throw new UniqueIdException();
        }
        return id;
    }

    private void insertionSortZtoA() {
        Student student;
        int pos;
        List<Student> studentList = studentManagement.students;
        for (int i = 1; i < studentList.size(); i++) {
            student = studentList.get(i);
            pos = i;
            while (pos > 0 && studentList.get(pos - 1).getName().compareTo(student.getName()) < 0) {
                studentList.set(pos, studentList.get(pos - 1));
                pos--;
            }
            studentList.set(pos, student);
        }
        System.out.println("ĐÃ SẮP XẾP");
    }

    private void insertionSortAtoZ() {
        Student student;
        int pos;
        List<Student> studentList = studentManagement.students;
        for (int i = 1; i < studentList.size(); i++) {
            student = studentList.get(i);
            pos = i;
            while (pos > 0 && studentList.get(pos - 1).getName().compareTo(student.getName()) > 0) {
                studentList.set(pos, studentList.get(pos - 1));
                pos--;
            }
            studentList.set(pos, student);
        }
        System.out.println("ĐÃ SẮP XẾP");
    }

    private void menu() {
        System.out.println("--------QUẢN LÝ THÔNG TIN SINH VIÊN--------");
        System.out.println("1. Hiển thị toàn bộ thông tin sinh viên");
        System.out.println("2. Tìm kiếm thông tin sinh viên");
        System.out.println("3. Thêm thông tin sinh viên");
        System.out.println("4. Cập nhật thông tin sinh viên");
        System.out.println("5. Xóa thông tin sinh viên");
        System.out.println("6. Sắp xếp danh sách");
        System.out.println("7. Hiển thị TOP 5 sinh viên điểm cao");
        System.out.println("8. Ghi file");
        System.out.println("9. Đọc file");
        System.out.println("0. Quay lại");
        System.out.println("-------------------------------------------");
    }
}
