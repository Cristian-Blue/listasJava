package doubleList;

public class MyDoubleLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;

    public MyDoubleLinkedList() {
        head = null;
        tail = null;
    }

    // ==========================================
    // AGREGAR AL FINAL
    // ==========================================

    public void add(T data) {
        addLast(data);
    }

    // ==========================================
    // AGREGAR AL PRINCIPIO
    // ==========================================

    public void addFirst(T data) {

        Node<T> node= new Node<T>();

        node.setData(data);
        node.setPrevious(null);
        node.setNext(head);

        // Si la lista no está vacía
        if (head != null) {
            head.setPrevious(node);
        } else {
            // Si estaba vacía, el nuevo nodo
            // también será el último
            tail = node;
        }

        head = node;
    }

    // ==========================================
    // AGREGAR AL FINAL
    // ==========================================

    public void addLast(T data) {

        Node<T> node= new Node<T>();

        node.setData(data);
        node.setNext(null);
        node.setPrevious(tail);

        // Si la lista está vacía
        if (tail == null) {

            head = node;
            tail = node;

            return;
        }

        // El antiguo último apunta al nuevo
        tail.setNext(node);

        // El nuevo pasa a ser el último
        tail = node;
    }

    // ==========================================
    // BUSCAR UN ELEMENTO
    // ==========================================

    public boolean contains(T value) {

        Node<T> actual = head;

        while (actual != null) {

            if (actual.getData().equals(value)) {
                return true;
            }

            actual = actual.getNext();
        }

        return false;
    }

    // ==========================================
    // ELIMINAR POR VALOR
    // ==========================================

    public boolean remove(T value) {

        Node<T> actual = head;

        while (actual != null) {

            if (actual.getData().equals(value)) {

                // Caso 1:
                // El nodo es el primero
                if (actual == head) {
                    removeFirst();
                    return true;
                }

                // Caso 2:
                // El nodo es el último
                if (actual == tail) {
                    removeLast();
                    return true;
                }

                // Caso 3:
                // El nodo está en el medio

                Node<T> previous = actual.getPrevious();
                Node<T> next = actual.getNext();

                previous.setNext(next);
                next.setPrevious(previous);

                return true;
            }

            actual = actual.getNext();
        }

        return false;
    }

    // ==========================================
    // ELIMINAR EL PRIMERO
    // ==========================================

    public boolean removeFirst() {

        if (head == null) {
            return false;
        }

        // Si solamente existe un nodo
        if (head == tail) {

            head = null;
            tail = null;

            return true;
        }

        // El segundo nodo será el primero
        head = head.getNext();

        // El nuevo primero ya no tiene anterior
        head.setPrevious(null);

        return true;
    }

    // ==========================================
    // ELIMINAR EL ÚLTIMO
    // ==========================================

    public boolean removeLast() {

        if (tail == null) {
            return false;
        }

        // Si solamente existe un nodo
        if (head == tail) {

            head = null;
            tail = null;

            return true;
        }

        // El nodo anterior al último
        // será ahora el último
        tail = tail.getPrevious();

        // El nuevo último no tiene siguiente
        tail.setNext(null);

        return true;
    }

    // ==========================================
    // OBTENER ELEMENTO POR ÍNDICE
    // ==========================================

    public T get(int index) {

        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException(
                    "Índice fuera de rango"
            );
        }

        /*
         * Si el índice está más cerca del principio,
         * recorremos desde head.
         *
         * Si está más cerca del final,
         * recorremos desde tail.
         */

        if (index < size() / 2) {

            Node<T> actual = head;

            int contador = 0;

            while (actual != null) {

                if (contador == index) {
                    return actual.getData();
                }

                contador++;
                actual = actual.getNext();
            }

        } else {

            Node<T> actual = tail;

            int contador = size() - 1;

            while (actual != null) {

                if (contador == index) {
                    return actual.getData();
                }

                contador--;
                actual = actual.getPrevious();
            }
        }

        return null;
    }

    // ==========================================
    // OBTENER CANTIDAD DE ELEMENTOS
    // ==========================================

    public int size() {

        int contador = 0;

        Node<T> actual = head;

        while (actual != null) {

            contador++;

            actual = actual.getNext();
        }

        return contador;
    }

    // ==========================================
    // SABER SI ESTÁ VACÍA
    // ==========================================

    public boolean isEmpty() {

        return head == null;
    }

    // ==========================================
    // VACIAR LISTA
    // ==========================================

    public void clear() {

        head = null;
        tail = null;
    }

    // ==========================================
    // RECORRER HACIA ADELANTE
    // ==========================================

    public void printForward() {

        Node<T> actual = head;

        while (actual != null) {

            System.out.print(
                    actual.getData() + " ⇄ "
            );

            actual = actual.getNext();
        }

        System.out.println("null");
    }

    // ==========================================
    // RECORRER HACIA ATRÁS
    // ==========================================

    public void printBackward() {

        Node<T> actual = tail;

        while (actual != null) {

            System.out.print(
                    actual.getData() + " ⇄ "
            );

            actual = actual.getPrevious();
        }

        System.out.println("null");
    }
}

