package priorityQueue;

public class MyPriorityQueue<T> {

    private Node<T> front;

    public MyPriorityQueue() {
        front = null;
    }

    /**
     * Inserts a new element according to its priority.
     * A lower priority number means higher priority.
     * If priorities are equal, FIFO order is preserved.
     */
    public void enqueue(T data, int priority) {
        Node<T> Node = new Node<>(data, priority);

        // Case 1: the queue is empty.
        if (front == null) {
            front = Node;
            return;
        }

        // Case 2: the new Node<T> has higher priority than the front.
        if (priority < front.priority) {
            Node.next = front;
            front = Node;
            return;
        }

        // Search for the position where the new Node<T> must be inserted.
        Node<T> current = front;

        /*
         * Move while the next Node<T> has a priority
         * less than or equal to the new Node<T>.
         * Using <= preserves FIFO for equal priorities.
         */
        while (current.next != null
                && current.next.priority <= priority) {
            current = current.next;
        }

        // Insert the new Node<T> between current and current.next.
        Node.next = current.next;
        current.next = Node;
    }

    /**
     * Removes and returns the element with the highest priority.
     */
    public Object dequeue() {
        if (front == null) {
            return null;
        }

        Node<T> removed = front;
        front = front.next;

        return removed.data;
    }

    /**
     * Returns the element with the highest priority
     * without removing it from the queue.
     */
    public Object peek() {
        if (front == null) {
            return null;
        }

        return front.data;
    }

    /**
     * Checks whether the queue is empty.
     */
    public boolean isEmpty() {
        return front == null;
    }

    /**
     * Displays the elements from highest to lowest priority.
     */
    public void show() {
        Node<T> current = front;

        while (current != null) {
            System.out.println(
                current.data + " - Priority: " + current.priority
            );
            current = current.next;
        }
    }
}