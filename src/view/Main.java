package view;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ClassesMain classesMain = new ClassesMain();
        StudentMain studentMain = new StudentMain();
        String choiceInputString = "";
        int choiceNumber = -1;
        do {
            menu();
            do {
                try {
                    System.out.print("Mời bạn chọn : ");
                    choiceInputString = scanner.nextLine();
                    choiceNumber = Integer.parseInt(choiceInputString);
                } catch (NumberFormatException e) {
                    System.err.println("Bạn phải nhập vào số");
                }
            } while (choiceInputString.equals(""));
            switch (choiceNumber) {
                case 1: {
                    studentMain.runStudentMain();
                    break;
                }
                case 2: {
                    classesMain.runClassesMain();
                    break;
                }
                default: {
                    System.out.println("SỐ NHẬP KHÔNG TRONG MENU. MỜI NHẬP LẠI");
                    break;
                }
            }
        } while (choiceNumber != 0);
    }

    private static void menu() {
        System.out.println("----------------MAIN MENU-----------------");
        System.out.println("1. QUẢN LÝ SINH VIÊN");
        System.out.println("2. QUẢN LÝ LỚP HỌC");
        System.out.println("0. THOÁT");
        System.out.println("-------------------------------------------");
    }
}
