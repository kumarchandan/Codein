package HashTables;

import java.util.ArrayList;

public class HashTable {
    private ArrayList<HashEntry> bucket;
    private int slots;
    private int size;

    public HashTable() {
        bucket = new ArrayList<HashEntry>();
        slots = 10;
        size = 0;

        // Initialize buckets
        for (int i = 0; i < slots; i++) {
            bucket.add(null);
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int getIndex(String key) {
        // Hashcode is a built-in function of String
        int hashCode = key.hashCode();
        int index = hashCode % slots;

        // If index is negative, add slots to get a postive number
        if (index < 0) {
            index = (index + slots) % slots;
        }
        return index;
    }

    // Inserts a key value pair into table
	public void insert(String key, int value) {
        // Find head of the chain 
        int b_Index = getIndex(key);
        HashEntry head = bucket.get(b_Index);

        // Checks if the key is already exists 
        while(head != null)
        {
            if (head.key.equals(key))
            {
                head.value = value;
                return;
            }
            head = head.next;
        }

        // Inserts key in the chain
        size++;
        head = bucket.get(b_Index);
        HashEntry new_slot = new HashEntry(key, value);
        new_slot.next = head;
        bucket.set(b_Index, new_slot);

        
        // Checks if array >60% of the array gets filled
        if ((1.0*size)/slots >= 0.6)
        {
            ArrayList<HashEntry> temp = bucket;
            bucket = new ArrayList();
            slots = 2 * slots;
            size = 0;
            for (int i = 0; i < slots; i++)
                bucket.add(null);

            for (HashEntry head_Node : temp)
            {
                while (head_Node != null)
                {
                    insert(head_Node.key, head_Node.value);
                    head_Node = head_Node.next;
                }
            }
        }
    }

    // Return a value for a given key
    public int getValue(String key) {
        // Find the head of chain 
        int b_Index = getIndex(key);
        HashEntry head = bucket.get(b_Index);

        // Search key in the slots
        while (head != null)
        {
            if (head.key.equals(key))
                return head.value;
            head = head.next;
        }

        // If key not found
        return -1;
    }

    //Remove a value based with key
    public int delete(String key) {
        //Find index 
        int b_Index = getIndex(key);

        // Get head of the chain for that index
        HashEntry head = bucket.get(b_Index);

        //Find the key in slots
        HashEntry prev = null;
        while (head != null)
        {
            //If key exists
            if (head.key.equals(key))
                break;

            // Else keep moving in chain
            prev = head;
            head = head.next;
        }

        // If key does not exist
        if (head == null)
            return -1;

        // Decrease the size by one
        size--;

        // Remove key
        if (prev != null)
            prev.next = head.next;
        else
            bucket.set(b_Index, head.next);

        return head.value;
    }



}
