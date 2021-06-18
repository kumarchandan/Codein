package HashTables;

import java.util.HashSet;

/**
 * Find Two Numbers that Add up to "n"
 * Given an array and a number "n", find two numbers from the array that sums up to "n".
 * 
 * Input:
 * arr = {1, 21, 3, 14, 5, 60, 7, 6}, value = 27
 *        26, 6, 4, 13, 22, 33, 20, 21
 * Output:
 * arr = {21, 6} or {6, 21}
 */
/**
 * Runtime: O(n) Traverse the array once
 */
public class FindTwoNumbersSumInArray {
    public static int[] findSum(int[] arr, int sum) {
        HashSet<Integer> hashSet = new HashSet<>();
        int[] result = new int[2];

        for (int i = 0; i < arr.length; i++) {
            if (hashSet.contains(arr[i])) { // If arr value matches to one of the difference, we have found a pair
                result[0] = arr[i];
                result[1] = sum - arr[i];
            }
            hashSet.add(sum - arr[i]); // Store sum - arr[i] difference in hashSet
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 27;
        int[] arr1 = {1, 21, 3, 14, 5, 60, 7, 6};
        if(arr1.length > 0){
            int[] arr2 = findSum(arr1, n);
            int num1 = arr2[0];
            int num2 = arr2[1];

            if((num1 + num2) != n)
                System.out.println("Not Found");
            else {
                System.out.println("Number 1 = " + num1);
                System.out.println("Number 2 = " + num2);
                System.out.println("Sum = " +  (n) );

            }
        } else {
            System.out.println("Input Array is Empty!");
        }
    }
}
