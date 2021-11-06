package com.luxoft.datastructures.queue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//  void enqueue(Object val);
//  Object dequeue();
//  Object peek();
//  int size();
//  boolean isEmpty();
//  boolean contains(Object val);
//  void clear();
//  String toString();
public class ArrayQueueTest {

  @DisplayName("enqueue/dequeue - test enqueue, dequeue, and change size methods")
  @Test
  public void testEnqueueAndDequeueAndChangeSize() throws IllegalAccessException {
    ArrayQueue arrayQueue = new ArrayQueue();
    arrayQueue.enqueue("A");
    arrayQueue.enqueue("B");

    assertEquals(2, arrayQueue.size());
    assertEquals("A", arrayQueue.dequeue());
    assertEquals("B", arrayQueue.dequeue());
    assertEquals(0, arrayQueue.size());
    assertTrue(arrayQueue.isEmpty());
  }

  @DisplayName("PEEK test enqueue, PEEK, and change size methods")
  @Test
  public void testEnqueueAndPeekAndChangeSize() throws IllegalAccessException {
    ArrayQueue arrayQueue = new ArrayQueue();
    arrayQueue.enqueue("A");
    arrayQueue.enqueue("B");

    assertEquals(2, arrayQueue.size());
    assertEquals("A", arrayQueue.peek());
    assertEquals("A", arrayQueue.peek());
    assertEquals(2, arrayQueue.size());
  }

  @DisplayName("isEmpty Test")
  @Test
  public void testIsEmptyReturnFalseOnNewQueue(){
    ArrayQueue arrayQueue = new ArrayQueue();
    arrayQueue.enqueue("A");
    assertFalse(arrayQueue.isEmpty());
  }

  @DisplayName("CLEAR, isEmpty Test")
  @Test
  public void testIsEmptyReturnTrueOnQueueAfterClear(){
    ArrayQueue arrayQueue = new ArrayQueue();
    arrayQueue.enqueue("A");
    arrayQueue.enqueue("B");
    assertFalse(arrayQueue.isEmpty());

    arrayQueue.clear();
    assertTrue(arrayQueue.isEmpty());
  }

  @DisplayName("ContainsTrue Test")
  @Test
  public void testContainsReturnTrue() {
    ArrayQueue arrayQueue = new ArrayQueue();
    arrayQueue.enqueue("A");
    arrayQueue.enqueue("B");

    assertTrue(arrayQueue.contains("A"));
  }

  @DisplayName("ContainsFalse Test")
  @Test
  public void testContainsReturnFalse() {
    ArrayQueue arrayQueue = new ArrayQueue();
    arrayQueue.enqueue("A");
    arrayQueue.enqueue("B");

    assertFalse(arrayQueue.contains("C"));
  }

  @DisplayName("ContainsFalseOnEmpty Test")
  @Test
  public void testContainsReturnFalseOnEmptyQueue() {
    ArrayQueue arrayQueue = new ArrayQueue();
    assertFalse(arrayQueue.contains("C"));
  }

  @DisplayName("IllegalStateException Test")
  @Test
  public void testThrowIllegalStateExceptionWhenDequeueOnEmptyQueue(){
    ArrayQueue arrayQueue = new ArrayQueue();

    assertThrows(IllegalAccessException.class, arrayQueue::dequeue);
  }
}
