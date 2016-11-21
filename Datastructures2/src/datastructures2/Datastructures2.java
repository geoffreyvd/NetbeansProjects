/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import sorters.QuickSort;

/**
 *
 * @author geoffrey
 */
public class Datastructures2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int aantalStudenten = 160000;
        int aantalLeerroutes = 5;
        //Rondt af naar boven, bij 31/5 = 6,2 = 7 zodat er genoeg plek is
        //bij de volgende berekeningen
        int aantalStudentenPerRichting = (int) Math.ceil(aantalStudenten / (double) aantalLeerroutes);
        int aantalKlassenPerRichting = (int) Math.ceil(aantalStudentenPerRichting / (double) Klas.MAXAANTALSTUDENTEN);
        int aantalStudentenPerKlas = (int) Math.ceil(aantalStudentenPerRichting / (double) aantalKlassenPerRichting);
        int aantalKlassen = aantalKlassenPerRichting * 5;

        System.out.println("aantal studenten: " + aantalStudenten);
        System.out.println("aantal klassen: " + aantalKlassen);
        System.out.println("aantal studenten per richting: " + aantalStudentenPerRichting);
        System.out.println("aantal klassen per richting: " + aantalKlassenPerRichting);
        System.out.println("aantal studenten per klas: " + aantalStudentenPerKlas);
        
        ArrayList<Student> studenten = new ArrayList<>();
        ArrayList<Klas> klassen = new ArrayList<>(aantalKlassen);
        //voeg klassen toe, per richting evenveel klassen dus kan ze tegelijk 
        //toewijzen.
        for (int i = 1; i <= aantalKlassenPerRichting; i++) {
            klassen.add(new Klas('B', i));
            klassen.add(new Klas('G', i));
            klassen.add(new Klas('N', i));
            klassen.add(new Klas('S', i));
            klassen.add(new Klas('T', i));
        }
        
        int newStudentCount = 0;
        for (int i = 0; i < aantalStudentenPerKlas; i++) {
            for (Klas klas : klassen) {
                //als het aantal nieuwe studenten het aantal opgegeven 
                //studenten bereikt, stop dan. Zo worden er precies het aantal
                //opgegeven studenten verdeelt onder de klassen.
                if (newStudentCount < aantalStudenten) {
                    Student student = new Student(klas, (float) ((Math.random() * 9) + 1));
                    klas.addStudent(student);
                    studenten.add(student);
                    newStudentCount++;
                } else {
                    break;
                }
            }
        }

//        int aantalStudenten2 = 0;
//        for (Klas klas : klassen) {
//            aantalStudenten2 += klas.getAantalStudenten();
//            System.out.println("klas: " + klas + ", " + klas.getStudenten().size());
//            Locale local = new Locale("");
//            for (Student student : klas) {
//                System.out.println(String.format(local, "%.1f", student.getCijfer()) + ",");
//            }
//        }
//        System.out.println("aantal studenten per klas opgeteld: " + aantalStudenten2);
//        
        //sorteren op cijfer met bubblesort
//        Collections.shuffle(studenten);
//        StudentCijferComparator c = new StudentCijferComparator();
//        Sorter.bubbleSort(studenten, c);
        
//        for (Student s : studenten) {
//            System.out.println(s);
//        }
//        
        //System.out.println("BUCKETSORT----------------------------------");
        
        Collections.shuffle(studenten);
//        //sorteer studenten d.m.v. bucket sort op studentnr en alphabet klasnr
//        ArrayList<Bucket> buckets = Sorter.bucketSortStudents(studenten);
////        
//        for (Bucket bucket : buckets) {
//            System.out.println("KLAS: " + bucket.getKlas());
//            for (Student s : bucket.getItems()) {
//                System.out.println(s.toString());
//            }
//        }
        
        System.out.println("aantal klas vergelijkingen: " + Counter.countKlas);
        System.out.println("aantal student vergelijkingen: " + Counter.countStudenten);
        
        long time = System.currentTimeMillis();
        QuickSort.sort(studenten);
        System.out.println("sort time in miliseconds: " + (System.currentTimeMillis() - time));
    }
}
