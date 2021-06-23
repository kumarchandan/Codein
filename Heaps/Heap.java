package Heaps;

import java.util.Arrays;

/**
 * Heaps can be implemented using Arrays. The contents of a heap with n nodes are stored in such a way 
 * that all the parent nodes occur in the first half of array (n/2), while the leaves are present at the 
 * last n/2 positions. So the last parent will be at the n/2th position.
 * 
 * The node at the kth position will have its children placed as follows:
 * The Left child at 2k+1
 * The Right child at 2k+2
 */
class Heap {
    
    /**
     * This function takes the node value and compares it with the key at the parent node,
     * and swaps them if the condition below stands true.
     * ChildNode >= ParentNode
     */
	private void maxHeapify(int[] heapArray, int index, int heapSize) {
		int largest = index;

        /**
         * while loop makes sure that the nodes keep swapping until the Heap property is satisfied, 
         * so we basically call MaxHeapify(); at each small level to achieve Max Heap.
         */
		while (largest < heapSize / 2) {      // check parent nodes only     
			int left = (2 * index) + 1;       // left child
			int right = (2 * index) + 2;      // right child
      
			if (left < heapSize && heapArray[left] > heapArray[index]) {
				largest = left; 			
      		}
			if (right < heapSize && heapArray[right] > heapArray[largest]) {
				largest = right;
			}
			if (largest != index){ // swap parent with largest child 
				int temp = heapArray[index];
				heapArray[index] = heapArray[largest];
				heapArray[largest] = temp;
				index = largest;
			} else {
                break; // if heap property is satisfied 
            }
		} //end of while
	}

    /**
     * It takes the array and starts from the last child node at the last level,
     * then passes it to MaxHeapify for comparison.
     */
	public void buildMaxHeap(int[] heapArray, int heapSize) {
   	    // swap largest child to parent node 
		for (int i = (heapSize - 1) / 2; i >= 0; i--){
			maxHeapify(heapArray, i, heapSize);
		}
	}

	/**
	 * This functions takes the node value and compares it with the key at the parent node, 
	 * and swaps them if the child node < the parent node.
	 */
	private void minHeapify(int[] heapArray, int index, int heapSize) {
		int smallest = index;

		/**
		 * while loop makes sure that the nodes keep swapping until we reach the last index and 
		 * Heap property is satisfied throughout the Heap!
		 */
		while (smallest < heapSize / 2) { // check parent nodes only
			int left = (2 * index) + 1; // left child
			int right = (2 * index) + 2; // right child
			if (left < heapSize && heapArray[left] < heapArray[index]) {
				smallest = left;
			}

			if (right < heapSize && heapArray[right] < heapArray[smallest]) {
				smallest = right;
			}

			if (smallest != index) { // swap parent with smallest child
				int temp = heapArray[index];
				heapArray[index] = heapArray[smallest];
				heapArray[smallest] = temp;
				index = smallest;
			} else {
				break; // if heap property is satisfied
			}

		} //end of while
	}
	
	/**
	 * It takes the array and starts from the last child node (at the last level), 
	 * then passes it to MinHeapify for comparison.
	 */
	public void buildMinHeap(int[] heapArray, int heapSize) {
    
		// swap smallest child to parent node 
		for (int i = (heapSize - 1) / 2; i >= 0; i--) {
			minHeapify(heapArray, i, heapSize);
		}
	}
	
	public static void main(String[] args) {
		int[] heapArray = { 1, 4, 7, 12, 15, 14, 9, 2, 3, 16 };
		
		System.out.println("Before heapify: " + Arrays.toString(heapArray));		
		new Heap().buildMaxHeap(heapArray, heapArray.length);
		System.out.println("After heapify: " + Arrays.toString(heapArray)); // [16, 15, 14, 12, 4, 7, 9, 2, 3, 1]

		int[] heapArray2 = { 31, 11, 7, 12, 15, 14, 9, 2, 3, 16 };
		
		System.out.println("Before heapify: "+Arrays.toString(heapArray2));	
		new Heap().buildMinHeap(heapArray2, heapArray2.length);
		System.out.println("After heapify: "+Arrays.toString(heapArray2)); // [2, 3, 7, 11, 15, 14, 9, 12, 31, 16]
	}
}
