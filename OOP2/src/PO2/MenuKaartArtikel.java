package PO2;

import java.io.Serializable;

/**
 * @description Abstract class for menu articels
 * @author geoffrey
 */
public abstract class MenuKaartArtikel implements Serializable, Comparable<MenuKaartArtikel>{
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

    public int getArtikelID(){
        return artikelID;
    }

    public int getCalorien() {
        return calorien;
    }

    public float getPrijs() {
        return prijs;
    }

    public String getNaam() {
        return naam;
    }

    @Override
    public String toString() {
        return "artikelID=" + artikelID + ", calorien=" + calorien + ", prijs=" + prijs + ", naam=" + naam;
    }

    @Override
    public int compareTo(MenuKaartArtikel t) {
        return Integer.compare(this.calorien, t.calorien);
    }
    
    
}
