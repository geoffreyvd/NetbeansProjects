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

    private float key;
    private Student root;
    private Node left;
    private Node right;
    private int countLeftSub;

    public Node() {
    }

    public Node(Student root) {
        this.root = root;
        this.left = null;
        this.right = null;
        this.countLeftSub = 0;
        this.key = root.getCijfer();
    }

    public void add(Student student) {
        if (root.compareTo(student) < 0) {
            if (right == null) {
                right = new Node(student);
            } else {
                right.add(student);
            }
        } else if (left == null) {
            countLeftSub++;
            left = new Node(student);
        } else {
            countLeftSub++;
            left.add(student);
        }
    }

    public Student get(float cijfer) {
        float result = key - cijfer;
        if (result == 0) {
            return root;
        } else if (result > 0) {
            if (left != null) {
                return left.get(cijfer);
            } else {
                return null;
            }
        } else if (right != null) {
            return right.get(cijfer);
        } else {
            return null;
        }
    }

    public int rank(float cijfer, int rank) {
        if (cijfer == key) {
            return rank + countLeftSub;
        } else if ((cijfer - key) < 0) {
            if (left != null) {
                rank = left.rank(cijfer, rank);
            } else {
                return rank;
            }
        } else if (right != null) {
            rank = right.rank(cijfer, rank + countLeftSub + 1);
        } else {
            return rank + countLeftSub + 1;
        }
        return rank;
    }

}
