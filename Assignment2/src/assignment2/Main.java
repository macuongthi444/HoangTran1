/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

/**
 *
 * @author hoang
 */

import java.util.*;

class Edge implements Comparable<Edge> {
    int src, dest, weight;

    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
        return this.weight - other.weight;
    }
}

class MinimumSpanningTree {
    private int V;
    List<Edge> edges;

    public MinimumSpanningTree(int V) {
        this.V = V;
        edges = new ArrayList<>();
    }

    public void addEdge(int src, int dest, int weight) {
        Edge edge = new Edge(src, dest, weight);
        edges.add(edge);
    }

    static private int findParent(int[] parent, int node) {
        if (parent[node] != node) {
            parent[node] = findParent(parent, parent[node]);
        }
        return parent[node];
    }

    static private void union(int[] parent, int x, int y) {
        int xParent = findParent(parent, x);
        int yParent = findParent(parent, y);
        parent[xParent] = yParent;
    }

    public List<Edge> kruskalMST() {
        Collections.sort(edges);

        List<Edge> mst = new ArrayList<>();
        int[] parent = new int[V];
        for (int i = 0; i < V; i++) {
            parent[i] = i;
        }

        for (Edge edge : edges) {
            int srcParent = findParent(parent, edge.src);
            int destParent = findParent(parent, edge.dest);

            if (srcParent != destParent) {
                mst.add(edge);
                union(parent, srcParent, destParent);
            }
        }
        return mst;
    }

    public static List<Edge> parallelKruskalMST(int numThreads, int V, List<Edge> edges) {
        Collections.sort(edges);
        List<Edge> mst = new ArrayList<>();
        int[] parent = new int[V];
        for (int i = 0; i < V; i++) {
            parent[i] = i;
        }

        int batchSize = (int) Math.ceil((double) edges.size() / numThreads);
        List<List<Edge>> threadEdges = new ArrayList<>();

        for (int i = 0; i < numThreads; i++) {
            int start = i * batchSize;
            int end = Math.min((i + 1) * batchSize, edges.size());
            threadEdges.add(edges.subList(start, end));
        }

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < numThreads; i++) {
            final int threadId = i;
            Thread thread = new Thread(() -> {
                for (Edge edge : threadEdges.get(threadId)) {
                    int srcParent = findParent(parent, edge.src);
                    int destParent = findParent(parent, edge.dest);

                    if (srcParent != destParent) {
                        synchronized (mst) {
                            mst.add(edge);
                        }
                        union(parent, srcParent, destParent);
                    }
                }
            });
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return mst;
    }
}

public class Main {
    public static void main(String[] args) {
        int V = 6; // Số lượng đỉnh trong đồ thị
        int numThreads = 4; // Số luồng song song

        MinimumSpanningTree mst = new MinimumSpanningTree(V);

        // Thêm các cạnh vào đồ thị
        mst.addEdge(0, 1, 4);
        mst.addEdge(0, 2, 3);
        mst.addEdge(1, 2, 1);
        mst.addEdge(1, 3, 2);
        mst.addEdge(2, 3, 4);
        mst.addEdge(3, 4, 2);
        mst.addEdge(4, 5, 6);

        // Tìm MST bằng thuật toán Kruskal thông thường
        List<Edge> minimumSpanningTree = mst.kruskalMST();

        System.out.println("MST thông thường:");
        for (Edge edge : minimumSpanningTree) {
            System.out.println(edge.src + " - " + edge.dest + " : " + edge.weight);
        }

        // Tìm MST bằng thuật toán Kruskal song song
        List<Edge> parallelMinimumSpanningTree = mst.parallelKruskalMST(numThreads, V, mst.edges);

        System.out.println("\nMST song song:");
        for (Edge edge : parallelMinimumSpanningTree) {
            System.out.println(edge.src + " - " + edge.dest + " : " + edge.weight);
        }
    }
}

//import java.util.*;
//
//class Edge implements Comparable<Edge> {
//    int src, dest, weight;
//
//    public Edge(int src, int dest, int weight) {
//        this.src = src;
//        this.dest = dest;
//        this.weight = weight;
//    }
//
//    @Override
//    public int compareTo(Edge other) {
//        return this.weight - other.weight;
//    }
//}
//
//class MinimumSpanningTree {
//    private int V;
//    private List<Edge> edges;
//
//    public MinimumSpanningTree(int V) {
//        this.V = V;
//        edges = new ArrayList<>();
//    }
//
//    public void addEdge(int src, int dest, int weight) {
//        Edge edge = new Edge(src, dest, weight);
//        edges.add(edge);
//    }
//
//    private int findParent(int[] parent, int node) {
//        if (parent[node] != node) {
//            parent[node] = findParent(parent, parent[node]);
//        }
//        return parent[node];
//    }
//
//    private void union(int[] parent, int x, int y) {
//        int xParent = findParent(parent, x);
//        int yParent = findParent(parent, y);
//        parent[xParent] = yParent;
//    }
//
//    public List<Edge> kruskalMST() {
//        Collections.sort(edges);
//
//        List<Edge> mst = new ArrayList<>();
//        int[] parent = new int[V];
//        for (int i = 0; i < V; i++) {
//            parent[i] = i;
//        }
//
//        for (Edge edge : edges) {
//            int srcParent = findParent(parent, edge.src);
//            int destParent = findParent(parent, edge.dest);
//
//            if (srcParent != destParent) {
//                mst.add(edge);
//                union(parent, srcParent, destParent);
//            }
//        }
//        return mst;
//    }
//}
//
//public class Main {
//    public static void main(String[] args) {
//        int V = 6; // Số lượng đỉnh trong mạng
//
//        MinimumSpanningTree mst = new MinimumSpanningTree(V);
//
//        // Thêm các kết nối vào mạng
//        mst.addEdge(0, 1, 4);
//        mst.addEdge(0, 2, 3);
//        mst.addEdge(1, 2, 1);
//        mst.addEdge(1, 3, 2);
//        mst.addEdge(2, 3, 4);
//        mst.addEdge(3, 4, 2);
//        mst.addEdge(4, 5, 6);
//
//        List<Edge> minimumSpanningTree = mst.kruskalMST();
//
//        System.out.println("Danh sách các kết nối trong mạng:");
//        for (Edge edge : minimumSpanningTree) {
//            System.out.println(edge.src + " - " + edge.dest + " : " + edge.weight);
//        }
//    }
//}