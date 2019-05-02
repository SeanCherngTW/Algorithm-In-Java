import java.util.Set;

class DijkstraMain {
    public static void main(String[] args) {
        int inf = Integet.MAX_VALUE;
        int[][] graph = { { inf, 8, inf, inf, inf, 1 }, { 3, inf, 1, inf, inf, inf }, { 5, inf, inf, 2, 2, inf },
                { inf, 4, 6, inf, 7, 3 }, { inf, inf, inf, inf, inf, inf }, { inf, inf, inf, 2, 8, inf } };

        int N = graph.length;
        int[] distance = new int[N];
        int[] predecessor = new int[N];
        DijkstraQueue Q = new DijkstraQueue(N);
        Set<Integer> S = new HashSet<Integer>();

        for (int i = 0; i < N; i++) {
            distance[i] = inf;
            predecessor[i] = -1;
        }

        int sourceIdx = 0; // Start point
        distance[sourceIdx] = 0;

        for (int i = 0; i < N; i++)
            Q.push(new Node(i, distance[sourceIdx]));

        Node u;

        while (!Q.isEmpty()) {
            u = Q.pop();
            int uIdx = u.getIdx();
            for (int vIdx = 0; vIdx < N; vIdx++)
                if (graph[uIdx][vIdx] != inf)
                    if (distance[uIdx] + graph[uIdx][vIdx] < distance[vIdx]) {
                        distance[vIdx] = distance[uIdx] + graph[uIdx][vIdx];
                        predecessor[vIdx] = uIdx;
                    }
        }

        System.out.println("Print predecessor:");
        for (int i = 0; i < N; i++)
            System.out.printf("%2d ", i);
        System.out.println();
        for (int i = 0; i < N; i++)
            System.out.printf("%2d ", predecessor[i]);

        System.out.println("\n\nPrint distance:");
        for (int i = 0; i < N; i++)
            System.out.printf("%2d ", i);
        System.out.println();
        for (int i = 0; i < N; i++)
            System.out.printf("%2d ", distance[i]);
    }
}