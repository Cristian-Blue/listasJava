package doubleList;

public class Node<T> {
    private T data;
    private Node<T> next;
    private Node<T> prev;

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

    public Node<T> getPrevious(){
        return this.prev;
    }

    public void setPrevious(Node<T> prev){
        this.prev = prev;

    }

}
