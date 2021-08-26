package controller;

import model.Classes;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ClassesManagement implements IGeneralManagement<Classes> {
    public static List<Classes> classesList = new ArrayList<>();

    @Override
    public void addNew(Classes classes) {
        classesList.add(classes);
    }

    @Override
    public void delete(int index) {
        classesList.remove(index);
    }

    @Override
    public void displayAll() {
        for (Classes classes : classesList) {
            System.out.println("Mã lớp : " + classes.getId() + ", Tên lớp : " + classes.getName());
        }
    }

    @Override
    public void update(int index, Classes classes) {
        classesList.set(index, classes);
    }

    @Override
    public int findIndex(String id) {
        int index = -1;
        for (int i = 0; i < classesList.size(); i++) {
            if (classesList.get(i).getId().equals(id)) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public void readFile(String path) {
        try {
            classesList.clear();
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null){
                String[] strings = line.split(",");
                String id = strings[0];
                String name = strings[1];
                classesList.add(new Classes(id, name));
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
            for (Classes classes : classesList) {
                bufferedWriter.write(classes.toString() + "\n");
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            System.err.println("Đường dẫn không đúng hoặc file không tồn tại.");
        }
    }
}
