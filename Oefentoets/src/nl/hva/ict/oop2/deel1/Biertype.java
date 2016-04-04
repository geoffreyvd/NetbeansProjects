/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.hva.ict.oop2.deel1;

/**
 *
 * @author geoffrey
 */
public abstract class Biertype implements Brouwduur{
    protected int rijpweken = 0;
    
    protected abstract void rijp();

    @Override
    public void gist(int aantalWeken) {
        for (int i = 1; i <= aantalWeken; i++) {
            rijpweken = i;
            rijp();
        }    
    }   
}
