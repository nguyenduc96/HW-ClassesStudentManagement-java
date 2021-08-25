package view;

import controller.ClassesManagement;
import controller.StudentManagement;
import exception.UniqueIdException;
import model.Classes;
import model.Student;

import java.util.Scanner;

public class ClassesMain {
    public Scanner scanner = new Scanner(System.in);
    public ClassesManagement classesManagement = new ClassesManagement();

    public void runClassesMain() {
        String choice = "";
        int choiceNumber = -1;
        do {
            menu();
            do {
                try {
                    System.out.print("Mời bạn chọn : ");
                    choice = scanner.nextLine();
                    choiceNumber = Integer.parseInt(choice);
                } catch (NumberFormatException e) {
                    System.err.println("Bạn phải nhập vào số");
                }
            } while (choice.equals(""));
            switch (choiceNumber) {
                case 1: {
                    classesManagement.displayAll();
                    break;
                }
                case 2: {
                    showStudentInClass();
                    break;
                }
                case 3: {
                    addNewClasses();
                    break;
                }
                case 4: {
                    editClasses();
                    break;
                }
                case 5: {
                    deleteClasses();
                    break;
                }
                case 6: {
                    showAmountStudentInClass();
                    break;
                }
                case 0: {
                    break;
                }
                default:{
                    System.out.println("SỐ NHẬP KHÔNG TRONG MENU. MỜI NHẬP LẠI");
                    break;
                }
            }
        } while (choiceNumber != 0);
    }

    private void showAmountStudentInClass() {
        System.out.println("Nhập mã lớp học muốn hiển thị : ");
        String id = scanner.nextLine();
        int index = classesManagement.findIndex(id);
        int count = 0;
        if (index != -1) {
            for (Student student : StudentManagement.students) {
                if (student.getClassId().equals(id)) {
                   count++;
                }
            }
            System.out.println("Số lượng sinh viên của lớp học có mã " + id + " là : " + count);
        } else {
            System.err.println("Không tìm thấy mã lớp học " + id);
        }
    }

    private void showStudentInClass() {
        System.out.println("Nhập mã lớp học muốn hiển thị : ");
        String id = scanner.nextLine();
        int index = classesManagement.findIndex(id);
        if (index != -1) {
            for (Student student : StudentManagement.students) {
                if (student.getClassId().equals(id)) {
                    System.out.println(student);
                }
            }
        } else {
            System.err.println("Không tìm thấy mã lớp học " + id);
        }
    }

    private void addNewClasses() {
        Classes classes = initClasses();
        classesManagement.addNew(classes);
        System.out.println("THÊM THÀNH CÔNG");
    }

    private void editClasses() {
        System.out.println("Nhập mã lớp học cần chỉnh sửa : ");
        String id = scanner.nextLine();
        int index = classesManagement.findIndex(id);
        if (index != -1) {
            Classes classes = initClasses();
            classesManagement.update(index, classes);
            System.out.println("CHỈNH SỬA THÀNH CÔNG");
        } else {
            System.err.println("Không tìm thấy mã lớp học " + id);
        }
    }

    private void deleteClasses() {
        System.out.println("Nhập mã lớp học cần xóa : ");
        String id = scanner.nextLine();
        int index = classesManagement.findIndex(id);
        if (index != -1) {
            classesManagement.delete(index);
            System.out.println("ĐÃ XÓA");
        } else {
            System.err.println("Không tìm thấy mã lớp học " + id);
        }
    }

    private String inputClassesId() throws UniqueIdException {
        System.out.println("Nhập mã lớp học : ");
        String id = scanner.nextLine();
        if (classesManagement.findIndex(id) != -1) {
            throw new UniqueIdException();
        }
        return id;
    }

    private Classes initClasses() {
        String id = "";
        do {
            try {
                id = inputClassesId();
            } catch (UniqueIdException e) {
                System.err.println("Mã lớp này đã tồn tại. Mời nhập lại");
            }
        } while (id.equals(""));
        System.out.print("Nhập tên lớp học : ");
        String className = scanner.nextLine();
        return new Classes(id, className);
    }

    public void menu() {
        System.out.println("--------------QUẢN LÝ LỚP HỌC--------------");
        System.out.println("1. Hiển thị danh sách các lớp học");
        System.out.println("2. Hiển thị danh sách học viên của một lớp học");
        System.out.println("3. Thêm lớp học");
        System.out.println("4. Cập nhật thông tin lớp học");
        System.out.println("5. Xóa lớp học");
        System.out.println("6. Thống kê số lượng sinh viên của một lớp");
        System.out.println("0. Quay lại");
        System.out.println("-------------------------------------------");
    }
}
