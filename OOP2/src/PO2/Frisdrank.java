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
public class Frisdrank extends Dranken{
    private String merk;

    public Frisdrank(String merk, int milliliter, int artikelID, int calorien, float prijs, String naam) {
        super(milliliter, artikelID, calorien, prijs, naam);
        this.merk = merk;
    }
    
    @Override
    public String toString() {
        String text = "";
        text += super.toString();
        text += ", " + "merk=" + merk;
        return text;
    }
    
    
}
