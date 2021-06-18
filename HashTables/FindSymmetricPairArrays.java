package HashTables;

import java.util.HashMap;

/**
 * Find symmetric pairs in an Array
 * 
 * If you are given a two-dimensional array, can you find a symmetric pair in that array? 
 * 
 * By definition, (a,b) and (c,d) are symmetric pairs 
 * if a = d and b = c
 * 
 * Input:
 * arr[][] = [{1, 2}, {3, 4}, {5, 9}, {4, 3}, {9, 5}]
 * 
 * Output:
 * "{3,4}{5,9}"
 * 
 * Explanation:
 * {3 , 4} has a symmetrical pair to { 4 , 3 } in the given array,
 * Similarly, { 5 , 9 } has a symmetrical pair to { 9 , 5 }.
 */

 /**
  * Runtime: O(n)
  * The hash table lookups work in constant time. Traversal of the input list makes the algorithm run in O(n), where n is the array size.
  */

public class FindSymmetricPairArrays {
    
    public static String findSymmetric(int[][] arr) {
        /**
         * Create an empty Hash Map
         * Traverse given Array
         * Look for second element of each pair in the hash. i.e for pair (1,2) look for key 2 in map.
         * If found then store it in the result array, otherwise insert the pair in hash
         */
        String result = "";
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();

        for (int i = 0; i < arr.length; i++) {
            int first = arr[i][0];
            int second = arr[i][1];

            Integer value = hashMap.get(second);

            if (value != null && value == first) {
                // Symmetric pair found
                result += "{" + String.valueOf(second) + "," + String.valueOf(first) + "}";
            } else {
                hashMap.put(first, second);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2}, {3, 4}, {5, 9}, {4, 3}, {9, 5}};
        String symmetric = findSymmetric(arr);
        System.out.println(symmetric); // {3,4}{5,9}
    }
}
