package adt_impl;

import adt_interface.ListInterface;

public class LinkedList<T> implements ListInterface<T> {

    private Node firstNode;
    private int numberOfEntries;

    public LinkedList(){
        clear();
    }

    @Override
    public boolean add(T newEntry) {
        Node newNode = new Node(newEntry);
        if(isEmpty()){
            firstNode = newNode;
        }else{
            Node currentNode = firstNode;
            while(currentNode.next != null){ //while have not reached the last node
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
        numberOfEntries ++;
        return true;
    }

    @Override
    public boolean add(int newPosition, T newEntry) {
        boolean isSuccess = true;
        if((newPosition >= 1) && (newPosition <= numberOfEntries + 1)){
            Node newNode = new Node(newEntry);
            if(isEmpty() || (newPosition == 1)){
                newNode.next = firstNode;
                firstNode = newNode;
            }else{
                Node nodeBefore = firstNode;
                for(int i = 0; i < newPosition - 1; i++){
                    nodeBefore = nodeBefore.next;
                }
                newNode.next = nodeBefore.next;
                nodeBefore.next = newNode;
            }
            numberOfEntries++;
        }else{
            isSuccess = false;
        }
        return isSuccess;
    }

    @Override
    public T remove(int givenPosition) {
        T result = null;
        if((givenPosition >= 1) && (givenPosition <= numberOfEntries)){
            if(givenPosition == 1){
                result = firstNode.data;
                firstNode = firstNode.next;
            }else{
                Node nodeBefore = firstNode;
                for(int i = 1; i < givenPosition - 1; ++i){
                    nodeBefore = nodeBefore.next;
                }
                result = nodeBefore.next.data;
                nodeBefore.next = nodeBefore.next.next;
            }
            numberOfEntries--;
        }
        return result;
    }

    @Override
    public boolean replace(int givenPosition, T newEntry) {
        boolean isSuccess = true;
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            Node currentNode = firstNode;
            for (int i = 0; i < givenPosition - 1; ++i) {
                currentNode = currentNode.next;		// advance currentNode to next node
            }
            currentNode.data = newEntry;	// currentNode is pointing to the node at givenPosition
        } else {
            isSuccess = false;
        }
        return isSuccess;
    }

    @Override
    public T getEntry(int givenPosition) {
        T result = null;

        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            Node currentNode = firstNode;
            for (int i = 0; i < givenPosition - 1; ++i) {
                currentNode = currentNode.next;		// advance currentNode to next node
            }
            result = currentNode.data;	// currentNode is pointing to the node at givenPosition
        }
        return result;
    }

    @Override
    public boolean contains(T entry) {
        boolean found = false;
        Node currentNode = firstNode;

        while (!found && (currentNode != null)) {
            if (entry.equals(currentNode.data)) {
                found = true;
            } else {
                currentNode = currentNode.next;
            }
        }
        return found;
    }

    @Override
    public final void clear() {
        firstNode = null;
        numberOfEntries = 0;
    }

    @Override
    public int getNumberOfEntries() {
        return numberOfEntries;
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public String toString() {
        StringBuilder outputStr = new StringBuilder();
        Node currentNode = firstNode;
        while (currentNode != null) {
            outputStr.append(currentNode.data).append("\n");
            currentNode = currentNode.next;
        }
        return outputStr.toString();
    }

    private class Node{
        private T data;
        private Node next; // A reference to the next node

        // The constructor used to create last node or independent node
        private Node(T data){
            this.data = data;
            this.next = null;
        }

        private Node(T data, Node next){
            this.data = data;
            this.next = next;
        }
    }
}
