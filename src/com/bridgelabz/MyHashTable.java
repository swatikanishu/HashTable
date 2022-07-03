package com.bridgelabz;

public class MyHashTable  <K,V> {
    MyMapNode head;
    MyMapNode tail;

    // Purpose: Method to get the word from Linked List.
    public V get(K word) {
        MyMapNode<K, V> myNode = searchNode(word);
        return (myNode == null) ? null : myNode.getValue();
    }

    // Method to search word from Linked List.
    public MyMapNode<K, V> searchNode(K word) {
        MyMapNode<K, V> currentNode = head;
        int position = 0;
        while (currentNode != null) {
            position++;
            if (currentNode.getKey().equals(word)) {
                return currentNode;
            }
            currentNode = currentNode.getNext();
        }
        return currentNode;
    }

    // Method to add key and value to hash table.
    // key: word to be added.
    // value: frequency of word.
    public void add(K key, V value) {
        MyMapNode<K, V> myNode = searchNode(key);
        if (myNode == null) {
            myNode = new MyMapNode<>(key, value);
            this.append(myNode);
        } else
            myNode.setValue(value);

    }
    // Purpose: Method to append value to Linked List.
    // value to append.
    private void append(MyMapNode<K, V> myNode) {
        if (this.head == null)
            this.head = myNode;
        if (this.tail == null)
            this.tail = myNode;
        else {
            this.tail.setNext(myNode);
            this.tail = myNode;
        }
    }

    @Override
    public String toString() {
        return "MyLinkedListNodes{" + head + '}';
    }

    /**
     *  create printNodes method
     *  this is print head
     */
    public void printNodes() {
        System.out.println("My nodes: " + head);
    }
}
