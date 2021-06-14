package LinkedList;

public class Queue<V> {
    private V[] arr;
    private int maxSize;
    private int front;
    private int back;
    private int currentSize;

    @SuppressWarnings("unchecked")
    public Queue(int maxSize) {
        this.maxSize = maxSize;
        arr = (V[]) new Object[maxSize];
        front = 0; // while dequeue, returns the elem first then increment front
        back = -1; // while enqueue, Points at current back value, increment first and then insert the value
        currentSize = 0;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public int getCurrentSize() {
        return currentSize;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public boolean isFull() {
        return currentSize == maxSize;
    }

    public void enqueue(V value) {
        if (isFull()) {
            return;
        }
        back = (back + 1) % maxSize; // to keep the index in range (in a circular way)
        arr[back] = value;
        currentSize++;
    }

    public V dequeue() {
        if(isEmpty()) {
            return null;
        }
        
        V temp =  arr[front];
        front = (front + 1) % maxSize; // to keep the index in range (in a circular way)
        currentSize--;
        return temp;
    }

    public V top() {
        if(isEmpty()) {
            return null;
        }
        return arr[front];
    }

    public static void main(String[] args) {
        Queue<Integer> q = new Queue<Integer>(5);
        System.out.println("Is queue empty? " + q.isEmpty());

        for (int i = 10; i < 20; i+=2) {
            q.enqueue(i);
        }

        System.out.println("Is queue full? " + q.isFull());
        for (int i = 0; i < 5; i++) {
            q.dequeue();
        }
        System.out.println("Is queue empty again? " + q.isEmpty());
        for (int i = 20; i < 34; i+=2) {
            q.enqueue(i);
        }
    }
}
