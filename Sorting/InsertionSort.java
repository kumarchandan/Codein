package Sorting;

/**
 * Runtime:
 * Worst case O(n^2)
 * Average case O(n^2)
 * Best case O(n) - while loop will never run if list is already sorted, so O(n)
 */
class InsertionSort {
  
    static void insertionSort(int[] input) {
        for (int i = 0; i < input.length; i++) {
            int key = input[i];
            int j = i - 1;
            // Now compare the key (current idx) with rest, staring from left of current index till beginning
            // If find elemetns larger than key, keep swapping until 
            // either j reaches beginning or no more larger elems than key
            while (j >= 0 && input[j] > key) {
                if(input[j] > key){
                    int tmp = input[j];
                    input[j] = key;
                    input[j + 1] = tmp;
                    j--;
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
  
    public static void main( String args[] ) {
        int[] input = new int[] {7, 6, 5, 4, 3, 2, 1};
        insertionSort(input);
        printArray(input);
    }
}