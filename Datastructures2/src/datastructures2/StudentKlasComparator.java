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
public class StudentKlasComparator implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {
        Counter.countStudenten++;
        return s1.getKlas().toString().compareTo(s2.getKlas().toString());
    }
    
}
