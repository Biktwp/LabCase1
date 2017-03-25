package com.company;

import java.util.Objects;

/**
 * Created by tau on 22/03/17.
 */
public interface IQueue  {

    public boolean isEmpty();

    public void enqueue(String word);

    // public String dequeue();

  //  public String front();

   public int getSize();

}
