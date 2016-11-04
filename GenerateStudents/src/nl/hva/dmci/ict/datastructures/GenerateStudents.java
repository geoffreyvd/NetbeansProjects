
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
        StudentList studentsList = new StudentList(10000);
        Student[] students = studentsList.getList();
        System.out.println(students[1000]);        
        
        HTSeperateChaining htsc = new HTSeperateChaining(10000);
        
        for (int i = 0; i < students.length; i++) {
            htsc.put(students[i].getLdap(), students[i]);
        }
        
        System.out.println(htsc.getCollisionsCount());
        System.out.println(htsc.get(students[1000].getLdap()));
        
        HTLinearProbing htlp = new HTLinearProbing(10000);
        
        for (int i = 0; i < students.length; i++) {
            htlp.put(students[i].getLdap(), students[i]);
        }
        
        System.out.println(htlp.getCollisionsCount());
        System.out.println(htlp.get(students[1000].getLdap()));
        
        HTQuadraticProbing htqp = new HTQuadraticProbing(10000);
        
        for (int i = 0; i < students.length; i++) {
            htqp.put(students[i].getLdap(), students[i]);
        }
        
        System.out.println(htlp.getCollisionsCount());
        System.out.println(htlp.get(students[1000].getLdap()));
    }
    
}
