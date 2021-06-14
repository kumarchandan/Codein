package LinkedList;

public class Stack<V> {
    private int maxSize;
    private V[] arr;
    private int top;

    /*
    Java does not allow generic type arrays. So we have used an 
    array of Object type and type-casted it to the generic type V.
    This type-casting is unsafe and produces a warning.
    Comment out the line below and execute again to see the warning.
    */
    @SuppressWarnings("unchecked")
    public Stack(int max_size) {
        maxSize = max_size;
        top = -1; // Intially when stack is empty
        arr = (V[]) new Object[max_size];
    }

    public int getCapacity() {
        return maxSize;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public V top() {
        if (isEmpty()) {
            return null;
        }
        return arr[top];
    }

    public void push(V value) {
        if (isFull()) {
            System.out.println("Stack is full!");
            return;
        }
        arr[++top] = value;
    }

    public V pop() {
        if(isEmpty()) {
            System.out.println("Stack is empty!");
            return null;
        }
        return arr[top--]; // Only move the pointer below, No need to delete data
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>(5);
        System.out.println("Is stack full? " + stack.isFull());
        System.out.println("Is stack empty? " + stack.isEmpty());

        System.out.print("Elements pushed in the Stack: ");
        for (int i = 0; i < 5; i++) {
            stack.push(i); //pushes 5 elements (0-4 inclusive) to the stack
            System.out.print(i + " ");
        }
        System.out.println("\nIs Stack full? \n" + stack.isFull());
        System.out.print("Elements popped from the Stack: ");
        for (int i = 0; i < 5; i++) {
            System.out.print(stack.pop()+" "); //pops all 5 elements from the stack and prints them
        }
        System.out.println("\nIs Stack empty? \n" + stack.isEmpty());
    }
}
