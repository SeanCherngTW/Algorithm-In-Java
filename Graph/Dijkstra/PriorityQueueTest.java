class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueue Q = new PriorityQueue(4);
        Q.push(7);
        Q.push(3);
        Q.push(5);
        Q.push(9);
        System.out.println(Q.pop());
        System.out.println(Q.pop());
        System.out.println(Q.pop());
        System.out.println(Q.pop());
    }
}