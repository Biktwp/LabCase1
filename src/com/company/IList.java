package com.company;

/**
 * Created by tau on 22/03/17.
 */
public interface IList {

    public void addFirst(Elem newElem);

    public void addLast(Elem newElem);

    public Elem getAt(int n);

    public boolean isEmpty();

    public int getSize();

    public String toString();

}
