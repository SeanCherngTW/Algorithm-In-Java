import java.util.*;

class Node implements Comparable<Node> {
    private int idx;
    private int dis;

    public Node(int idx, int dis) {
        this.idx = idx;
        this.dis = dis;
    }

    @Override
    public int compareTo(Node other) {
        return this.dis - other.dis;
    }

    public int getIdx() {
        return idx;
    }

    public int getDis() {
        return dis;
    }
}