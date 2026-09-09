package pila;

public class MyStack<T> {

    private Node<T> top;

    public MyStack() {
        top = null;
    }

    public void push(T value) {
        Node<T> node = new Node<>();
        node.setData(value);
        node.setNext(top);
        top = node;
    }

    public T pop() {
        if (top == null) {
            return null;
        }
        T data = top.getData();
        top = top.getNext();
        return data;
    }

    public T peek() {

        if (top == null) {
            return null;
        }

        return top.getData();
    }

    public boolean isEmpty(){
        return top == null;
    }
}
