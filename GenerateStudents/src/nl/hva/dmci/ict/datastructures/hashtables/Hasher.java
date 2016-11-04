/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.hva.dmci.ict.datastructures.hashtables;

/**
 *
 * @author Thomas
 */
public class Hasher {
    
    private Hasher() {
        
    }
    
    public static int hash(String toHash) {
        int hash = 7;
        
        char[] chars = toHash.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            hash = hash * 31 + chars[i];
        }

        if (hash < 0) {
            hash = Math.abs(hash);
        }
        return hash;
    }
}
