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


    public void addLast(Elem elem) {
        DNode newNode = new DNode(elem);
        newNode.next = trailer;
        newNode.prev= trailer.prev;
        trailer.prev.next = newNode;
        trailer.prev= newNode;
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

    public void add(SQueue queue){
        for(int i = 0;i < queue.getSize();i++){
            add(queue.getAt(i),queue);
        }
    }

    public void add(String word,SQueue queue){
        DNode aux = header.next;
        int fr = -1;
        boolean re = false;
        Elem elem;
        if (isEmpty()) {
            addFirst((elem = new Elem(word,queue.frequency(word))));
        }
        else {
            while (aux != trailer && !re) {
                if (aux.elem.word.equals(word)) {
                    re = true;
                }
                    aux = aux.next;
            }
            if (!re){
                addFirst((elem = new Elem(word,queue.frequency(word))));
            }
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

}
