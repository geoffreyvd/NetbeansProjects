/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop2.PO1;

/**
 *
 * @author geoffrey
 */
public class member {
    private String firstName;
    private String lastName;
    private float salary;
    private Rank rank;

    public member(String firstName, String lastName, float salary, Rank rank) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.rank = rank;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public float getSalary() {
        return salary;
    }

    public Rank getRank() {
        return rank;
    }

    
    @Override
    public String toString() {
        return "member{" + "firstName=" + firstName + ", lastName=" + lastName + ", salary=" + salary + ", rank=" + rank + '}';
    }
    
}
