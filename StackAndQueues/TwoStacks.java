package StackAndQueues;

/**
 * Can you implement two stacks using a single array?
 * Methods:
 * void push1(V value): pushes value to stack1
 * void push2(V value): pushes value to stack2
 * public V pop1(): pops value from stack1
 * public V pop2(): Pops value from stack2
 * 
 * Approaches:
 * We can either divide array in two halves or start stacks at extreme ends.
 * We'll use the second technique to solve this problem.
 * Top of Stack 1 start from extreme left of array i.e top1 = 0;
 * Top of Stack 2 start from extreme right of array i.e top2 = size - 1
 */
/**
 * Runtime: Constant O(1): As array is indexed, so array operations take constant time and also array doesn't resize
 * Memory: O(n) : Size of array
 */
public class TwoStacks<V> {
    private int maxSize;
    private V[] arr;
    private int top1;
    private int top2;

    @SuppressWarnings("unchecked")
    public TwoStacks(int maxSize) {
        this.maxSize = maxSize;
        arr = (V[]) new Object[maxSize]; // typecasting object[] to V[]
        top1 = -1; // from one end of arr
        top2 = maxSize; // from other end
    }
    
    public void push1(V value) {
        if (top1 < top2 - 1) {
            arr[++top1] = value;
        }
    }

    public void push2(V value) {
        if (top1 < top2 - 1) {
            arr[--top2] = value;
        }
    }

    public V pop1() {
        if (top1 > -1) {
            return arr[top1--];
        }
        return null;
    }

    public V pop2() {
        if (top2 < maxSize) {
            return arr[top2++];
        }
        return null;
    }

    public static void main(String[] args) {
        TwoStacks<String> stacks = new TwoStacks<String>(5);
        stacks.push1("London");
        stacks.push1("Mumbai");
        stacks.push2("Hudson Valley");
        stacks.push2("Berlin");
        stacks.push2("Leh");
        stacks.push2("Kashmir");

        System.out.println(stacks.pop1());
        System.out.println(stacks.pop1());
        System.out.println(stacks.pop2());
        System.out.println(stacks.pop2());
        System.out.println(stacks.pop2());
        System.out.println(stacks.pop2());
    }
}
