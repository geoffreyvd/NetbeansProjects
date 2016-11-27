/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures2;

import java.util.Comparator;
import java.util.Iterator;

/**
 *
 * @author geoffrey
 */
public class Student implements Comparable<Student>{
    public static int CURRENTSTUDENTNUMMER = 50060000;
    private int studentNummer;
    private Klas klas;
    private float cijfer;

    public int getStudentNummer() {
        return studentNummer;
    }

    public Klas getKlas() {
        return klas;
    }

    public float getCijfer() {
        return cijfer;
    }

    public Student(Klas klas, float cijfer) {
        this.studentNummer = newStudentNumber();
        this.klas = klas;
        this.cijfer = cijfer;
    }
    
    @Override
    public String toString() {
        return studentNummer + ", " + cijfer + ", " + klas;
    }
    
    private static int newStudentNumber(){
        CURRENTSTUDENTNUMMER++;
        return CURRENTSTUDENTNUMMER;
    }     

    @Override
    public int compareTo(Student t) {
        int result = Float.compare(cijfer,t.getCijfer());
        Counter.countStudenten++;
        if (result == 0) {
            Counter.countDubbeleCijfers++;
            return Integer.compare(studentNummer, t.getStudentNummer());
        }
        return result;
    }    
}
