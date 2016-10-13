/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures2;

import java.util.Iterator;

/**
 *
 * @author geoffrey
 */
public class Klas implements Iterable<Student>{
    public static final byte MAXAANTALSTUDENTEN = 32;
    private char leerroute;
    private int klasNummer;
    private Student[] studenten = new Student[32];
    private byte aantalStudenten;

    public Klas(char leerroute, int klasNummer) {
        this.leerroute = leerroute;
        this.klasNummer = klasNummer;
        this.aantalStudenten = 0;
    }

    public void addStudent(Student student){
        studenten[aantalStudenten] = student;
        aantalStudenten++;
    }    
    
    @Override
    public String toString() {
        String temp = "2";
        if (klasNummer < 10) {
            temp += "000";
        }else if(klasNummer < 100){
            temp += "00";
        }else if(klasNummer < 1000){
            temp += "0";
        }
        return "I" + leerroute + temp + klasNummer;
    }

    public char getLeerroute() {
        return leerroute;
    }

    public int getKlasNummer() {
        return klasNummer;
    }

    public Student[] getStudenten() {
        return studenten;
    }
    
    public Student getStudent(byte index){
        return studenten[index];
    }

    public byte getAantalStudenten() {
        return aantalStudenten;
    }

    @Override
    public Iterator<Student> iterator() {
        return new studentIterator(aantalStudenten);
    }
    
    private class studentIterator implements Iterator<Student>{
        private byte aantalStudenten1;
        private int currentStudent;

        public studentIterator(byte aantalStudenten) {
            this.aantalStudenten1 = aantalStudenten;
            currentStudent = 0;
        } 
        
        @Override
        public boolean hasNext() {
            return aantalStudenten1 > currentStudent;
        }

        @Override
        public Student next() {
            return studenten[currentStudent++];
        }
        
    }
    
}
