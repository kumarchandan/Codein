package HashTables;

import java.util.HashSet;
/**
 * Check if the given arrays are disjoint
 * If you are given two arrays, arr1 and arr2, can you check if these arrays are disjoint? 
 * 
 * Input:
 * arr1 = [9,4,3,1,-2,6,5]
 * arr2 = [7,10,8]
 * 
 * Output:
 * true
 * 
 * No common elemnts between arrays
 * 
 */
/**
 * Runtime: O(m + n) 
 * For a lookup array with m elements and a subset array with n elements, the time complexity is O(m+n).
 */
public class CheckArraysDisjoint {
    
    public static Object isDisjoint(int[] arr1, int[] arr2) {
        HashSet<Integer> hashSet = new HashSet<>();
        boolean disjoint = true;

        // Store all arr1 elemtns in hashSet
        for (int i = 0; i < arr1.length; i++) {
            if(!hashSet.contains(arr1[i])) {
                hashSet.add(arr1[i]);
            }
        }

        // All arr2 elements should be found in hashSet, otherwise not a subset array
        for (int i = 0; i < arr2.length; i++) {
            if(hashSet.contains(arr2[i])) {
                disjoint = false;
            }
        }
        return disjoint;
    }

    public static void main(String[] args) {
        int[] arr1 = {9, 4, 3, 1, -2, 6, 5};
        int[] arr2 = {7, 10, 8};
        int[] arr3 = {1, 12};
        System.out.println(isDisjoint(arr1, arr2)); // true
        System.out.println(isDisjoint(arr1, arr3)); // false
    }
}
