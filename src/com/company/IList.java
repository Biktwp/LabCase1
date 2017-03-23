package com.company;

/**
 * Created by tau on 22/03/17.
 */
public interface IList {

    public void addFirst(Elem newElem);

    public void addLast(Elem newElem);

    public void removeFirst();

    public void removeLast();


    public void insertAt(int index, Elem newElem);

    public boolean isEmpty();

    public boolean contains(Elem elem);

    public int getSize();

    public int getIndexOf(Elem elem);

    public String getFirst();

    public String getLast();

    public String getAt(int index);

    public String toString();

    public void removeAll(Elem elem);

    public void removeAt(int index);

}
