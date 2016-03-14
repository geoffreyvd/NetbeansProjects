/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PO2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

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

        try (
                FileOutputStream output = new FileOutputStream("temp.dat");) {
            for (MenuKaartArtikel menuKaartArtikel : menukaart) {
                output.write(menuKaartArtikel.getArtikelID());
                output.write(menuKaartArtikel.getCalorien());
            }
        }

        try (
                FileInputStream input = new FileInputStream("temp.dat");) {
            int value;
            while ((value = input.read()) != -1) {
                System.out.println(value + " ");
            }
        }
    }
}
