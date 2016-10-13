/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures2;

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
    
    public static Comparable[] selectionSort(Comparable[] unsortedList) {
        
        boolean unsorted = true;
        while (unsorted) {
            boolean swapped = false;
            int skipIndex = 0;
            int biggestIndex = skipIndex;
            
            for (int i = skipIndex; i < unsortedList.length; i++) {
                if (i + 1 == unsortedList.length - skipIndex) {
                    break;
                }
                
                if (unsortedList[i].compareTo(unsortedList[i + 1]) < 0) {
                    biggestIndex = i + 1;
                }
            }
            
            if (biggestIndex != skipIndex) {
                swapped = true;
                Comparable temp = unsortedList[skipIndex];
                unsortedList[skipIndex] = unsortedList[biggestIndex];
                unsortedList[biggestIndex] = temp;
            }
            
            skipIndex++;
            unsorted = swapped;
        }
        
        return unsortedList;
    }
}
