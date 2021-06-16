package Graphs;

public class DetectCycleInGraph {
    public static boolean detectCycle(Graph g) {
        int numOfVertices = g.vertices;

        // To hold the history of visited nodes
        boolean[] visited = new boolean[numOfVertices];
        // holds a flag if node is currently in Stack or not
        boolean[] stackFlag = new boolean[numOfVertices];

        for (int i = 0; i < numOfVertices; i++) {
            if (cyclic(g, i, visited, stackFlag)) {
                return true;
            }
        }
        return false;
    }

    public static boolean cyclic(Graph g, int v, boolean[] visited, boolean[] stackFlag) {
        // If node is already in stack, cycle is found
        if(stackFlag[v]) {
            return true;
        }

        //if it is already visited (and not in Stack) then there is no cycle
        if (visited[v]) {
            return false;
        }

        visited[v] = true;
        stackFlag[v] = true;

        // check adjacency list of the node
        DoublyLinkedList<Integer>.Node temp = null;
        if (g.adjacencyList[v] != null)
            temp = g.adjacencyList[v].headNode;

        while (temp != null) {
            //run cyclic function recursively on each outgowing path
            if(cyclic(g, temp.data, visited, stackFlag)){
                return true;
            }
            temp = temp.nextNode;
        }
        stackFlag[v] = false;

        return false;
    }

    public static void main(String args[]) {
        Graph g1 = new Graph(4);
        g1.addEdge(0,1);
        g1.addEdge(1,2);
        g1.addEdge(1,3);
        g1.addEdge(3,0);
        g1.printGraph();
        System.out.println(detectCycle(g1));

        System.out.println();
        Graph g2 = new Graph(3);
        g2.addEdge(0,1);
        g2.addEdge(1,2);
        g2.printGraph();
        System.out.println(detectCycle(g2));
  }
}
