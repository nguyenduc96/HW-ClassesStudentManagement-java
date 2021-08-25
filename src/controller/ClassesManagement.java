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
}
