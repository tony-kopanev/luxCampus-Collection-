package com.luxoft.datastructures.queue;

public class ArrayQueue implements Queue {
  private Object[] array;
  private int size = 0;

  private boolean enqueueVal(Object val){
    for(int i=0; i<size; i++){
      if(array[i] == null){
        array[i] = val;
        return true;
      }
    }

    return false;
  }

  @Override
  public void enqueue(Object val) {
    if(array == null || array.length == 0){
      array = new Object[10];
    }

    boolean isEnqueued = enqueueVal(val);
    size++;
    // проверяем если не добавилось
    while (!isEnqueued){
      // увеличиваем размер
      Object[] newArray = new Object[(int)(array.length * 1.5)];

      // копируем массив значений
      if (size >= 0) System.arraycopy(array, 0, newArray, 0, size);
//      array = newArray;
      isEnqueued = enqueueVal(val);
    }
  }

  @Override
  public Object dequeue() throws IllegalAccessException {
    // проверим чтобы очередь не была пустой
    if(isEmpty()){
      throw new IllegalAccessException("Our queue is empty!");
    }

    // В очереди что-то есть...
    Object result = array[0];

    System.arraycopy(array, 1, array, 0, array.length-2);
    size--;
    return result;
  }

  @Override
  public Object peek() {
    return array[0];
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public boolean contains(Object val) {
    for(int i=0; i<size; i++){
      if(array[i].equals(val)){
        return true;
      }
    }
    return false;
  }

  @Override
  public void clear() {
    array = new Object[array.length];
    size = 0;
  }
}
