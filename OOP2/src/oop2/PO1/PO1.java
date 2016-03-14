/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop2.PO1;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author geoffrey
 */
public class PO1 {

    public static void main(String[] args) {

        ArrayList<member> members = new ArrayList<>();

        try {
            URL url = new URL("http://cs.armstrong.edu/liang/data/Salary.txt");
            Scanner input = new Scanner(url.openStream());
            while (input.hasNextLine()) {
                Rank rank;
                String firstname = input.next();
                String lastname = input.next();
                switch (input.next()) {
                    case "assistant":
                        rank = Rank.assistant;
                        break;
                    case "full":
                        rank = Rank.full;
                        break;
                    case "associate":
                        rank = Rank.associate;
                        break;
                    default: 
                        rank = Rank.assistant;
                        break;
                };

                float salary = Float.parseFloat(input.next());
                member member = new member(firstname, lastname, salary, rank);
                members.add(member);
            }
            float[] total;
            int[] average = new int[4];
            total = new float[4];

            for (member member : members) {
                if (member.getRank().equals(Rank.assistant)) {
                    total[0] += member.getSalary();
                    average[0]++;
                } else if (member.getRank().equals(Rank.full)) {
                    total[1] += member.getSalary();
                    average[1]++;
                } else if (member.getRank().equals(Rank.associate)) {
                    total[2] += member.getSalary();
                    average[2]++;
                }
                total[3] += member.getSalary();
                average[3]++;
            }
            System.out.println("total salary:");
            System.out.println("assistant\tassociate\tfull\t\tall");
            System.out.println((int) total[0] + "\t"
                    + (int) total[1] + "\t"
                    + (int) total[2] + "\t"
                    + (int) total[3]);

            System.out.println("average salary:");
            System.out.println("assistant\tassociate\tfull\t\tall");
            System.out.println((total[0]) / average[0] + "\t"
                    + total[1] / average[1] + "\t"
                    + total[2] / average[2] + "\t"
                    + total[3] / average[3]);
        } catch (MalformedURLException ex) {
            Logger.getLogger(PO1.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("error url");
        } catch (IOException ex) {
            Logger.getLogger(PO1.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("error input output");
        }
    }
}
