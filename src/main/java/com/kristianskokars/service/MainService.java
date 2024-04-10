package com.kristianskokars.service;

import com.kristianskokars.datastr.MyHeap;
import com.kristianskokars.model.Patient;

public class MainService {
    public static void main(String[] args) throws Exception {
        var heap = new MyHeap<Integer>();

        heap.enqueue(5);
        heap.enqueue(19);
        heap.enqueue(3);
        heap.enqueue(26);
        heap.enqueue(27);
        heap.enqueue(28);
        heap.enqueue(25);
        heap.enqueue(24);
        heap.enqueue(40);
        heap.enqueue(15);
        heap.enqueue(2);

        heap.print();
        System.out.println("---------------------");
        heap.print2();
        System.out.println("---------------------");

        System.out.println(heap.dequeue());
        heap.print2();
        System.out.println("---------------------");

        var allPatients = new MyHeap<Patient>();

        allPatients.enqueue(new Patient("123456-56789", "Janis", "Berzins", 2));
        allPatients.enqueue(new Patient("113456-56789", "Baiba", "Kalnina", 4));
        allPatients.enqueue(new Patient("013456-56789", "Liga", "Jauka", 8));

        System.out.println(allPatients.dequeue());
        System.out.println("---------------------");

        allPatients.print2();
    }
}