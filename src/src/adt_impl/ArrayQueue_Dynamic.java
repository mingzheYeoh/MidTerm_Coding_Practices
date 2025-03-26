package adt_impl;

import adt_interface.QueueInterface;

public class ArrayQueue_Dynamic<T> implements QueueInterface<T> {

    // need one array to store the element
    private T[] array;
    // front pointer is dynamic
    private int front_index = 0;
    // back pointer
    private int backIndex;
    // capacity of array
    private final static int DEFAULT_CAPACITY = 100;

    public ArrayQueue_Dynamic(){
        this(DEFAULT_CAPACITY);
    }

    public ArrayQueue_Dynamic(int initialCapacity){
        array = (T[]) new Object[initialCapacity];
        front_index = 0;
        backIndex = -1;  // indicates empty array queue
    }

    @Override
    public void enqueue(T newEntry){
        if (isArrayFull()) {
            doubleArray();
        }
        backIndex = (backIndex + 1) % array.length; // Circular increment
        array[++backIndex] = newEntry;
    }

    @Override
    public T dequeue(){
        T front = null; // first object
        if(!isEmpty()){
            front = array[front_index];
            array[front_index] = null;
            front_index = (front_index + 1) % array.length;
        }
        return front;

    }

    @Override
    public T getFront(){
        if(isEmpty()){
            return null;
        }
        return array[front_index];
    }

    @Override
    public boolean isEmpty(){
        return size() == 0;
    }

    @Override
    public int size(){
        if(backIndex >= front_index){
            return backIndex - front_index + 1;
        } else{
            return (backIndex + 1) + (array.length - front_index);
        }
    }

    @Override
    public void clear(){
        for (int i = front_index; i != (backIndex + 1) % array.length; i = (i + 1) % array.length) {
            array[i] = null;
        }
        front_index = 0;
        backIndex = -1;
    }

    @Override
    public String toString(){
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        int current = front_index;
        while (true) {
            sb.append(array[current]);
            if (current == backIndex) {
                break;
            }
            sb.append(", ");
            current = (current + 1) % array.length;
        }
        sb.append("]");
        return sb.toString();
    }

    // Private method
    private boolean isArrayFull(){
        // If capacity == array length, then full
        return size() == array.length - 1;
    }

    private void doubleArray(){
        T[] newArray = (T[]) new Object[array.length * 2];
        int newIndex = 0;
        // Copy elements from frontIndex to backIndex in order
        for (int i = front_index; i != (backIndex + 1) % array.length; i = (i + 1) % array.length) {
            newArray[newIndex++] = array[i];
        }
        array = newArray;
        front_index = 0;
        backIndex = newIndex - 1;
    }
}
