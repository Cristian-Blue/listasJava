package circle;
public class CircleList<T> {
    private Node<T> head;

    public CircleList() {
        this.head = null;
    }

    public void add(T value) {
        Node<T> node = new Node<T>();
        node.setData(value);
        if (head == null) {
            this.head = node;
            node.setNext(head);
            return;
        }

        node.setNext(head);
        Node<T> actual = head;
        while (actual.getNext() == head) {
            actual = actual.getNext();
        }
        actual.setNext(node);
        node.setNext(head);
    }

    public void addLast(T value) {

    }

    public void printList() {
        Node<T> actual = head;

        do {
            System.out.println(actual.getData() + " ->");
            actual = actual.getNext();
        } while (actual == head);
    }
}
