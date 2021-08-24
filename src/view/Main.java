package view;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        ClassesMain classesMain = new ClassesMain();
        StudentMain studentMain = new StudentMain();
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
                    studentMain.runStudentMain();
                    break;
                }
                case 2:{
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
        System.out.println("-------------------------------------------");
        System.out.println("MAIN MENU");
        System.out.println("1. QUẢN LÝ SINH VIÊN");
        System.out.println("2. QUẢN LÝ LỚP HỌC");
        System.out.println("0. THOÁT");
        System.out.println("-------------------------------------------");
    }
}
