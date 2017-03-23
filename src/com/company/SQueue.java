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

    public int frequency(String word){
        int f = 0;
        while(first != null){
            if (word.equals(first.word)){
                f++;
            }
            first = first.next;
        }
        return f;
    }

    public Elem fusion(int position){
        Elem fusion = new Elem(getAt(position),frequency(getAt(position)));
        return fusion;
    }

    public String getAt(int size){
        if (isEmpty()){
            System.out.println("The Queue is empty");
            return null;
        }
        else if (size<0 && size>getSize())return null;
        else{
           for ( int i = 0; i < size; i++){
               first = first.next;
           }
        }
        return first.word;
    }
}
