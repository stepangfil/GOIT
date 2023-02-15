package ua.goit.module9;

public class MyStack<E> {
    private static Node firstElem;
    private static Node lastElem;
    int listSize = 0;

    public void push(Object value) {
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

    public void remove(int index) {
        Node currentElem = lastElem;
        Node prev;
        Node next;
        int indexElem = 1;

        for (int i = 1; i < listSize; i++) {
            if (index == 1) {
                firstElem = firstElem.nextElem;
                firstElem.setPrevElem(null);
                listSize--;
                break;
            } else if (index == listSize) {
                currentElem = lastElem.prevElem;
                currentElem.setNextElem(null);
                listSize--;
                break;
            } else if(index == indexElem) {
                prev = currentElem.prevElem;
                next = currentElem.nextElem;
                prev.setNextElem(next);
                next.setPrevElem(prev);
                listSize--;
                break;
            } else {
                currentElem = currentElem.nextElem;
                indexElem++;
            }
        }
    }

    public E peek() {
        E returnElem = (E) lastElem.getValue();
        return returnElem;
    }

    public E pop() {
        E returnElem = (E) lastElem.getValue();
        lastElem = lastElem.prevElem;
        lastElem.setNextElem(null);
        listSize--;
        return returnElem;
    }

    public void clear() {
        firstElem = null;
        lastElem = null;
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
