/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorters;

import datastructures2.Counter;
import datastructures2.Student;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class QuickSort {

    public static void sort(ArrayList<Student> students) {
        sort(students, 0, students.size() - 1);
    }

    private static void sort(ArrayList<Student> students, int start, int end) {
        if (start >= end) {
            return;
        }

        Student pivot = students.get((end - start) / 2 + start);
        Student begin = students.get(start);
        Student ending = students.get(end);

        if (begin.compareTo(pivot) > 0) {
            if (begin.compareTo(ending) > 0) {
                pivot = ending;
            } else {
                pivot = begin;
            }
        } else if (begin.compareTo(ending) > 0) {
            pivot = begin;
        } else if (pivot.compareTo(ending) > 0) {
            pivot = ending;
        }

        int lowerBorder = start;

        for (int i = start + 1; i <= end; i++) {
            if (students.get(i).compareTo(pivot) < 0) {
                lowerBorder++;
                Student temp = students.get(lowerBorder);
                students.set(lowerBorder, students.get(i));
                students.set(i, temp);
                Counter.countAantalSwaps++;
            }
        }

        Student temp = students.get(lowerBorder);
        students.set(lowerBorder, pivot);
        students.set(start, temp);
        Counter.countAantalSwaps++;

        sort(students, start, lowerBorder - 1);
        sort(students, lowerBorder + 1, end);
    }
}
