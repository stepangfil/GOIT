package ua.goit.module9;

public class MyQueue<E> {
    private static Node firstElem;
    private static Node lastElem;
    int listSize = 0;

    public void add(Object value) {
        Node newElem = new Node<>(value);
        if (listSize == 0){
            newElem.nextElem = null;
            newElem.prevElem = null;
            firstElem = newElem;
        } else {
            lastElem.nextElem = newElem;
            newElem.prevElem = lastElem;
        }
        lastElem = newElem;
        listSize++;
    }

    public E poll() {
        E returnElem = (E) firstElem.getValue();
        firstElem = firstElem.nextElem;
        firstElem.setPrevElem(null);
        listSize--;
        return returnElem;
    }

    public E peek() {
        E returnElem = (E) firstElem.getValue();
        return returnElem;
    }

    public void clear() {
        firstElem = null;
        lastElem = null;
        listSize = 0;
    }

    public int size() {
        return listSize;
    }

    public static class Node<E> {
        E value;
        Node prevElem;
        Node nextElem;

        Node(E value) {
            this.value = value;
            this.prevElem = prevElem;
            this.nextElem = nextElem;
        }

        public E getValue() {
            return value;
        }
        public void setNextElem(Node nextElem) {
            this.nextElem = nextElem;
        }

        public void setPrevElem(Node prevElem) {
            this.prevElem = prevElem;
        }
    }
}
