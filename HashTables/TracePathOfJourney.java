package HashTables;

import java.util.HashMap;
import java.util.Map;

/**
 * Trace the complete path of a journey
 * 
 * Given a HashMap with all the points,
 * can you find the starting point and print out the complete path from start to end?
 * 
 * Input:
    map = 
    {
        "NewYork" -> "Chicago"
        "Boston" -> "Texas"
        "Missouri" -> "NewYork"
        "Texas" -> "Missouri"
    }
    
    key -> value

 * Output:
 * "Boston->Texas, Texas->Missouri, Missouri->NewYork, NewYork->Chicago, "

 */

/**
 * Runtim: O(n)  where n is number of source-destination pairs
 * 
 * Note: Hashmaps were created and traversed but it takes same constant time
 */
public class TracePathOfJourney {
    
    public static String tracePath(Map<String, String> map) {
        /**
         * Create a reverse Map of given map i.e if given map has (N,C) then reverse map will have (C,N) as key value pair
         * Traverse original map and see if corresponding key exist in reverse Map
         * If it doesn't exist then we found our starting point.
         * After starting point is found, simply trace the complete path from original map.
         */
        String result = "";
        HashMap<String, String> reverseMap = new HashMap<>();

        // To fill the reverse map, iterate through the given map
        for (Map.Entry<String, String> entry: map.entrySet()) {
            reverseMap.put(entry.getValue(), entry.getKey());
        }

        // Find starting point of itinerary
        String from = "";

        // Check if graph is disconnected
        int count = 0;
        for(Map.Entry<String, String> entry: map.entrySet()) {
            if (!reverseMap.containsKey(entry.getKey())) {
                count++;
                from = entry.getKey();
            }
        }

        if (count > 1) {
            return "null"; // Disconnected graph
        }

        // Trace complete path
        String to = map.get(from);

        while(to != null) {
            result += from + " -> " + to + ",";
            from = to;
            to = map.get(to);
        }
        
        return result;
    }

    public static void main(String[] args) {
        HashMap<String,String> hashMap = new HashMap<>();  

        hashMap.put("NewYork","Chicago");
        hashMap.put("Boston","Texas");
        hashMap.put("Missouri","NewYork");
        hashMap.put("Texas","Missouri");

        System.out.println(hashMap.size());

        String actual_output = TracePathOfJourney.tracePath(hashMap);

        System.out.println(actual_output);
    }
}
