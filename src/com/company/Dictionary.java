package com.company;

/**
 * Created by tau on 25/03/17.
 */
public class Dictionary implements IList {


    DNode header;
    DNode trailer;
    int size;

    public Dictionary() {
        header = new DNode(null);
        trailer = new DNode(null);
        header.next = trailer;
        trailer.prev= header;
    }


    public void addFirst(Elem elem) {
        DNode newNode = new DNode(elem);
        newNode.next = header.next;
        newNode.prev= header;
        header.next.prev= newNode;
        header.next = newNode;
        size++;
    }

    public boolean isEmpty() {
        return (header.next == trailer);
    }

    public int getSize() {

        return size;
    }

    public String  toString() {
        String result = null;
        for (DNode nodeIt = header.next; nodeIt != trailer; nodeIt = nodeIt.next) {
            if (result == null) {
                result = "Word: "+nodeIt.elem.word +". Frequency: "+ nodeIt.elem.frequency +"\n";
            } else {
                result +="Word: "+nodeIt.elem.word +". Frequency: " + nodeIt.elem.frequency+"\n";
            }
        }
        return result == null ? "empty" : result;
    }

    public void add(SQueue queue){//this method introduces all the words in the list
        for(int i = 0;i < queue.getSize();i++){
            add(queue.getAt(i),queue);
        }
    }

    public void add(String word,SQueue queue){// This method add the frequency and sort the list in alphabetical order
        DNode aux = header.next;
        boolean re = false;
        Elem elem = new Elem(word,queue.frequency(word));
        if (isEmpty()) {
            addFirst(elem);
        }
        else {
            while (aux != trailer && !re) {
                if (aux.elem.word.equals(word))re = true;
                    aux = aux.next;
            }
            if (!re)addFirst(elem);
        }
        boolean foundChange = true;
        while(foundChange) {
            foundChange = false;
            for(DNode nodeIt=header.next; nodeIt!=trailer.prev; nodeIt=nodeIt.next) {
                if (nodeIt.elem.word.compareTo(nodeIt.next.elem.word)>0) {
                    foundChange=true;
                    Elem aux1=nodeIt.elem;
                    nodeIt.elem=nodeIt.next.elem;
                    nodeIt.next.elem=aux1;
                }

            }

        }

    }

    public void show(char c){//This method sort the list in ascending alphabetical order if you introduce an a, otherwise the list is sorted in a descending alphabetical order
        if (c == 'a'){//Sorts in a ascending alphabetical order
            boolean foundChange = true;
            while(foundChange) {
                foundChange = false;
                for(DNode nodeIt=header.next; nodeIt!=trailer.prev; nodeIt=nodeIt.next) {
                    if (nodeIt.elem.word.compareTo(nodeIt.next.elem.word)>0) {
                        foundChange=true;
                        Elem aux1=nodeIt.elem;
                        nodeIt.elem=nodeIt.next.elem;
                        nodeIt.next.elem=aux1;
                    }

                }

            }
        }
        else{//Sorts in a descending alphabetical order
            boolean foundChange = true;
            while(foundChange) {
                foundChange = false;
                for(DNode nodeIt=header.next; nodeIt!=trailer.prev; nodeIt=nodeIt.next) {
                    if (nodeIt.elem.word.compareTo(nodeIt.next.elem.word)<0) {
                        foundChange=true;
                        Elem aux1=nodeIt.elem;
                        nodeIt.elem=nodeIt.next.elem;
                        nodeIt.next.elem=aux1;
                    }

                }

            }
        }
    }

    public int search(String word){
        for(DNode nodeIt=header.next; nodeIt!=trailer.prev; nodeIt=nodeIt.next) {
            if (nodeIt.elem.word.equals(word)){
                System.out.print("The frequency of "+word+" is ");return nodeIt.elem.frequency;
            }
        }
        System.out.print("The word does not exists");return -1;
    }


}
