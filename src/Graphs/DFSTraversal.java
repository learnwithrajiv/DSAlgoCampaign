package Graphs;

import java.util.Iterator;
import java.util.LinkedList;

public class DFSTraversal {
    private int V;
    private LinkedList<Integer> adj[];

    DFSTraversal (int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge (int v, int w) {
        adj[v].add(w);
    }

    private void DFSUtil (int sourceVertex, boolean[] visited) {
        visited[sourceVertex] = true;
        System.out.print(sourceVertex + " ");

        Iterator<Integer> it = adj[sourceVertex].listIterator();
        while (it.hasNext()) {
            int i = it.next();
            if (!visited[i]) {
                DFSUtil(i, visited);
            }
        }
    }

    void DFS (int sourceVertex) {
        boolean[] visited = new boolean[V];
        DFSUtil (sourceVertex, visited);
    }

    public static void main(String args[]) {
        DFSTraversal g = new DFSTraversal (4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 2)");

        g.DFS(2);
    }
}
