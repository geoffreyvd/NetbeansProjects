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
public abstract class MenuKaartArtikel {
    private int artikelID;
    private int calorien;
    private float prijs;
    private String naam;

    public MenuKaartArtikel(int artikelID, int calorien, float prijs, String naam) {
        this.artikelID = artikelID;
        this.calorien = calorien;
        this.prijs = prijs;
        this.naam = naam;
    }

    abstract public int getArtikelID();

    public int getCalorien() {
        return calorien;
    }

    public float getPrijs() {
        return prijs;
    }

    public String getNaam() {
        return naam;
    }
    
    
}
