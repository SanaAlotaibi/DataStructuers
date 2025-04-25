package com.mycompany.rojectcsc212;
public class LinkedList<T> {
    private ListNode head, current;

    public LinkedList() {
        head = current = null;
    }

    public void insert(T item) {
        ListNode nNode = new ListNode(item);
        if (head == null) {
            head = nNode;
        } else {
            ListNode p = head;
            while (p.next != null) p = p.next;
            p.next = nNode;
        }
    }

    public void remove(T item) {
        ListNode previous = null, current = head;
        while (current != null) {
            if (current.data.equals(item)) {
                if (previous == null) {
                    head = current.next;
                } else {
                    previous.next = current.next;
                }
                return;
            }
            previous = current;
            current = current.next;
        }
    }

    public boolean hasItem(T item) {
        ListNode p = head;
        while (p != null) {
            if (p.data.equals(item)) 
                return true;
            p = p.next;
        }
        return false;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public boolean hasNext() {
        return current != null;
    }

    public T next() {
        if (current == null) 
            return null;
        T data = (T) current.data;
        current = current.next;
        return data;
    }
    
    public boolean full(){
        return false;
    }
    
    public void startTraversal() {
        current = head;
    }
}

