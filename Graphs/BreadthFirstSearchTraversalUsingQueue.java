package Graphs;
import StackAndQueues.Queue;

/**
 * Runtime: O(V + E) : Algorithm traverses the whole graph once
 */
class BreadthFirstSearchTraversalUsingQueue {

    public static String bfs(Graph g){
        String result = "";
        // Check if graph has no vertices
        if (g.vertices < 1) {
            return result;
        }

        // Boolean array to hold the history of visited nodes
        boolean[] visited = new boolean[g.vertices];

        for (int i = 0; i < g.vertices; i++) {
            // Check whether the node is visited or not
            if (!visited[i]) {
                result += bfsVisit(g, i, visited);
            }
        }
        return result;
    }

    public static String bfsVisit(Graph g, int sourceValue, boolean[] visited) {
        String result = "";

        // Create Queue for Breadth first traversal and to enqueue sourceValue in it
        Queue<Integer> queue = new Queue<Integer>(g.vertices);
        // enqueue this sourceValue and mark it visited
        queue.enqueue(sourceValue);
        visited[sourceValue] = true;

        // Traverse while queue is not empty, dequeue elements will be added to 'result'
        while (!queue.isEmpty()) {
            // Dequeue a vertex/node from queue and add it to result
            int currentNode = queue.dequeue();
            result += currentNode;

            // Get adjacent vertices to the currentNode from the array, and
            // if they are not visited, enqueue them
            DoublyLinkedList<Integer>.Node temp = null;
            if (g.adjacencyList[currentNode] != null) {
                temp = g.adjacencyList[currentNode].headNode;
            }
            
            // MAIN LOGIC of BFS, enqueue and mark visited all nextNodes of source vertex first
            // e.g. With source -> 0, 1 and 4 will be visited first, then move to next source in adjacency list
            while (temp != null) {
                if (!visited[temp.data]) {
                    queue.enqueue(temp.data);
                    visited[temp.data] = true; // visited the current node
                }
                temp = temp.nextNode;
            }
        }
        return result;
    }
    public static void main(String args[]) {
        Graph g = new Graph(5);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,3);
        g.addEdge(1,4);
        System.out.println("Graph1:");
        g.printGraph();
        System.out.println("BFS traversal of Graph1 : " + bfs(g));
        System.out.println();

        Graph g2 = new Graph(5);
        g2.addEdge(0,1);
        g2.addEdge(0,4);
        g2.addEdge(1,2);
        g2.addEdge(3,4);
        System.out.println("Graph2:");
        g2.printGraph();
        System.out.println("BFS traversal of Graph2 : " + bfs(g2));
  }
}