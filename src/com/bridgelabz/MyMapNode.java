package com.bridgelabz;

public class MyMapNode <K,V> {
        K key;
        V value;
        MyMapNode<K, V> next;

        // constructor name same as class name and they are passing parameter
        public MyMapNode(K key, V value) {
            this.key = key;
            this.value = value;
            next = null;
        }
        // getter and setter method
        public K getKey() {
            return key;
        }

        // setter method
        public void setKey(K key) {
            this.key = key;
        }
        //getValue and SetValue method
        public V getValue() {
            return value;
        }

        // seValue method
        public void setValue(V value) {
            this.value = value;
        }

        // method getNext this is return next value
        public MyMapNode<K, V> getNext() {
            return next;
        }

        //method create setNet set the key and value
        public void setNext(MyMapNode<K, V> next) {
            this.next = next;
        }
        @Override
        public String toString() {
            StringBuilder nodeString = new StringBuilder();
            nodeString.append("Node{" + "Key=").append(key).append(" Value=").append(value).append("}");
            if(next != null)
                nodeString.append("->").append(next);
            return nodeString.toString();
        }
    }