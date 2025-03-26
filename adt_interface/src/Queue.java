/*
    A queue is follow FIFO principle.
     Basic Operation:
     @function enqueue():  add an entry to the back of the queue
     @function dequeue():  Removes and returns the entry at the front of the queue.
     @function isEmpty():  check if the queue is empty
     @function getFront(): retrieve the front object in the queue
     @function size(): return the number of entries in the queue
     @function clear(): removes all entries from the queue.
*/

public interface Queue <T>{
    void enqueue(T newEntry);
    T dequeue(T newEntry);
    T getFront();
    boolean isEmpty();
    T size();
    void clear();
}
