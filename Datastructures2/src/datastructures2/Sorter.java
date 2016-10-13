/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures2;

/**
 *
 * @author Thomas
 */
public class Sorter {
    //public static Comparable[] bubbleSort(List<T> unsortedList, Comparator c)
    public static Comparable[] bubbleSort(Comparable[] unsortedList) {
        
        boolean unsorted = true;
        while (unsorted) {
            boolean swapped = false;
            int skipIndex = 0;
            
            for (int i = 0; i < unsortedList.length - skipIndex; i++) {
                if (i + 1 == unsortedList.length - skipIndex) {
                    break;
                }
                
                if (unsortedList[i].compareTo(unsortedList[i + 1]) < 0) {
                    swapped = true;
                    Comparable temp = unsortedList[i];
                    unsortedList[i] = unsortedList[i + 1];
                    unsortedList[i + 1] = temp;
                }
            }
            
            skipIndex++;
            unsorted = swapped;
        }
        
        return unsortedList;
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
