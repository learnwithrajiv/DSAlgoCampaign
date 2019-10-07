package Graphs;

import java.util.Iterator;
import java.util.LinkedList;

public class BFSTraversal {
    private int V;
    private LinkedList<Integer> adj[];

    BFSTraversal (int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge (int v, int w) {
        adj[v].add(w);
    }

    public void BFS (int sourceVertex) {
        boolean visited[] = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(sourceVertex);
        visited[sourceVertex] = true;
        while (queue.size() != 0) {
            sourceVertex = queue.poll();
            System.out.print(sourceVertex + " ");
            Iterator<Integer> it = adj[sourceVertex].listIterator();
            while (it.hasNext()) {
                int n = it.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String args[]) {
        BFSTraversal g = new BFSTraversal(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 2)");

        g.BFS(2);
    }
}
