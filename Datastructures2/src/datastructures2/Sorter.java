/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Thomas
 */
public class Sorter {

    public static void bubbleSort(List unsortedList, Comparator c) {

        boolean unsorted = true;
        while (unsorted) {
            boolean swapped = false;
            int skipIndex = 0;

            for (int i = 0; i < unsortedList.size() - skipIndex; i++) {
                if (i + 1 == unsortedList.size() - skipIndex) {
                    break;
                }
                if (c.compare(unsortedList.get(i), unsortedList.get(i + 1)) < 0) {
                    swapped = true;
                    Object temp = unsortedList.get(i);
                    unsortedList.set(i, unsortedList.get(i + 1));
                    unsortedList.set(i + 1, temp);
                }
            }

            skipIndex++;
            unsorted = swapped;
        }
    }

    public static ArrayList<Bucket> bucketSortStudents(ArrayList<Student> unsortedList) {
        KlasComparator c = new KlasComparator();
        ArrayList<Bucket> buckets = new ArrayList<>();

        Bucket addedTo;

        for (Student s : unsortedList) {
            addedTo = null;
            for (Bucket b : buckets) {
                int result = c.compare(s.getKlas(), b.getKlas());
                if (result == 0) {
                    b.addStudent(s);
                    addedTo = b;
                    break;
                }
            }

            if (addedTo == null) {
                Bucket newBucket = new Bucket();
                newBucket.setKlas(s.getKlas());
                newBucket.addStudent(s);
                if (buckets.isEmpty()) {
                    buckets.add(newBucket);
                } else {
                    int iterator = 0;
                    boolean added = false;
                    for (Bucket bucket : buckets) {
                        if (c.compare(bucket.getKlas(), newBucket.getKlas()) > 0) {
                            buckets.add(iterator, newBucket);
                            added = true;
                            break;
                        }
                        iterator++;
                    }
                    if (!added) {
                        buckets.add(iterator, newBucket);
                    }
                }

            }
        }

        return buckets;
    }
}
