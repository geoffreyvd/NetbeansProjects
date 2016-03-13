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
public class Dranken extends MenuKaartArtikel{
    private int milliliter;

    public Dranken(int milliliter, int artikelID, int calorien, float prijs, String naam) {
        super(artikelID, calorien, prijs, naam);
        this.milliliter = milliliter;
    }

    @Override
    public int getArtikelID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
