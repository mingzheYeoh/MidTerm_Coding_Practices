package adt_interface;

public interface ListInterface<T> {
    boolean add(T newEntry);
    boolean add(int Position, T newEntry);
    T remove(int givenPosition);
    boolean replace(int givenPosition, T newEntry);
    T getEntry(int givenPosition);
    boolean contains(T entry);
    void clear();
    int getNumberOfEntries();
    boolean isEmpty();
    boolean isFull();
}
