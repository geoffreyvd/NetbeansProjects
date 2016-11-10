/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.hva.dmci.ict.datastructures.hashtables;

import java.util.LinkedList;
import nl.hva.dmci.ict.datastructures.Student;

/**
 *
 * @author Thomas
 */
public class HTSeperateChaining {
    
    private LinkedList[] table;
    
    private int collisionsCount;
    
    public HTSeperateChaining(int size) {
        table = new LinkedList[size];
    }
    
    public void put(String key, Student s) {
        int index = Hasher.hash(key) % table.length;
        if (table[index] == null) {
            table[index] = new LinkedList();
        }
        else {
            collisionsCount++;
        }
        
        table[index].add(s);
    }
    
    public Object get(String key) {
        int index = Hasher.hash(key) % table.length;
        
        LinkedList list = table[index];
        
        for (Object o : list) {
            Student s = (Student)o;
            if (key.equals(s.getLdap())) {
                return s;
            }
        }
        
        return null;
    }

    public int getCollisionsCount() {
        return collisionsCount;
    }
}
