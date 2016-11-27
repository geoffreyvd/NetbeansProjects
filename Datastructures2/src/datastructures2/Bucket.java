/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures2;

import java.util.LinkedList;

/**
 *
 * @author Thomas
 */
public class Bucket {

    private Klas klas;
    private LinkedList<Student> items = new LinkedList<>();
    private StudentNummerComparator comparator;

    public Klas getKlas() {
        return klas;
    }

    public void setKlas(Klas klas) {
        this.klas = klas;
    }

    public LinkedList<Student> getItems() {
        return items;
    }

    public void addStudent(Student student) {
        if (comparator == null) {
            comparator = new StudentNummerComparator();
        }

        if (items.size() < 1) {
            items.add(student);
            return;
        }

        int iteration = 0;
        boolean added = false;
        for (Student listItem : items) {
            if (comparator.compare(student, listItem) < 0) {
                items.add(iteration, student);
                added = true;
                break;
            }

            iteration++;
        }

        if (!added) {
            items.add(iteration, student);
        }
    }
}
