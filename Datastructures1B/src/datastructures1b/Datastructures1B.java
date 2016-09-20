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
        
        String[] language =  language(5, xaxixu);
        
        for (String string : language) {
            System.out.println(string);
        }
        System.out.println("aantal unieke combinaties: " + language.length);
    }

    public static boolean aflopend(ArrayList<Integer> rij) {
        if (rij.get(0) < rij.get(1)) {
            return false;
        }
        rij.remove(0);
        if (rij.size() == 1) {
            return true;
        }
        return aflopend(rij);
    }

    public static String[] yololiaans(int n) {
        //De if zorgt ervoor dat het geen oneindige loop wordt, 
        //ook wordt er een lege string gereturned zodat bij n == 1
        //er één maal door de for loop heen wordt gelopen, dit heeft als
        //resultaat: yo en lo bij n == 1
        if (n == 0) {
            String[] array = new String[1];
            array[0] = "";
            return array;
        }
        
        //maak een array aan met de grote van twee keer het aantal lettergrepen
        ArrayList<String> lijst = new ArrayList<>();
        for (String string : yololiaans(n - 1)) {
            lijst.add("yo" + string);
            lijst.add("lo" + string);
        }
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
                lijst.add(syllable + string);
            }
        }
        return lijst.toArray(new String[0]);
    }

}
