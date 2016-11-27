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
public class Node {

    private Student root;
    private Node left;
    private Node right;

    public Node() {
    }

    public Node(Student root) {
        this.root = root;
        this.left = null;
        this.right = null;
    }

    public void add(Student student) {
        if (root.compareTo(student) < 0) {
            if (right == null) {
                right = new Node(student);
            } else {
                right.add(student);
            }
        } else if (left == null) {
            left = new Node(student);
        } else {
            left.add(student);
        }
    }
    
    public Student get (Student student){
        int result = root.compareTo(student);
        if(result == 0){
            return root;
        }else if(result > 0){
            return left.get(student);
        }
        return right.get(student);
    }

}
