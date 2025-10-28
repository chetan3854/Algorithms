import java.util.ArrayList;

public class Graph {
    public static void main(String[] args) {
        //Graph Implementation . We will be using the Adjacency Lists to represent a graph (undirected).
        // For the sake of implementation lets just  assume that the graph has a 0 based indexing

        int n = 3; // nodes
        int m = 3; // edges

        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(); //adjacency list
        //we add n+1 Indexes inside the ArrayList<ArrayList>
        for(int i = 0 ; i<= n ; i++){
            adj.add(new ArrayList<Integer>());
        }

        //edge 1--2
        adj.get(1).add(2);
        adj.get(2).add(1); // we are going to skip this step if it's a directed graph.

        //edge 2--3
        adj.get(2).add(3);
        adj.get(3).add(2);

        //edge 1--3
        adj.get(1).add(3);
        adj.get(3).add(1);

        //traverse..
        for(int i = 1 ; i<=n;i++){
            for(int j = 0; j<adj.get(i).size();j++){
                System.out.print(adj.get(i).get(j) + " ");
            }
            System.out.println();
        }

    }
}
