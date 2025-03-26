package adt_impl;

import adt_interface.QueueInterface;

public class ArrayQueue<T> implements QueueInterface<T> {

    // need one array to store the element
    private T[] array;
    // front pointer
    private final static int FRONT_INDEX = 0;
    // back pointer
    private int backIndex;
    // capacity of array
    private final static int DEFAULT_CAPACITY = 100;

    public ArrayQueue(){
        this(DEFAULT_CAPACITY);
    }

    public ArrayQueue(int initialCapacity){
        array = (T[]) new Object[initialCapacity];
        backIndex = -1;  // indicates empty array queue
    }

    @Override
    public void enqueue(T newEntry){
        if (isArrayFull()) {
            doubleArray();
        }
        array[++backIndex] = newEntry;
    }

    @Override
    public T dequeue(){
        T front = null; // first object
        if(!isEmpty()){
            front = array[FRONT_INDEX];
            // Shift so i < backIndex not <= backIndex
            for(int i = FRONT_INDEX; i < backIndex; i++){
                array[i] = array[i + 1];
            }
            backIndex--;
        }
        return front;
    }

    @Override
    public T getFront(){
        T front = null;
        if(!isEmpty()){
            front = array[FRONT_INDEX];
        }
        return front;
    }

    @Override
    public boolean isEmpty(){
        return  backIndex == -1;
    }

    @Override
    public int size(){
        return backIndex + 1;
    }

    @Override
    public void clear(){
        for(int i = FRONT_INDEX; i <= backIndex; i++){
            array[i] = null;
        }
        backIndex = -1;
    }

    @Override
    public String toString(){
        if (backIndex == -1)
            return "[]";
        StringBuilder sb = new StringBuilder("[");
        for(int i = FRONT_INDEX; i <= backIndex; i++){
            sb.append(array[i]);
            if(i < backIndex){
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    // Private method
    private boolean isArrayFull(){
        // If capacity == array length, then full
        return backIndex == array.length - 1;
    }

    private void doubleArray(){
        T[] newArray = (T[]) new Object[array.length * 2];
        System.arraycopy(array, 0, newArray, 0, backIndex + 1);
        array = newArray;
    }
}
