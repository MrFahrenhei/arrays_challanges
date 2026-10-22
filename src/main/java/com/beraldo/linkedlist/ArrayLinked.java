package com.beraldo.linkedlist;

import java.util.function.Predicate;

public class ArrayLinked<T> {
    private static class Node<T> {
        T data;
        Node<T> next;
        Node(T data){
            this.data = data;
        }
    }
    private Node<T> head;
    private int size;

    // add to the front O(1)
    public void addFirst(T value){
       Node<T> node = new Node<>(value);
       node.next = head;
       head = node;
       size++;
    }

    // add to the end O(n)
    public void addLast(T value){
       Node<T> node = new Node<>(value);
       if(head == null){
           head = node;
       }else{
           Node<T> current = head;
           while(current.next != null){
               current = current.next;
           }
           current.next = node;
       }
       size++;
    }

    // get by index O(n)
    public T get(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index: "+index);
        }
        Node<T> current = head;
        for(int i = 0; i < index; i++){
            current = current.next;
        }
        return current.data;
    }

    // remove the first occurrence
    public boolean remove(T value) {
        if (head == null) return false;
        if (head.data.equals(value)) {
            head = head.next;
            size--;
            return true;
        }

        Node<T> current = head;
        while (current.next != null) {
            if (current.next.data.equals(value)) {
                current.next = current.next.next;
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public boolean removeIf(Predicate<T> condition){
        if (head == null) return false;
        if (condition == null) return false;
        if(condition.test(head.data)){
            head = head.next;
            size--;
            return true;
        }
        Node<T> current = head;
        while(current.next != null){
            if(condition.test(current.next.data)){
                current.next = current.next.next;
                size--;
                return true;
            }
            current=current.next;
        }
        return false;
    }

    public int size() {
        return size;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) sb.append(" -> ");
            current = current.next;
        }
        return sb.append("]").toString();
    }


}
