package com.luxoft.datastructures.list;

/*
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
  public boolean set(int index, Object item);

  public Object[] toArray();
 */

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListTest {
  @DisplayName("Default constructor, isEmpty and Add method")
  @Test
  public void testDefaultConstructorAndAddMethod(){
    List arrayList = new ArrayList();

    assertTrue(arrayList.isEmpty());
    assertTrue(arrayList.add("A"));
    assertFalse(arrayList.isEmpty());
  };

  // Добавление нулевого элемента
  @DisplayName("Default constructor (with NULL), isEmpty and Add method")
  @Test
  public void testDefaultConstructorAndAddMethodWidthNull(){
    List arrayList = new ArrayList();

    assertTrue(arrayList.isEmpty());
    assertTrue(arrayList.add(null));
    assertFalse(arrayList.isEmpty());
  };

  @DisplayName("Constructor width List")
  @Test
  public void testConstructorWidthList(){
    List origin = new ArrayList();
    origin.add("A");
    origin.add("B");
    origin.add("C");

    List testOrigin = new ArrayList(origin);
    assertFalse(testOrigin.isEmpty());
    assertEquals(testOrigin.size(), origin.size());
  };

  // Добавление нулевого элемента
  @DisplayName("Constructor *(WithNull) width List")
  @Test
  public void testConstructorWidthListWithNull(){
    List origin = new ArrayList();
    origin.add("A");
    origin.add(null);
    origin.add("C");

    List testOrigin = new ArrayList(origin);
    assertFalse(testOrigin.isEmpty());
    assertEquals(testOrigin.size(), origin.size());
  };

  @DisplayName("#3: Constructor width Array")
  @Test
  public void testConstructorWidthArray(){
    String[] origin = {"A", null, "C"};

    List testOrigin = new ArrayList(origin);
    assertFalse(testOrigin.isEmpty());
    assertEquals(origin.length, testOrigin.size());
    assertEquals(3, testOrigin.size());
  };

  @DisplayName("#4: Add width index and get")
  @Test
  public void testAddMethodsWidthIndex(){
    List arrayList = new ArrayList(new String[]{"A", "B", "C"});

    assertTrue(arrayList.add(2, "D"));
    assertEquals("A", arrayList.get(0));
    assertEquals("B", arrayList.get(1));
    assertEquals("D", arrayList.get(2));
    assertEquals("C", arrayList.get(3));
  }

  @DisplayName("#4.1: (NULL) Add width index and get")
  @Test
  public void testAddMethodsWidthIndexWithNull(){
    List arrayList = new ArrayList(new String[]{"A", null, "C"});

    assertTrue(arrayList.add(2, null));
    assertEquals("A", arrayList.get(0));
    assertNull(arrayList.get(1));
    assertNull(arrayList.get(2));
    assertEquals("C", arrayList.get(3));
    assertEquals(4, arrayList.size());
  }

  @DisplayName("Add list")
  @Test
  public void testAddAllOfList(){
    List arrayList = new ArrayList();
    assertTrue(arrayList.isEmpty());
    arrayList.add("AA");

    List listSourse = new ArrayList(new String[]{"A", "B", "C"});
    assertTrue(arrayList.addAll(listSourse));
    assertEquals(4, arrayList.size());
    assertEquals("AA", arrayList.get(0));
    assertEquals("A", arrayList.get(1));
    assertEquals("B", arrayList.get(2));
    assertEquals("C", arrayList.get(3));
  }

  @DisplayName("Add array")
  @Test
  public void testAddAllOfArray(){
    List arrayList = new ArrayList();
    assertTrue(arrayList.isEmpty());
    arrayList.add("AA");

    String[] arrSource = new String[]{"A", "B", "C"};
    assertTrue(arrayList.addAll(arrSource));
    assertEquals(4, arrayList.size());
    assertEquals("AA", arrayList.get(0));
    assertEquals("A", arrayList.get(1));
    assertEquals("B", arrayList.get(2));
    assertEquals("C", arrayList.get(3));
  }

  @DisplayName("Add all (list) list width index")
  @Test
  public void testAddAllOfListWidthIndex(){
    List arrayList = new ArrayList();
    assertTrue(arrayList.isEmpty());
    arrayList.add("AA");
    arrayList.add("BB");
    arrayList.add("CC");

    List listSource = new ArrayList(new String[]{"A", "B", "C"});
//    String[] expected = new String[]{"AA", "A", "B", "C", "BB", "CC"};

    assertTrue(arrayList.addAll(1, listSource));
    assertEquals(6, arrayList.size());
    assertEquals("AA", arrayList.get(0));
    assertEquals("A", arrayList.get(1));
    assertEquals("B", arrayList.get(2));
    assertEquals("C", arrayList.get(3));
    assertEquals("BB", arrayList.get(4));
    assertEquals("CC", arrayList.get(5));
  }

  @DisplayName("Add all (array) width index")
  @Test
  public void testAddAllOfArrayWidthIndex(){
    List arrayList = new ArrayList();
    assertTrue(arrayList.isEmpty());
    arrayList.add("AA");
    arrayList.add("BB");
    arrayList.add("CC");

    String[] arrSource = new String[]{"A", "B", "C"};
    String[] expected = new String[]{"AA", "A", "B", "C", "BB", "CC"};

    assertTrue(arrayList.addAll(1, arrSource));
    assertEquals(6, arrayList.size());
    assertEquals("AA", arrayList.get(0));
    assertEquals("A", arrayList.get(1));
    assertEquals("B", arrayList.get(2));
    assertEquals("C", arrayList.get(3));
    assertEquals("BB", arrayList.get(4));
    assertEquals("CC", arrayList.get(5));
  }

  @Test
  public void testClear(){
    List arrayList = new ArrayList(new String[]{"A", "B", "C"});
    assertFalse(arrayList.isEmpty());
    assertEquals(3, arrayList.size());

    arrayList.clear();
    assertTrue(arrayList.isEmpty());
  }


  @Test
  public void testClone(){
    List arrayList = new ArrayList(new String[]{"A", "B", "C"});
    List cloneList = arrayList.clone();

    assertEquals(arrayList.size(), cloneList.size());
    assertArrayEquals(arrayList.toArray(), cloneList.toArray());

    arrayList.clear();
    assertNotEquals(arrayList.size(), cloneList.size());
    assertNotEquals(arrayList.toString(), cloneList.toString());
  }

  @Test
  public void testContains(){
    List arrayList = new ArrayList(new String[]{"A", "B", "C"});
    assertTrue(arrayList.contains("B"));
    assertFalse(arrayList.contains("D"));
  }

  @Test
  public void testGet(){
    List arrayList = new ArrayList(new String[]{"A", "B", "C"});

    assertEquals("A", arrayList.get(0));
    assertEquals("B", arrayList.get(1));
    assertEquals("C", arrayList.get(2));
    assertThrows(IndexOutOfBoundsException.class, () -> arrayList.get(-1));
    assertThrows(IndexOutOfBoundsException.class, () -> arrayList.get(3));
  }

  @Test
  public void testIndexOf(){
    List arrayList = new ArrayList(new String[]{"A", "B", "C"});
    assertEquals(2, arrayList.indexOf("C"));
    assertEquals(-1, arrayList.indexOf("D"));
  }

  @Test
  public void testLastIndexOf(){
    List arrayList = new ArrayList(new String[]{"A", "B", "C", "A"});
    assertEquals(3, arrayList.lastIndexOf("A"));
    assertNotEquals(2, arrayList.lastIndexOf("A"));
    assertEquals(-1, arrayList.indexOf("D"));
  }

  @DisplayName("Remove by index")
  @Test
  public void testRemove(){
    List emptyArrayList = new ArrayList();
    assertFalse(emptyArrayList.remove(2));
    assertEquals(0, emptyArrayList.size());

    List arrayList = new ArrayList(new String[]{"A", "B", "C", "D"});
    assertEquals(4, arrayList.size());

    assertTrue(arrayList.remove(2)); // удаляем С
    assertEquals(3, arrayList.size());
    assertTrue(arrayList.remove(1)); // удаляем B
    assertEquals(2, arrayList.size());

    String[] expected = new String[]{"A", "D"};
    assertArrayEquals(expected, arrayList.toArray());
  }


  @DisplayName("Remove by value")
  @Test
  public void testRomoveByValue(){
    // тестим удаление с пустого ArrayList
    List emptyArrayList = new ArrayList();
    assertFalse(emptyArrayList.remove("A"));
    assertEquals(0, emptyArrayList.size());

    // тестим удаление из ArrayList с одним элементом
    List arrayListOne = new ArrayList();
    assertTrue(arrayListOne.add("AA"));
    assertEquals(1, arrayListOne.size());
    assertFalse(arrayListOne.isEmpty());
    assertTrue(arrayListOne.remove("AA"));
    assertEquals(0, arrayListOne.size());
    assertTrue(arrayListOne.isEmpty());

    // много элементов
    List arrayList = new ArrayList(new String[]{"A", "B", "C", "D"});
    assertEquals(4, arrayList.size());

    assertTrue(arrayList.remove("C")); // удаляем С
    assertEquals(3, arrayList.size());
    assertTrue(arrayList.remove("B")); // удаляем B
    assertEquals(2, arrayList.size());

    String[] expected = new String[]{"A", "D"};
    assertArrayEquals(expected, arrayList.toArray());

  }
}
