package HashTables;

import java.util.HashSet;

/**
 * Find whether an array is a subset of another array
 * 
 * Can you find whether a given array is a subset of another by using a built-in Hash Table?
 * Implement the isSubset() function to take two arrays as input and check whether an array is a subset of another given array.
 * 
 * Note: Both of these arrays represent sets, therefore, they do not contain duplicate values.
 * 
 * It returns true if arr2 is a subset of arr1, or else it returns false
 * 
 * Input:
 * arr1 = [9,4,7,1,-2,6,5]
 * arr2 = [7,1,-2]
 * 
 * Ouput:
 * true
 * 
 * [7,1,-2] is present in arr1 from index 2 to 4, therefore arr2 is a subset of arr1.
 */
/**
 * Runtime: O(m + n) 
 * For a lookup array with m elements and a subset array with n elements, the time complexity is O(m+n).
 */
public class ArraySubset {
    
    public static boolean isSubset(int[] arr1, int[] arr2) {
        HashSet<Integer> hashSet = new HashSet<>();

        // Store all arr1 elemtns in hashSet
        for (int i = 0; i < arr1.length; i++) {
            if(!hashSet.contains(arr1[i])) {
                hashSet.add(arr1[i]);
            }
        }

        // All arr2 elements should be found in hashSet, otherwise not a subset array
        for (int i = 0; i < arr2.length; i++) {
            if(!hashSet.contains(arr2[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr1 = {9, 4, 7, 1, -2, 6, 5};
        int[] arr2 = {7, 1, -2};
        int[] arr3 = {10, 12};

        System.out.println(isSubset(arr1, arr2)); // true
        System.out.println(isSubset(arr1, arr3)); // false
    }
}
