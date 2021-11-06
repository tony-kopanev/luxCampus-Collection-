package com.luxoft.datastructures.queue;

public interface Queue {
  void enqueue(Object val);

  Object dequeue() throws IllegalAccessException;

  Object peek();

  int size();

  boolean isEmpty();

  boolean contains(Object val);

  void clear();

  String toString();
}
