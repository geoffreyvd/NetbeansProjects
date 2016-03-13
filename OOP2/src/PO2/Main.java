/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PO2;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author geoffrey
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<MenuKaartArtikel> menukaart = new ArrayList<>();
        
        Dranken rodeWijn = new Dranken(200, 1, 40, 2.5f, "Rood wijntje");
        menukaart.add(rodeWijn);
        Frisdrank fanta = new Frisdrank("coca", 300, 1, 35, 2.5f, "fanta");
        menukaart.add(fanta);
        Gerechten patat = new Gerechten("gezoute gefrituurde gesneden aardappels ook wel bekend als patat"
                , 750, 8, 2, 500, 14.95f, "patat");
        menukaart.add(patat);
        
        MenuKaartArtikel artikel = new MenuKaartArtikel(1, 2, 3.3f, "hallo"){

            @Override
            public int getArtikelID() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            
        };
        try {
            int i = artikel.getArtikelID();            
        } catch (Exception e) {
            e.getMessage();
        }
        System.out.println("\n" + Arrays.toString(artikel.getClass().getSuperclass().getDeclaredFields()));
    }
}
