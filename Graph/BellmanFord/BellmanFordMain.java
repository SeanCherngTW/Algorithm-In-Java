import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Map;
import java.util.Iterator;

class BellmanFordMain {

    static int N;
    static int[] distance;
    static int[] predecessor;
    static HashMap<Integer, LinkedList<Node>> graph;

    public static void main(String[] args) {

        readInput();

        int from, to, weight;
        Node toNode;
        LinkedList<Node> adjacentNodes;
        Iterator iter;

        for (int i = 0; i < N - 1; i++)
            for (int j = 0; j < N; j++) {
                from = j;
                adjacentNodes = graph.get(j);
                iter = adjacentNodes.iterator();
                while (iter.hasNext()) {
                    toNode = (Node) iter.next();
                    to = (Integer) toNode.getIdx();
                    weight = (Integer) toNode.getDis();
                    if (distance[from] != Integer.MAX_VALUE && distance[to] > distance[from] + weight) {
                        distance[to] = distance[from] + weight;
                        predecessor[to] = from;
                    }
                }
            }

        printResult();
        System.out.println("Negetive Cycle ? " + hasNegativeCycle());

    }

    private static void readInput() {
        Scanner sc = new Scanner(System.in);
        int from, to, weight;

        System.out.print("# Vertices: ");
        N = sc.nextInt();
        distance = new int[N];
        predecessor = new int[N];
        for (int i = 0; i < N; i++) {
            predecessor[i] = -1;
            distance[i] = Integer.MAX_VALUE;
        }
        distance[0] = 0;

        graph = new HashMap<Integer, LinkedList<Node>>();

        System.out.println("Enter edges <from> <to> <weight>: (-1 to stop)");
        while (true) {
            from = sc.nextInt();
            if (from == -1)
                break;
            to = sc.nextInt();
            weight = sc.nextInt();
            addToGraph(from, to, weight);
        }

        sc.close();
    }

    private static void printResult() {
        System.out.print("Print predecessor: ");
        for (int i = 0; i < N; i++)
            System.out.printf("%2d ", predecessor[i]);

        System.out.print("\nPrint distance: ");
        for (int i = 0; i < N; i++) {
            if (distance[i] == Integer.MAX_VALUE)
                System.out.printf(" ∞ ");
            else
                System.out.printf("%2d ", distance[i]);
        }
        System.out.println();
    }

    private static void addToGraph(int from, int to, int weight) {
        LinkedList<Node> adjacentNodes = graph.get(from);
        if (adjacentNodes == null) {
            adjacentNodes = new LinkedList<Node>();
            adjacentNodes.add(new Node(to, weight));
            graph.put(from, adjacentNodes);
        } else
            adjacentNodes.add(new Node(to, weight));
    }

    private static boolean hasNegativeCycle() {
        int from, to, weight;
        Node toNode;
        LinkedList<Node> adjacentNodes;
        Iterator iter;

        for (int i = 0; i < N; i++) {
            adjacentNodes = graph.get(i);
            iter = adjacentNodes.iterator();
            from = i;
            while (iter.hasNext()) {
                toNode = (Node) iter.next();
                to = (Integer) toNode.getIdx();
                weight = (Integer) toNode.getDis();
                if (distance[to] > distance[from] + weight)
                    return true;
            }
        }
        return false;
    }
}