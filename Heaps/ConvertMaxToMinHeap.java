package Heaps;
/**
 * Convert a Binary Min Heap into a Binary Max Heap.
 * 
 * Input: [9,4,7,1,-2,6,5]
 * Output: [-2,1,5,9,4,6,7]
 */
public class ConvertMaxToMinHeap {
    
    public static void convertMaxToMin(int[] maxHeap) {
        // Consider maxHeap just an ordinary unsorted array 
        // Build minHeap of the given array (Already coded before, reuse it)
        Heap oHeap = new Heap();
        oHeap.buildMinHeap(maxHeap, maxHeap.length);
    }

    public static void main(String[] args) {
        int[] arr = { 9,4,7,1,-2,6,5 };
        System.out.println("MaxHeap: "); // [9,4,7,1,-2,6,5]
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
        ConvertMaxToMinHeap.convertMaxToMin(arr); // [-2, 1, 5, 9, 4, 6, 7]
        System.out.println("\nConverted to MinHeap: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }

        // [16,15,14,12,4,7,9,2,3,1] -> [1, 2, 7, 3, 4, 14, 9, 12, 16, 15]
    }
}
