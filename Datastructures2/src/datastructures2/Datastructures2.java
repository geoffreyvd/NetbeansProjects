/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures2;

import java.util.ArrayList;

/**
 *
 * @author geoffrey
 */
public class Datastructures2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int aantalStudenten = 165;
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
                    klas.addStudent(new Student(klas, (float) ((Math.random() * 9) + 1)));
                    newStudentCount++;
                } else {
                    break;
                }
            }
        }

        int aantalStudenten2 = 0;
        for (Klas klas : klassen) {
            aantalStudenten2 += klas.getAantalStudenten();
            System.out.println("klas: " + klas + ", " + klas.getAantalStudenten());
//            for (Student student : klas) {
//                System.out.println(String.format("%.1f", student.getCijfer()));
//            }
        }
        System.out.println("aantal studenten per klas opgeteld: " + aantalStudenten2);
    }

}
