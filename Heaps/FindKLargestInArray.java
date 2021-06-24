package Heaps;

/**
 * Find the k Largest Elements in an Array
 * 
 * If you are given an array and any number "k",
 * can you write a code to find the "k" largest elements using a Max Heap?
 * 
 * Input:
 * arr = [9,4,7,1,-2,6,5]        
 * k = 3
 * 
 * Output:
 * [-2,1,4]
 */
/**
 * Runtime:
 * The time complexity of building a heap is O(n).
 * Furthermore, removing the k largest elements takes a time complexity of O(klogn).
 * Therefore, we can say that the total time complexity is O(n+klogn).
 */
public class FindKLargestInArray {
    /**
     * Build maxHeap of the given array. 
     * Extract the minimum element/root and add it to the result
     * Keep removing elements from arr and repeatedly build maxHeap till we reach K.
     */
    public static int[] findKLargest(int[] arr, int k) {
        int arraySize = arr.length;
        Heap oHeap = new Heap();

        if (k <= arraySize) {
            int[] result = new int[k]; 
            for (int i = 0; i < k; i++) {
                result[i] = removeMax(arr, arraySize, oHeap);
                --arraySize;
            }
            return result;
        }
        System.out.println("Value of k = " + k+ "out of bounds!");
        return arr;
    }

    public static int removeMax(int[] heapArray, int heapSize, Heap oHeap) {
        oHeap.buildMaxHeap(heapArray, heapSize);
        // Root of Max-heaps contains the largest elment
        int max = heapArray[0];

        // Put last element to replace the root value (Works like, Popping root out of MaxHeap)
        // and later reducing the array size while building maxHeap again will ignore the last element
        // which is copied to root now 
        // e.g. [9, 4, 7, 1, -2, 6, 5] -> [5, 4, 7, 1, -2, 6, 5], and build maxHeap again with [5, 4, 7, 1, -2, 6]
        heapArray[0] =  heapArray[heapSize - 1];
        return max;
    }

    public static void main(String args[]) {
        int[] input = {9, 4, 7, 1, -2, 6, 5};
        int[] output = findKLargest(input, 3); // 9, 7, 6
    
        for(int i = 0; i < output.length; i++) {
            System.out.print(output[i] + ", ");
        }
    }
}

