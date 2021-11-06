package com.luxoft.datastructures.list;

import com.luxoft.datastructures.list.List;

import javax.management.ObjectName;
import java.util.Arrays;
import java.util.Objects;

public class ArrayList implements List {
  private int capacity = 10, size = 0;
  private Object[] array = null;

  public ArrayList(){
    array = new Object[capacity];
  }

  public ArrayList(List list){
    if(list != null){
      array = list.toArray();
      size = list.size();
      ensureCapacity(list.size());
      array = new Object[capacity];
      System.arraycopy(list.toArray(), 0, array, 0, list.size());
    } else this.array = new Object[capacity];
  }

  public ArrayList(Object[] array){
    if(array != null){
      ensureCapacity(array.length);
      this.array = new Object[capacity];
      System.arraycopy(array, 0, this.array, 0, array.length);
      size = array.length;
    } else {
      this.array = new Object[capacity];
    }
  }

  public ArrayList(int initialCapacity){
    capacity = Math.max(initialCapacity, 10);
    array = new Object[capacity];
  }

  private void ensureCapacity(int minCapacity){
    if(minCapacity > capacity){
      capacity = (int)(minCapacity * 1.5);
      Object[] newArr = new Object[capacity];
      System.arraycopy(array, 0, newArr, 0, array.length);
      array = newArr;
    }
  }

  @Override
  public boolean add(Object item) {
    size++;
    ensureCapacity(size);
    array[size-1] = item;
    return Objects.equals(array[size-1], item);
  }

  @Override
  public boolean add(int index, Object item) {
    size++;
    ensureCapacity(size);

    System.arraycopy(array, index, array, index+1, size-index-1);
    array[index] = item;
    return Objects.equals(array[index], item);
  }

  @Override
  public boolean addAll(List list) {
    if(list.size() <= 0) return true;

    ensureCapacity(list.size() + size);
    System.arraycopy(list.toArray(), 0, array, size, list.size());
    size += list.size();
    return array[size-1].equals(list.get(list.size()-1));
  }

  @Override
  public boolean addAll(Object[] array) {
    if(array.length == 0) return true;

    ensureCapacity(array.length + size);
    System.arraycopy(array, 0, this.array, size, array.length);
    size += array.length;
    return this.array[size-1].equals(array[array.length-1]);
  }

  @Override
  public boolean addAll(int index, List list) {
    if(list.size() <= 0) return true;

    ensureCapacity(list.size() + size);
    System.arraycopy(array, index, array, list.size()+1, size-index);
    System.arraycopy(list.toArray(), 0, array, index, list.size());

    size += list.size();
    return array[size-list.size()].equals(list.get(list.size()-1));
  }

  @Override
  public boolean addAll(int index, Object[] array) {
    if(array.length <= 0) return true;

    ensureCapacity(array.length + size);
    System.arraycopy(this.array, index, this.array, array.length+1, size-index);
    System.arraycopy(array, 0, this.array, index, array.length);

    size += array.length;
    return this.array[size- array.length].equals(array[array.length-1]);
  }

  @Override
  public void clear() {
    array = new Object[capacity];
    size = 0;
  }

  @Override
  public List clone() {
    return new ArrayList(toArray());
  }

  @Override
  public boolean contains(Object item) {
    if(size == 0) return false;
    for(int i=0; i<size; i++){
      if(array[i].equals(item)) return true;
    }

    return false;
  }

  @Override
  public Object get(int index) {
    if(index < 0 || index >= size){
      String testErr = index >= size
        ? String.format("Your index: %d is more than max.index: %d!", index, size-1)
        : String.format("Your index: %d, can't be less than zero", index);
      throw new IndexOutOfBoundsException(testErr);
    }
    return array[index];
  }

  @Override
  public int indexOf(Object item) {
    if(size == 0) return -1;
    for(int i=0; i<size; i++){
      if(array[i].equals(item)) return i;
    }

    return -1;
  };

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public int lastIndexOf(Object item) {
    if(size == 0) return -1;
    for(int i=size-1; i>=0; i--){
      if(array[i].equals(item)) return i;
    }
    return -1;
  }

  @Override
  public boolean remove(int index) {
    if(size == 0) return false;
    else if(size == 1){
      clear();
      return true;
    }

    Object[] newResult = new Object[capacity];
    for(int i=0, j=0; i<size; i++){
      if(i != index){
        newResult[j] = array[i];
        j++;
      }
    }

    array = newResult;
    size--;
    return true;
  }

  @Override
  public boolean remove(Object item) {
    if(size == 0) return false;
    else if(size == 1){
      clear();
      return true;
    }

    Object[] newResult = new Object[capacity];
    int j = 0;
    for(Object curItem: array){
      if(!Objects.equals(curItem, item)){
        newResult[j] = curItem;
        j++;
      }
    }

    array = newResult;
    size--;
    return true;
  }

  @Override
  public boolean removeAll(List list) {
    return false;
  }

  @Override
  public boolean set(int index, Object item) {
    return false;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public Object[] toArray() {
    Object[] result = new Object[size];
    System.arraycopy(array, 0, result, 0, size);

    return result;
  }

  @Override
  public String toString() {
    return Arrays.toString(toArray());
  }
}
