/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures2;

import java.util.Comparator;

/**
 *
 * @author Thomas
 */
public class StudentCijferComparator implements Comparator<Student> {

    @Override
    public int compare(Student t, Student t1) {
        return Float.compare(t.getCijfer(), t1.getCijfer());
    }

}
