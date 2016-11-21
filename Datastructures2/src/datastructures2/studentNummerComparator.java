/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures2;

import java.util.Comparator;

/**
 *
 * @author geoffrey
 */
public class StudentNummerComparator implements Comparator<Student> {

    @Override
    public int compare(Student t, Student t1) {
        Counter.countStudenten++;
        return t.getStudentNummer() - t1.getStudentNummer();
    }

}
