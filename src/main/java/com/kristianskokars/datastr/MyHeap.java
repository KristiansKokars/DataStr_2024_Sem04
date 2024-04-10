package com.kristianskokars.datastr;

public class MyHeap<Ttype> {
    private Ttype[] heap;
    private final int HEAP_DEFAULT_SIZE = 10;
    private int size = HEAP_DEFAULT_SIZE;
    private int counter = 0;

    public MyHeap() {
        heap = (Ttype[]) new Object[size];
    }

    public MyHeap(int inputSize) {
        if (inputSize > 0) {
            size = inputSize;
        }
        heap = (Ttype[]) new Object[size];
    }

    public boolean isEmpty() {
        return (counter == 0);
    }

    public boolean isFull() {
        return (counter == size);
    }

    public int howManyElements() {
        return counter;
    }

    //1. funkcijas deklarācija
    private void resize() {
        //3. apreķināt newSize
        int newSize = (counter <= 100) ? size * 2 : (int) (size * 1.5);
        //4. izveidot listNew ar newSize izmeru
        Ttype[] heapNew = (Ttype[]) new Object[newSize];
        //5. veikt kopēsanu no veca masīva uz jauno
        for (int i = 0; i < size; i++) {
            heapNew[i] = heap[i];
        }

        //6. nomainam list refernci uz listNew
        heap = heapNew;
        //7. izsaukt Garbage Collector
        System.gc();
        //8. size noaminām uz newSize
        size = newSize;
    }


    public void enqueue(Ttype element) throws Exception {
        if (element == null) throw new Exception("Problems with element");

        if (isFull()) resize();

        heap[counter] = element;
        counter++;
        reheapUp(counter - 1);
    }

    public Ttype dequeue() throws Exception {
        if (isEmpty()) throw new Exception("Heap is empty and it is not possible to retrieve max element");


        Ttype prioElement = heap[0];
        heap[0] = heap[counter - 1];
        counter--;
        reheapDown(0);
        return prioElement;

    }

    //print() - parastā
    public void print() throws Exception {
        if (isEmpty()) throw new Exception("Array is empty and it "
                + "is not possible to print elements");

        for (int i = 0; i < counter; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    //TODO print() - rekursīvo
    public void print2() throws Exception {
        if (isEmpty()) throw new Exception("Array is empty and it "
                + "is not possible to print elements");

        printRecursively(0);
    }

    private void printRecursively(int indexOfElement) {
        Ttype element = heap[indexOfElement];

        System.out.print("P: " + element + " ");

        int leftChildIndex = indexOfElement * 2 + 1;
        int rightChildIndex = leftChildIndex + 1;

        if (leftChildIndex < counter) {
            Ttype leftChild = heap[leftChildIndex];
            System.out.println("LC: " + leftChild + " [" + element + "]");
            printRecursively(leftChildIndex);
        }

        if (rightChildIndex < counter) {
            Ttype rightChild = heap[rightChildIndex];
            System.out.println("RC: " + rightChild + " [" + element + "]");
            printRecursively(rightChildIndex);
        }
    }

    public void makeEmpty() {
        counter = 0;
        size = HEAP_DEFAULT_SIZE;
        heap = (Ttype[]) new Object[size];
        System.gc();
    }

    private void reheapUp(int indexOfElement) {
        // kreisais bērna index = vecaka index * 2 + 1
        // laba bēŗna index = vecaka index * 2 + 2

        //  (kreisa bēŗna index - 1)/2 = vecaka index
        //  (labā bēŗna index - 2)/2 = vecaka index

        int indexParent = (indexOfElement - 1) / 2;
        if (indexParent >= 0) {
            Ttype element = heap[indexOfElement];
            Ttype parent = heap[indexParent];

            if (((Comparable) element).compareTo(parent) > 0) {
                swap(indexOfElement, indexParent);
                reheapUp(indexParent);
            }
        }
    }

    private void reheapDown(int indexOfElement) {
        // TODO
        // 1. noskaidrot kreisā bērna indeksu
        // 2. noskaidrot labā bērna indeksu

        int leftIndex = indexOfElement * 2 + 1;
        int rightIndex = leftIndex + 2;

        // noskaidrot cik bērni ir
        int childCount = 0;
        if (leftIndex < counter) {
            childCount++;
        }
        if (rightIndex < counter) {
            childCount++;
        }

        // var šo gadījumu dzēst ārā ja negrib agri izbeigt funkciju
        if (childCount == 0) {
            // mēs visu esam sakārtojuši, beidzam darbību?
            return;
        }

        if (childCount == 1) {
            Ttype leftChild = heap[leftIndex];
            Ttype parent = heap[indexOfElement];

            if (((Comparable) leftChild).compareTo(parent) > 0) {
                swap(leftIndex, indexOfElement);
            }
        }

        if (childCount == 2) {
            Ttype leftChild = heap[leftIndex];
            Ttype rightChild = heap[rightIndex];
            Ttype parent = heap[indexOfElement];

            // TODO: nested ifs not great
            if (((Comparable) leftChild).compareTo(rightChild) > 0) {
                if (((Comparable) leftChild).compareTo(parent) > 0) {
                    swap(leftIndex, indexOfElement);
                    reheapDown(leftIndex);
                }
            } else {
                // compareTo
                // atgriež 1 ja ir lielāks
                // atgriež 0 ja ir vienāds
                // atgriež -1 ja ir mazāks
                if (((Comparable) rightChild).compareTo(parent) > 0) {
                    swap(rightIndex, indexOfElement);
                    reheapDown(rightIndex);
                }
            }
        }
    }

    private void swap(int index1, int index2) {
        Ttype temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }
}
