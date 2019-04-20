import java.util.Scanner;

class FloydWarshallMain {

    static int N;
    static int[][] distance;
    static int[][] predecessor;

    public static void main(String[] args) {

        readInput();

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++)
                for (int j = 0; j < N; j++)
                    if ((distance[i][j] > distance[i][k] + distance[k][j]) && (distance[i][k] != Integer.MAX_VALUE)
                            && (distance[k][j] != Integer.MAX_VALUE)) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                        predecessor[i][j] = predecessor[k][j];
                    }
        }
        printResult();
    }

    private static void readInput() {
        Scanner sc = new Scanner(System.in);
        int from, to, weight;

        System.out.print("# Vertices: ");
        N = sc.nextInt();
        distance = new int[N][N];
        predecessor = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++) {
                predecessor[i][j] = -1;
                if (i == j)
                    distance[i][j] = 0;
                else
                    distance[i][j] = Integer.MAX_VALUE;
            }

        System.out.println("Enter edges <from> <to> <weight>: (-1 to stop)");
        while (true) {
            from = sc.nextInt();
            if (from == -1)
                break;
            to = sc.nextInt();
            weight = sc.nextInt();
            distance[from][to] = weight;
        }

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++) {
                if ((distance[i][j] != 0) && (distance[i][j] != Integer.MAX_VALUE))
                    predecessor[i][j] = i;
            }

        sc.close();
    }

    private static void printResult() {
        System.out.println("Print predecessor:");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.printf("%2d ", predecessor[i][j]);
            System.out.println();
        }

        System.out.println("\nPrint distance:");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (distance[i][j] == Integer.MAX_VALUE)
                    System.out.printf(" ∞ ");
                else
                    System.out.printf("%2d ", distance[i][j]);
            }
            System.out.println();
        }
    }
}