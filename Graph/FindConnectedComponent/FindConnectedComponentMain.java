import java.util.Scanner;

class FindConnectedComponentMain {

    static int N;
    static int time = 0;
    static int[] color;
    static int[] discover;
    static int[] finish;
    static int[] predecessor;
    static int[][] graph;

    public static void main(String[] args) {
        readInput();

        // DFS
        for (int i = 0; i < N; i++)
            if (color[i] == 0)
                visit(i);

        printResult();

        for (int i = 0; i < N; i++)
            setCollapsing(i);

        printConnectedComponent();
    }

    private static void readInput() {
        Scanner sc = new Scanner(System.in);
        int from, to;
        System.out.print("# Vertices: ");
        N = sc.nextInt();
        color = new int[N];
        discover = new int[N];
        finish = new int[N];
        predecessor = new int[N];
        for (int i = 0; i < N; i++)
            predecessor[i] = -1;
        graph = new int[N][N];

        System.out.println("Enter edges <from> <to>: (-1 to stop)");
        while (true) {
            from = sc.nextInt();
            if (from == -1)
                break;
            to = sc.nextInt();
            graph[from][to] = 1;
        }

        sc.close();
    }

    private static void visit(int i) {
        color[i] = 1; // gray
        discover[i] = ++time;
        for (int j = 0; j < N; j++) {
            if (graph[i][j] == 1 && color[j] == 0) {
                predecessor[j] = i;
                visit(j);
            }
        }

        color[i] = 2; // black
        finish[i] = ++time;
    }

    private static void setCollapsing(int current) {
        // Find root of current
        int root = current;
        int parent;

        while (predecessor[root] != -1) {
            root = predecessor[root];
        }

        while (root != current) {
            parent = predecessor[current];
            predecessor[current] = root;
            current = parent;
        }

    }

    private static void printConnectedComponent() {
        for (int i = 0; i < N; i++)
            if (predecessor[i] == -1) { // It's root, print its children
                System.out.printf("Connected Component %2d", i);
                for (int j = 0; j < N; j++)
                    if (predecessor[j] == i)
                        System.out.printf("%2d", j);
                System.out.println();
            }
    }

    private static void printResult() {
        System.out.println("Print predecessor:");
        for (int i = 0; i < N; i++)
            System.out.printf("%2d ", i);
        System.out.println();
        for (int i = 0; i < N; i++)
            System.out.printf("%2d ", predecessor[i]);

        System.out.println("\n\nPrint discover:");
        for (int i = 0; i < N; i++)
            System.out.printf("%2d ", i);
        System.out.println();
        for (int i = 0; i < N; i++)
            System.out.printf("%2d ", discover[i]);

        System.out.println("\n\nPrint finish:");
        for (int i = 0; i < N; i++)
            System.out.printf("%2d ", i);
        System.out.println();
        for (int i = 0; i < N; i++)
            System.out.printf("%2d ", finish[i]);
        System.out.println("\n");
    }
}