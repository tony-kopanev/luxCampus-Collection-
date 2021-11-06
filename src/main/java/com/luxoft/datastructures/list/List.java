package com.luxoft.datastructures.list;

public interface List {
  public boolean add(Object item);
  public boolean add(int index, Object item);

  public boolean addAll(List list);
  public boolean addAll(Object[] array);
  public boolean addAll(int index, List list);
  public boolean addAll(int index, Object[] array);

  public void clear();
  public List clone();
  public boolean contains(Object item);

  public Object get(int index);
  public int indexOf(Object item);
  public boolean isEmpty();
  public int lastIndexOf(Object item);

  public boolean remove(int index);
  public boolean remove(Object item);
  public boolean removeAll(List list);
  public boolean removeAll(Object[] arrayRemove);
  public boolean set(int index, Object item);
  public int size();

  public Object[] toArray();
}
