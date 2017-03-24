package com.company;

/**
 * Created by tau on 22/03/17.
 */
public class SQueue implements IQueue {

    SNode first;
    SNode last;
    int size = 0;

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public void enqueue(String word) {//This method introduces a word in the queue
        SNode newNode = new SNode(word);
        if(isEmpty()){ first = newNode; }
        else last.next = newNode;
        last = newNode;
        size++;
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
    public int getSize() {//Returns the size of the queue
        return size;
    }

    public int frequency(String word){//Returns the number of times a word is repeated
        int f = 0;
        SNode aux = first;
        while(aux != null){
            if (word.equals(aux.word)){
                f++;
            }
            aux = aux.next;
        }
        return f;
    }

    public Elem fusion(int position){//This method mix the word and its frequency
        Elem fusion = new Elem(getAt(position),frequency(getAt(position)));
        return fusion;
    }

    public String getAt(int size){//Returns the word in a specific position
        SNode aux = first;
        if (isEmpty()){
            System.out.println("The Queue is empty");
            return null;
        }
        else if (size<0 && size>getSize())return null;
        else{
           for ( int i = 0; i < size; i++){
               aux = aux.next;
           }
        }
        return aux.word;
    }
    public void addWords(String [] aux){//Adds all the words in the text to the queue
        for(int i = 0; i < aux.length; i++){
            if (!aux[i].equals("")) enqueue(aux[i]);
        }
    }
}
