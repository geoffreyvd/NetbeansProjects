/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorters;

import datastructures2.Student;

/**
 *
 * @author geoffrey
 */
public class BinaryLinkedList {
    private Node first = null;
    
    public void add(Student student ){
        if(first == null){
            first = new Node(student);
        }
        first.add(student);
    }
    
    public Student get(float cijfer){
        first.get(student);
        return student;
    }
}
