class PriorityQueue {
    private int[] queue;
    private int curSize = 0;
    private int maxSize;

    public PriorityQueue(int maxSize) {
        queue = new int[maxSize];
        this.maxSize = maxSize;
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int leftChild(int i) {
        return 2 * i + 1;
    }

    private int rightChild(int i) {
        return 2 * i + 2;
    }

    public boolean isEmpty() {
        return curSize == 0;
    }

    private void heapify(int i) {
        int left = leftChild(i);
        int right = rightChild(i);
        int minIdx = i;
        if (left < curSize && queue[left] < queue[i]) // Swap idx i & its left leftChild
            minIdx = left;
        if (right < curSize && queue[right] < queue[minIdx])
            minIdx = right;
        if (minIdx != i) { // If minIdx == i, then i is no longer need to swap
            int tmp = queue[i];
            queue[i] = queue[minIdx];
            queue[minIdx] = tmp;
            heapify(minIdx);
        }
    }

    public void push(int value) {
        if (curSize == maxSize)
            throw new ArrayIndexOutOfBoundsException("The PriorityQueue is out of capacity");

        int i = curSize; // idx to insert
        queue[i] = value;
        curSize++;

        while (i > 0 && queue[i] < queue[parent(i)]) {
            int tmp = queue[i];
            queue[i] = queue[parent(i)];
            queue[parent(i)] = tmp;
            i = parent(i);
        }
    }

    public int pop() {
        if (curSize == 0)
            throw new NullPointerException("The PriorityQueue is empty");
        if (curSize == 1) {
            curSize--;
            return queue[0];
        }

        int popValue = queue[0];
        queue[0] = queue[curSize - 1];
        curSize--;
        heapify(0);

        return popValue;
    }

    public void print() {
        for (int i = 0; i < curSize; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }
}