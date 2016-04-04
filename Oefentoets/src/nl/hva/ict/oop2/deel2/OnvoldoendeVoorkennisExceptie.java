/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.hva.ict.oop2.deel2;

/**
 *
 * @author geoffrey
 */
public class OnvoldoendeVoorkennisExceptie extends Exception{
    private Leerling leerling;
    private Vak vak;

    public OnvoldoendeVoorkennisExceptie(Leerling leerling, Vak vak) {
        super("Leerling " + leerling + " voldoet niet aan de eisen voor vak " + vak);
        this.leerling = leerling;
        this.vak = vak;
    }
    
}
