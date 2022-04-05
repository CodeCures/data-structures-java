package com.codesgate;

import java.util.NoSuchElementException;

public class LinkedList {
    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node first;
    private Node last;
    private int size;

    public void addLast(int item) {
        var node = new Node(item);

        if (isEmpty())
            first = last = node;
        else
            last = last.next = node;
        size++;
    }

    public void addFirst(int item) {
        var node = new Node(item);

        if(isEmpty())
            first = last = node;
        else {
            node.next = first;
            first = node;
        }
        size++;
    }

    public int indexOf(int item){
        int index  = 0;
        var current = first;

        while(current != null){
            if(current.value == item) return index;
            current = last;
            index++;
        }
        return -1;
    }

    public void removeFirst() {
        if (size < 1)
            throw new NoSuchElementException();

        if (first.equals(last))
            first = last = null;
        else{
            var nextNode = first.next;
            first.next = null;
            first = nextNode;
        }
        size--;
    }

    public void removeLast() {
        if(size < 1)
            throw new NoSuchElementException();

        if (first.equals(last))
            first = last = null;
        else {
            var previous = getPrevious();
            last = previous;
            last.next = null;
        }
        size--;
    }

    private Node getPrevious(){
        var current = first;

        while (current != null){
            if(current.next == last) return current;
            current = current.next;
        }
        return null;
    }

    public boolean contains(int item){
        return indexOf(item) != -1;
    }

    public int size() {
        return size;
    }

    public int[] toArray(){
        int[] array = new int[size];
        var current = first;
        int index = 0;

        while(current != null){
            array[index++] = current.value;
            current = current.next;
        }
        return array;
    }

    private boolean isEmpty(){
        return first == null;
    }
}
