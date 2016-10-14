/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures2;

import java.util.LinkedList;

/**
 *
 * @author geoffrey
 */
public class KlasBucket {

    private char leerroute;
    private int klasNummer;
    LinkedList<Student> studenten = new LinkedList();

    public KlasBucket(char leerroute, int klasNummer) {
        this.leerroute = leerroute;
        this.klasNummer = klasNummer;
    }
    
    @Override
    public String toString() {
        String temp = "2";
        if (klasNummer < 10) {
            temp += "000";
        }else if(klasNummer < 100){
            temp += "00";
        }else if(klasNummer < 1000){
            temp += "0";
        }
        return "I" + leerroute + temp + klasNummer;
    }

}
