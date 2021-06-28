package CodingPatterns.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of characters where each character represents a fruit tree, 
 * you are given two baskets, and your goal is to put maximum number of fruits in each basket. 
 * The only restriction is that each basket can have only one type of fruit.
 * 
 * Similar Problems: Longest Substring with at most 2 distinct characters
 * 
 * Input: Fruit=['A', 'B', 'C', 'A', 'C']
 * Output: 3
 * Explanation: We can put 2 'C' in one basket and one 'A' in the other from the subarray ['C', 'A', 'C']
 * 
 * # Dry Run
 * hashMap = {A, B, C} -> {B, C} | {B, C, A} -> {C, A} | {C2, A}
 * maxFruit = 2
 * Traverse with windowEnd
 *  put A in hashMap | put A in hashMap | put C in hashMap
 *  put B in hashMap
 *  put C in hashMap -> 3 types of fruit now | 3 types of fruit now
 *  Keep removing from left until fruitType in hashMap <= 2, remove A | remove B
 *  Increment windowStart -> pointing to B now | Increment windowStart -> pointing to C now
 *  Store maxFruit so far -> windowEnd - windowStart + 1, (2 - 1 + 1) = 2 | (3-2+1) = 2 | (4 - 2 + 1) = 3
 * 
 *  
 * 
 * 
 * Input: Fruit=['A', 'B', 'C', 'B', 'B', 'C']
 * Output: 5
 * Explanation: We can put 3 'B' in one basket and two 'C' in the other basket. 
 * This can be done if we start with the second letter: ['B', 'C', 'B', 'B', 'C']
 * 
 */

/**
 * Runtime: O(n)
 * The outer for loop runs for all characters, and the inner while loop processes each character only once;
 * therefore, the time complexity of the algorithm will be O(N+N), which is asymptotically equivalent to O(N).
 * 
 * Memory: O(K)
 * We will be storing a maximum of K+1 characters in the HashMap.
 */
public class FruitsIntoBaskets {
    
    public static int findLength(char[] arr) {
        int maxFruits = 0;
        int windowStart = 0;
        Map<Character, Integer> fruitMap = new HashMap<>();

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            char rightFruit = arr[windowEnd];

            fruitMap.put(rightFruit, fruitMap.getOrDefault(rightFruit, 0) + 1); // Set to 1 or Increment if already exists

            // Check if map has more than 2 types of fruit, if yes, reduce fruits from left and shrink the window
            // until left with 2 fruit types
            while(fruitMap.size() > 2) {
                char leftFruit = arr[windowStart];
                fruitMap.put(leftFruit, fruitMap.get(leftFruit) - 1); // Reduce fruit from left
                // Delete the entry from map if fruit count reaches to 0
                if (fruitMap.get(leftFruit) == 0) {
                    fruitMap.remove(leftFruit);
                }
                windowStart++; // Shrink the window
            }
            // Take a note of max length so far
            maxFruits = Math.max(maxFruits, windowEnd - windowStart + 1);
        }
        return maxFruits;
    }

    public static void main(String[] args) {
        char[] arr = {'A', 'B', 'C', 'A', 'C'};
        char[] arr2 = {'A', 'B', 'C', 'B', 'B', 'C'};
        System.out.println(FruitsIntoBaskets.findLength(arr)); // 3
        System.out.println(FruitsIntoBaskets.findLength(arr2)); // 5
    }
}
