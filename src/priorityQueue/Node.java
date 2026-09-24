package priorityQueue;

public class Node<T> {
    T data;
    int priority;
    Node<T> next;

    public Node(T data, int priority) {
        this.data = data;
        this.priority = priority;
        this.next = null;
    }

    public int getPriority(){
        return this.priority;
    }

    public void setPriority(int priority){
        this.priority = priority;
    }

    public T getData(){
        return data;
    }

    public void setData(T data){
        this.data = data;
    }

    public Node<T> getNext(){
        return next;
    }

    public void setNext(Node<T> node){
        this.next = node;
    }

}