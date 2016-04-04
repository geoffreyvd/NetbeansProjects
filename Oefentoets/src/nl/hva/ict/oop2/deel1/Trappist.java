/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.hva.ict.oop2.deel1;

import nl.hva.ict.oop2.deel1.Biertype;

/**
 *
 * @author geoffrey
 */
public class Trappist extends Biertype{
    private String naam;

    public Trappist(String naam) {
        this.naam = naam;
    }

    @Override
    public void rijp() {
        System.out.println("Trappist " + naam + " rijpt nu " + rijpweken);
    }
}
