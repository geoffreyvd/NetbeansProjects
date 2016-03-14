/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PO2;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author geoffrey
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        ArrayList<MenuKaartArtikel> menukaart = new ArrayList<>();

        Dranken rodeWijn = new Dranken(200, 1, 40, 2.5f, "Rood wijntje");
        menukaart.add(rodeWijn);
        Frisdrank fanta = new Frisdrank("coca", 300, 2, 35, 2.5f, "fanta");
        menukaart.add(fanta);
        Gerechten patat = new Gerechten("Gezoute gefrituurde gesneden aardappels ook wel bekend als patat", 420, 8, 3, 550, 14.95f, "patat");
        menukaart.add(patat);
        Gerechten pizzaMargherita = new Gerechten("Pizza Margherita, Standaard pizza met tomaten saus en kaas en uiteraard een heerlijke krokante bodem", 480, 12, 4, 600, 12.95f, "pizza Margherita");
        menukaart.add(pizzaMargherita);
        for (MenuKaartArtikel menuKaartArtikel : menukaart) {
            System.out.println(menuKaartArtikel.toString());
        }
        
        System.out.println("\n--- input and ouput binary ---\n");
        
        //new ObjectOutputSteam write arraylist menukaart with all the object artikels to the binary file
        try (
                ObjectOutputStream output2 = new ObjectOutputStream(new FileOutputStream("object.dat"));) {
            output2.writeObject(menukaart);
        }

        //new ObjectInputStream read arraylist from file with all the object artikels
        try (
                ObjectInputStream input2 = new ObjectInputStream(new FileInputStream("object.dat"));) {
            
            ArrayList<MenuKaartArtikel> menukaart2 = (ArrayList) (input2.readObject());
            
            //sort de arraylist
            Collections.sort(menukaart2);
            for (MenuKaartArtikel artikel2 : menukaart2) {
                System.out.println(artikel2.toString());
            }
            
                    

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
