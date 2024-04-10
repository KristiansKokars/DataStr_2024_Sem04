package com.kristianskokars;

import com.kristianskokars.datastr.MyHeap;

public class Main {
    public static void main(String[] args) throws Exception {
        var heap = new MyHeap<Integer>();

        heap.enqueue(5);
        heap.enqueue(2);
        heap.enqueue(19);
        heap.enqueue(20);
        heap.enqueue(1);
        heap.print();
    }
}