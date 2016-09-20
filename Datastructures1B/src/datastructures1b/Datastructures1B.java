/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures1b;

import java.util.ArrayList;
import java.util.Collections;
import static java.util.Collections.sort;
import java.util.Stack;

/**
 *
 * @author geoffrey
 */
public class Datastructures1B {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(8);
        list.add(5);
        list.add(3);
        list.add(1);
        System.out.println("is de lijst aflopend?: " + aflopend(list));

        System.out.println("opdracht 2 yololiaans: ");
        String[] yololiaans = yololiaans(5);
        for (String string : yololiaans) {
            System.out.println(string);
        }
        System.out.println("aantal unieke combinaties: " + yololiaans.length);

        System.out.println("\nopdarcht 3 language: ");
        String[] yolo = {"yo", "lo"};
        String[] xaxixu = {"xa", "xi", "xu"};

        String[] language = language(5, xaxixu);

        for (String string : language) {
            System.out.println(string);
        }
        System.out.println("aantal unieke combinaties: " + language.length);
    }

    public static boolean aflopend(ArrayList<Integer> rij) {
        //Als het eerste getal kleiner is dan het tweede getal,
        //dan is de opgegeven rij niet aflopend: return false
        if (rij.get(0) < rij.get(1)) {
            return false;
        }
        //Het eerste getal is gechecked dus hij kan uit de rij worden gehaalt.
        rij.remove(0);
        //Als na de remove nog maar 1 getal over is in de rij, return true;
        //Dit betekent dus dat de rij aflopend is. Hiermee stopt de recursie.
        if (rij.size() == 1) {
            return true;
        }
        //Roep deze methode aan en geef de rij mee waarbij het eerste getal
        //is weg gehaald.
        return aflopend(rij);
    }

    public static String[] yololiaans(int n) {
        //De if zorgt ervoor dat het geen oneindige loop wordt, 
        //ook wordt er een lege string gereturned zodat bij n == 1
        //er één maal door de for loop heen wordt gelopen, dit heeft als
        //resultaat: yo + "" en lo + "" bij n == 1. Als er een leeg array
        //zou worden gereturned dan zou hij niet door de for loop heen gaan.
        if (n == 0) {
            String[] array = new String[1];
            array[0] = "";
            return array;
        }

        //Maak een arraylist aan zodat er flexibel strings toegevoegd kunnen 
        //worden.
        ArrayList<String> lijst = new ArrayList<>();
        //Loop door de array heen die de deze functie returned bij n - 1.
        for (String string : yololiaans(n - 1)) {
            //Plak elke string uit de array achter zowel yo als lo.
            lijst.add("yo" + string);
            lijst.add("lo" + string);
        }
        //zet de arraylist om naar een array en return hem.
        return lijst.toArray(new String[0]);
    }

    public static String[] language(int n, String[] syllables) {
        if (n == 0) {
            String[] array = new String[1];
            array[0] = "";
            return array;
        }

        ArrayList<String> lijst = new ArrayList<>();
        for (String string : language(n - 1, syllables)) {
            for (String syllable : syllables) {
                //Een kleine aanpassing op de vorige methode, hij loopt namelijk 
                //door elke opgegeven syllable in syllables en plakt daar             
                //vervolgens de string achter aan
                lijst.add(syllable + string);
            }
        }
        return lijst.toArray(new String[0]);
    }

}
