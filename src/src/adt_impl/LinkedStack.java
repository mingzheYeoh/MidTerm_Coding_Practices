package adt_impl;

import adt_interface.StackInterface;

public class LinkedStack<T> implements StackInterface<T> {
    private Node top;

    // Constructor initializes an empty stack
    public LinkedStack() {
        top = null;
    }

    /**
     * Adds a new entry to the top of the stack.
     * @param newEntry The element to add
     */
    @Override
    public void push(T newEntry) {
        top = new Node(newEntry, top);
    }

    /**
     * Removes and returns the top element from the stack.
     * @return The top element, or null if the stack is empty
     */
    @Override
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        T data = top.data;
        top = top.next;
        return data;
    }

    /**
     * Returns the top element without removing it.
     * @return The top element, or null if the stack is empty
     */
    @Override
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return top.data;
    }

    /**
     * Checks if the stack is empty.
     * @return true if the stack is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return top == null;
    }

    /**
     * Removes all elements from the stack.
     */
    @Override
    public void clear() {
        top = null;
    }

    // Inner Node class to represent each element in the linked list
    private class Node {
        T data;
        Node next;

        Node(T data) {
            this(data, null);
        }

        Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
