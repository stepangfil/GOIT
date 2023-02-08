package ua.goit.module9;

import java.util.Objects;

public class MyHashMap<K,V> {
    Node[] buckets = new Node[10];
    int sizeMap = 0;

    public void put(K key, V value) {
        int hashValue = Objects.hash(key);
        int index = hashValue & (buckets.length-1);
        int equalCount = 0;

        if (buckets[index] == null) {
            putToEmptyBucket(key, value, hashValue, index);
        } else {
            for (Node currentNode = buckets[index];currentNode.getNextNode() != null; currentNode = currentNode.getNextNode()) {
                if (currentNode.getHashCode() == hashValue && currentNode.getKey() == key){
                    equalCount++;
                }
            }
            if (equalCount == 0) {
                putNextNodeToBucket(key, value, hashValue, index);
            }
        }
        sizeMap++;
    }

    public V get(K key) {
        V value = null;

        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] == null) {
                break;
            }
            for (Node currentNode = buckets[i];; currentNode = currentNode.getNextNode()) {
                if (currentNode == null) {
                    break;
                }
                if (currentNode.getKey().equals(key)) {
                    value = (V) currentNode.getValue();
                    break;
                }
            }
        }
        return value;
    }

    public void remove(K key) {
        Node next;
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] == null) {
                i++;
            }
            for (Node currentNode = buckets[i];; currentNode = currentNode.getNextNode()) {
                if (currentNode == null) {
                    break;
                }
                if (currentNode.getNextNode() != null) {
                    next = currentNode.getNextNode();

                    if (next.getKey().equals(key)) {
                        currentNode.setNextNode(next.getNextNode());
                        sizeMap--;
                        break;
                    }
                }


            }
        }
    }

    public void clear() {
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = null;
        }
        sizeMap = 0;
    }

    public int size() {
        return sizeMap;
    }
    
    private void putToEmptyBucket(K key, V value, int hashValue, int index) {
        Node<K, V> newNode = new Node<>(hashValue, key, value, null);
        buckets[index] = newNode;
    }

    private void putNextNodeToBucket(K key, V value, int hashValue, int index) {
        for ( Node currentNode = buckets[index];; currentNode = currentNode.getNextNode()) {
            if (currentNode.getNextNode() == null) {
                Node node = new Node<>(hashValue, key, value, null);
                currentNode.setNextNode(node);
                break;
            }
        }
    }

    private static class Node<K, V> {
        private int hashCode;
        private final K key;
        private final V value;
        private Node nextNode;

        Node(int hashCode, K key, V value, Node nextNode) {
            this.hashCode = hashCode;
            this.key = key;
            this.value = value;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }

        public Node getNextNode() {
            return nextNode;
        }

        public int getHashCode() {
            return hashCode;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }


    }

}




