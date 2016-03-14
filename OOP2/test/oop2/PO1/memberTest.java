/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop2.PO1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author geoffrey
 */
public class memberTest {

    private member instance = new member("Geoffrey", "Driessel", 2300.00f, Rank.assistant);

    public memberTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getFirstName method, of class member.
     */
    @Test
    public void testGetFirstName() {
        System.out.println("getFirstName");
        String expResult = "Geoffrey";
        String result = instance.getFirstName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLastName method, of class member.
     */
    @Test
    public void testGetLastName() {
        System.out.println("getLastName");
        String expResult = "Driessel";
        String result = instance.getLastName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSalary method, of class member.
     */
    @Test
    public void testGetSalary() {
        System.out.println("getSalary");
        float expResult = 2300.00F;
        float result = instance.getSalary();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getRank method, of class member.
     */
    @Test
    public void testGetRank() {
        System.out.println("getRank");
        Rank rank = Rank.assistant;
        Rank result = instance.getRank();
        assertEquals(rank, result);
    }

    /**
     * Test of toString method, of class member.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "member{firstName=Geoffrey, lastName=Driessel, salary=2300.0, rank=assistant}";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
    

}
