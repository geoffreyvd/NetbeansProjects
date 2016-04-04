package nl.hva.ict.oop2;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import nl.hva.ict.oop2.deel2.School;
import nl.hva.ict.oop2.deel1.Trappist;

/**
 *
 * @author breud
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        testDeel1();
        testDeel2();
        testDeel3();
    }

    /**
     * Deze methode test deel 1 (Brouwerij)
     */
    private static void testDeel1() {
        Trappist trappist = new Trappist("Westmalle");
        trappist.gist(5);
    }

    /**
     * Deze methode test deel 2 (Voorkennis)
     */
    private static void testDeel2() {
        School hva = new School();
        hva.startSchooljaar();
    }

    /**
     * Deze methode test deel 3 ()
     */
    private static void testDeel3() {
        boolean doorgaan = true;
        Object object;
        do {
            ObjectInputStream inputStream = null;
            try {
                System.out.println("Voer een bestandsnaam in");
                Scanner sc = new Scanner(System.in);
                File file = new File(sc.next());

                if ("quit".equals(file.getPath())) {
                    doorgaan = false;
                    break;
                }
                if (file.canRead()) {
                    inputStream = new ObjectInputStream(new FileInputStream(file));
                    do {
                        object = inputStream.readObject();
                        System.out.println(object.toString() + " ");
                    } while (true);
                }
            } catch (EOFException ex) {
            } catch (FileNotFoundException ex) {
                System.out.println("File not found!\n");
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                System.out.println("Wrong format\n");
            } finally {
                try {
                    inputStream.close();
                } catch (NullPointerException ex) {
                    System.out.println("File not found\n");
                } catch (IOException ex) {
                }
            }
        } while (doorgaan);

    }

}
