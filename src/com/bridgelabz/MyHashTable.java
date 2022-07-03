package com.bridgelabz;
import java.util.ArrayList;
class MyHashTable <K, V> {
    MyMapNode<K, V> head;
    MyMapNode<K, V> tail;
    private final int numOfBuckets;
    ArrayList<MyMapNode<K, V>> myBucketArray;

    // default constructor
    public MyHashTable() {
        this.numOfBuckets = 20;  //20 is assigned a little more than the numbers of total words
        this.myBucketArray = new ArrayList<>(numOfBuckets);

        //  Create empty LinkedLists

        for (int i = 0; i < numOfBuckets; i++)
            this.myBucketArray.add(null);
    }

    // method to get value from LinkedList using index number
    //key : key is returned
    public V get(K key) {
        int index = this.getBucketIndex(key);
        if (this.myBucketArray.get(index) == null)
            return null;
        MyMapNode<K, V> myNode = search(key);
        return (myNode == null) ? null : myNode.getValue();
    }

    //Method to search the word in LinkedList
    // key : key to search
    public MyMapNode<K, V> search(K key) {
        MyMapNode<K, V> currentNode = head;

        while (currentNode != null) {
            if (currentNode.getKey().equals(key)) {
                return currentNode;
            }
            currentNode = currentNode.getNext();
        }

        return currentNode;
    }

    // Method to add key and value to hash table
    //key : word to be added
    // value: frequency of word
    public void add(K key, V value) {
        int index = this.getBucketIndex(key);
        MyMapNode<K, V> myNode = this.myBucketArray.get(index);

        if (myNode == null) {
            myNode = new MyMapNode<>(key, value);
            this.myBucketArray.set(index, myNode);
        }
        myNode = search(key);
        if (myNode == null) {
            myNode = new MyMapNode<>(key, value);
            this.append(myNode);
        } else
            myNode.setValue(value);
    }

    // implements hash function to find index for a key
    public int getBucketIndex(K key) {
        int hashCode = Math.abs(key.hashCode());
        int index = hashCode % numOfBuckets;
        return index;
    }

    // Method to append value to Linked List
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

    // Method to remove a word
    //  key : word to be removed
    public void remove(K key) {
        MyMapNode<K, V> currentNode = head;
        MyMapNode<K, V> previousNode = null;
        while (currentNode != null && currentNode.getKey().equals(key)) {
            head = currentNode.getNext();
        }
        while (currentNode != null && !(currentNode.getKey().equals(key))) {
            previousNode = currentNode;
            currentNode = currentNode.getNext();
        }
        if (currentNode != null)
            previousNode.next = currentNode.next;
        if (currentNode == null)
            System.out.println("Word not found");
    }

    @Override
    public String toString() {
        return "MyHashMapNodes{" + head + '}';
    }
}