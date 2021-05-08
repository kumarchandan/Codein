"use strict";
const Graph = require('./Graph.js');

/**
 * For each node, we start a recursive call with detectCycleRec.
 * The function maintains two stacks (not DS one) -> recNodes and visited
 * 
 * recNodes -> The vertices that have been traversed in the current recursion are added to it  and
 * visited -> keeps a record of all the nodes that have been traversed regardless of the recursive call.
 * 
 * For a cycle to occur, we must reach a node that was already present in the recursion stack. 
 * If the recursion ends and no such node is found, the stack is reset again and the next iteration 
 * of detectCycle starts.
 */
/**
 * Runtime Complexity: O(V + E)
 * Space Complexity: O(V) ??
 */

function detectCycleRec(graph, i,visited, recNodes) {
    // Check if current node is being visited in the same recursive call
    if(visited[i] === false) {
        // Set recursive array and visited to true
        visited[i] = true;
        recNodes[i] = true;

        var adjacent;
        let adjacentNode = graph.list[i].getHead();
        while (adjacentNode !== null ) {
            // Access adjacent node and repeat algorithm
            adjacent = adjacentNode.data;
            if ((!visited[adjacent]) && detectCycleRec(graph, adjacent, visited, recNodes)) {
                return true;  // Loop found
            } else if(recNodes[adjacent]) {
                return true;
            }
            adjacentNode = adjacentNode.nextElement;
        }
    }
    recNodes[i] = false;
    return false;
}

function detectCycle(graph) {
    var num_of_vertices = graph.vertices;
    //Boolean Array to hold the history of visited nodes (by default-false)
    //Make a node visited whenever you traverse it
     var visited = [];

    //Boolean array of vertices which will recursively called
     var recNodes = [];

    for(var i = 0; i < num_of_vertices; i++)
    {
        visited[i] = false;
        recNodes[i] = false;
    }

    for (var i = 0; i < num_of_vertices; i++) { // Recursive function called
        if (detectCycleRec(graph, i, visited, recNodes)) {
            return true;
            // If cycle detected, return true
        }
    }
    return false;
}


let graph = new Graph(4);
graph.addEdge(0, 1);
graph.addEdge(0, 3);
graph.addEdge(1, 2);
graph.addEdge(2, 0);

graph.printGraph();

console.log(detectCycle(graph)); // true
