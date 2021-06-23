package Heaps;

/**
 * Find the k Smallest Elements in an Array
 * 
 * If you are given an array and any number "k",
 * can you write a code to find the "k" smallest elements using a Min Heap?
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
 * Furthermore, removing the k smallest elements takes a time complexity of O(klogn).
 * Therefore, we can say that the total time complexity is O(n+klogn).
 */
public class FindKSmallestInArray {
    /**
     * Build minHeap of the given array. 
     * Extract the minimum element/root and add it to the result
     * Keep removing elements from arr and repeatedly build minHeap till we reach K.
     */
    public static int[] findKSmallest(int[] arr, int k) {
        int arraySize = arr.length;
        Heap oHeap = new Heap();

        if (k <= arraySize) {
            int[] result = new int[k]; 
            for (int i = 0; i < k; i++) {
                result[i] = removeMin(arr, arraySize, oHeap);
                --arraySize;
            }
            return result;
        }
        System.out.println("Value of k = " + k+ "out of bounds!");
        return arr;
    }

    public static int removeMin(int[] heapArray, int heapSize, Heap oHeap) {
        oHeap.buildMinHeap(heapArray, heapSize);
        // Root of Min-heaps contains the smallest elment
        int min = heapArray[0];

        // Put last element to replace the root value (Works like, Popping root out of MinHeap)
        // and later reducing the array size while building minHeap again will ignore the last element
        // which is copied to root now 
        // e.g. [-2, 1, 5, 9, 4, 6, 7] -> [7, 1, 5, 9, 4, 6, 7], and build minHeap again with [7, 1, 5, 9, 4, 6]
        heapArray[0] =  heapArray[heapSize - 1];
        return min;
    }

    public static void main(String args[]) {
        int[] input = {9, 4, 7, 1, -2, 6, 5};
        int[] output = findKSmallest(input, 3); // -2, 1, 4
    
        for(int i = 0; i < output.length; i++) {
            System.out.print(output[i] + ", ");
        }
    }
}
