package com.company;

/**
 * Created by tau on 22/03/17.
 */
public class SQueue implements IQueue {

    SNode first;
    SNode last;

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public void enqueue(String word) {
        SNode newNode = new SNode(word);
        if(isEmpty()){ first = newNode; }
        else last.next = newNode;
        last = newNode;
    }

    @Override
    public String dequeue() {
        if (isEmpty()){System.out.println("The Queue is empty"); return null;}
        else {
            String firstWord = first.word;
            first = first.next;
            if (first == null) {
                last = null;
            }
            return firstWord;
        }
    }

    @Override
    public String front() {
        if (isEmpty()){System.out.println("The Queue is empty"); return null;}
        return first.word;
    }

    @Override
    public int getSize() {
        int size = 0;
        while(first.next == null){first = first.next; size++;}
        return size;
    }
}
