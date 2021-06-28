package Sorting;

/**
 * Runtime:
 * Worst case O(n^2)
 * Average case O(n^2)
 * Best case O(n)
 */
public class BubbleSort {
    static void bubbleSort(int arr[], int arrSize) {
        int i, j, temp;
        // Traverse through all array elements
        for (i = 0; i < arrSize - 1; i++) {
            // Last i elements are already in place      
            for (j = 0; j < arrSize - i - 1; j++) {
                // Traverse the array from 0 to size of array[i-1] 
                // Swap if the element found is greater than the next element
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    static void printArray(int[] input) {
        System.out.println();
        for (int i = 0; i < input.length; i++)
            System.out.print(" " + input[i] + " ");
        System.out.println();    
    }

    public static void main(String args[]) {
        int arr[] = {5,4,1,0,5,95,4,-100,200,0};
        int arrSize = 10;
        bubbleSort(arr, arrSize);
        printArray(arr);
    }
}
