/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.hva.dmci.ict.datastructures.hashtables;

import nl.hva.dmci.ict.datastructures.Student;

/**
 *
 * @author Thomas
 */
public class HTQuadraticProbing {

    private Student[] table;

    private int collisionsCount;

    public HTQuadraticProbing(int size) {
        table = new Student[size];
    }

    
    
    public void put(String key, Student s) {
        int index = Hasher.hash(key) % table.length;
        int newIndex = index;
        int count = 0;
        
        while (true) {
            if (table[newIndex] == null) {
                table[newIndex] = s;
                break;
            } else {
                count++;
                newIndex += (int)Math.pow(count, 2);
                newIndex %= table.length;
                newIndex = Math.abs(newIndex);
                collisionsCount++;
            }
        }
    }

    public Student get(String key) {
        int index = Hasher.hash(key) % table.length;
        int newIndex = index;
        int count = 0;
        
        while (true) {
            if (table[newIndex].getLdap().equals(key)) {
                return table[newIndex];
            }
            else {
            count++;
            newIndex = index + (int)Math.pow(count, 2);
            newIndex %= table.length;
            newIndex = Math.abs(newIndex);
            }
        }
    }

    public int getCollisionsCount() {
        return collisionsCount;
    }
}
