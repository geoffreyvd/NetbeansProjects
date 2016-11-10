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
public class HTLinearProbing {

    private Student[] table;

    private int collisionsCount;

    public HTLinearProbing(int size) {
        table = new Student[size];
    }

    public void put(String key, Student s) {
        int index = Hasher.hash(key) % table.length;
        int newIndex = index;
        
        while (true) {
            if (table[newIndex] == null) {
                table[newIndex] = s;
                break;
            } else {
                newIndex++;
                newIndex %= table.length;
                collisionsCount++;
            }
        }
    }

    public Student get(String key) {
        int index = Hasher.hash(key) % table.length;
        int newIndex = index;
        
        while (true) {
            if (table[newIndex].getLdap().equals(key)) {
                return table[newIndex];
            }
            else {
                newIndex++;
                newIndex =+ table.length;
            }
        }
    }

    public int getCollisionsCount() {
        return collisionsCount;
    }
}
