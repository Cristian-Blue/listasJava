package cola;

public class MyQueue<T> {
    private Node<T> rear; // cola el final
    private Node<T> front; // comienzo
    private int size;

    public MyQueue(){
        this.rear = null;
        this.front = null;
        this.size = 0;
    }

    public void enqueue(){
        Node<T> node = new Node<T>();
        if (front == null){
            front = node;
            rear = node;
        }else{
            rear.setNext(node);
            rear = node;
        }
        size++;
    }

    public T dequeue(){
        if (front == null){
            return null;
        }

        T data = front.getData();
        front = front.getNext();
        size--;
        if(front == null){
            rear = null;
        }
        return data;
    }

    public T peek(){
        return (front == null)? null: this.front.getData();
    }

    public boolean isEmpty(){
        return this.rear == null;
    }

    public int size(){
        return this.size;
    }
}
