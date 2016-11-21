/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorters;

import datastructures2.Student;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class QuickSort {
    
    public static void sort(ArrayList<Student> students) {
        sort(students, 0, students.size());
    }
    
    private static void sort(ArrayList<Student> students, int start, int end) {
        if (start + 1 == end) {
            return;
        }
        
        Student pivot = students.get(start);
        
        int lowerBorder = start + 1;
        
        for (int i = start + 1; i < end; i++) {
            if (students.get(i).compareTo(pivot) < 0) {
                Student temp = students.get(lowerBorder);
                students.set(lowerBorder, students.get(i));
                students.set(i, temp);
                lowerBorder++;
            }
        }
        
        Student temp = students.get(lowerBorder);
        students.set(lowerBorder, pivot);
        students.set(start, temp);
        
        sort(students, start, lowerBorder);
        sort(students, lowerBorder + 1, end);
    }
}
