
package nl.hva.dmci.ict.datastructures;

import nl.hva.dmci.ict.datastructures.hashtables.HTLinearProbing;
import nl.hva.dmci.ict.datastructures.hashtables.HTQuadraticProbing;
import nl.hva.dmci.ict.datastructures.hashtables.HTSeperateChaining;
import nl.hva.dmci.ict.datastructures.hashtables.Hasher;

/**
 * Small program that creates a file which can be used for the practical lab
 * 3 of the course Datastructures.
 * 
 * @author Dennis Breuker
 * @author Nico Tromp
 * @author Thomas Blank
 * @author Geoffrey van Driessel
 */
public class GenerateStudents {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int aantalStudenten = 13;
        StudentList studentsList = new StudentList(aantalStudenten);
        Student[] students = studentsList.getList();
        int checkIndex = 12; 
        System.out.println(students[checkIndex]);        
        
        HTSeperateChaining htsc = new HTSeperateChaining(aantalStudenten);
        
        for (int i = 0; i < students.length; i++) {
            htsc.put(students[i].getLdap(), students[i]);
        }
        
        System.out.println("aantal collisions htsc: " + htsc.getCollisionsCount());
        System.out.println("studenten:");
        for (Student student : students) {
            System.out.println(student.getLdap()); 
        }
        
        HTLinearProbing htlp = new HTLinearProbing(aantalStudenten);
        
        for (int i = 0; i < students.length; i++) {
            htlp.put(students[i].getLdap(), students[i]);
        }
        
        System.out.println("aantal collisions htlp: " + htlp.getCollisionsCount());
        System.out.println("studenten:");
        for (Student student : students) {
            System.out.println(student.getLdap()); 
        }
        HTQuadraticProbing htqp = new HTQuadraticProbing(aantalStudenten);
        
        for (int i = 0; i < students.length; i++) {
            htqp.put(students[i].getLdap(), students[i]);
        }
        
        System.out.println("HTQP: \naantal collisions: " +htqp.getCollisionsCount());
        System.out.println("studenten:");
        for (Student student : students) {
            System.out.println(student.getLdap()); 
        }
    }
    
}
