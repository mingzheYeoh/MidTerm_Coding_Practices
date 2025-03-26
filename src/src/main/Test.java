package main;

import adt_impl.ArrayQueue;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>(3);

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        System.out.println(queue);
        queue.clear();
        queue.enqueue(5);
        queue.enqueue(6);
        queue.dequeue();
        System.out.println(queue);
    }
}
