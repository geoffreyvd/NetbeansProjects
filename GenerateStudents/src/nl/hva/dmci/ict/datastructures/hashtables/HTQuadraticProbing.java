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
        int newIndex = 0;
        
        while (true) {
            int putIndex = index + (int)Math.pow(newIndex, 2);
            putIndex = putIndex % table.length;
            if (table[putIndex] == null) {
                table[putIndex] = s;
                break;
            } else {
                newIndex++;
                collisionsCount++;
            }
        }
    }

    public Student get(String key) {
        int index = Hasher.hash(key) % table.length;
        int newIndex = 0;
        
        while (true) {
            int putIndex = index + (int)Math.pow(newIndex, 2);
            putIndex = putIndex % table.length;
            if (table[putIndex].getLdap().equals(key)) {
                return table[putIndex];
            }
            else {
                newIndex++;
            }
        }
    }

    public int getCollisionsCount() {
        return collisionsCount;
    }
}
