class DijkstraQueueTest {
    public static void main(String[] args) {
        DijkstraQueue Q = new DijkstraQueue(5);
        Q.push(new Node(0, 7));
        Q.push(new Node(1, 3));
        Q.push(new Node(2, 9));
        Q.push(new Node(3, 5));
        System.out.println(Q.pop().getDis());
        System.out.println(Q.pop().getDis());
        System.out.println(Q.pop().getDis());
        System.out.println(Q.pop().getDis());
    }
}