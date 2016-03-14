/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PO2;

/**
 *
 * @author geoffrey
 */
public class Gerechten extends MenuKaartArtikel{
    private String beschrijving;
    private int gram;
    private int maakTijd; //in minuten

    public Gerechten(String beschrijving, int gram, int maakTijd, int artikelID, int calorien, float prijs, String naam) {
        super(artikelID, calorien, prijs, naam);
        this.beschrijving = beschrijving;
        this.gram = gram;
        this.maakTijd = maakTijd;
    }   
 

    @Override
    public String toString() {
        String text = "";
        text += super.toString();
        text += ", " + "beschrijving=" + beschrijving + ", gram=" + gram + ", maakTijd=" + maakTijd + " minuten";
        return text;
    }
    
    
}
