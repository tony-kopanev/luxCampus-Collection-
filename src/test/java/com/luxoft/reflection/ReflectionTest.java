package com.luxoft.reflection;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

import static org.junit.jupiter.api.Assertions.*;

public class ReflectionTest {
  //  Метод принимает класс и возвращает созданный объект этого класса
  @Test
  public void testNewInstance() throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
    MySomeClass clazz = (MySomeClass) Reflection.setNewInstance(MySomeClass.class);
    assertNotNull(clazz);
    clazz.setName("Mike");
    clazz.setAge(36);
    clazz.setSex(true);

    assertEquals("Mike", clazz.getName());
    assertEquals(36, clazz.getAge());
    assertEquals("MySomeClass", clazz.getClass().getSimpleName());
  }

  // Метод принимает object и вызывает у него все методы без параметров
  @Test
  public void testCallMethodsWithoutArgs() throws InvocationTargetException, IllegalAccessException {
    MyClass2 testClass = new MyClass2();
    List<String> actual = Reflection.callAllMethodsWithoutArgs(testClass);

    assertNotNull(actual);
    assertTrue(actual.contains("Heisenberg"));
    assertTrue(actual.contains("Albuquerque"));
  }

  // Метод принимает object и выводит на экран все сигнатуры методов в который есть final
  // чисто для теста метода, сохраняем все в массив, и сравниваем уже массивы
  @Test
  public void testGetSignaturesWithFinal(){
    String[] actual = Reflection.getSignaturesWithFinal(new MySomeClass());
    String[] expected = new String[]{"private void com.luxoft.reflection.MySomeClass.finalTestMethod(java.lang.String)"};

    assertNotNull(actual);
    assertEquals(1, actual.length);
    assertArrayEquals(expected, actual);
  }

  //  Метод принимает Class и выводит все не публичные методы этого класса
  /// Также для теста помимо вывода, результат сохраняю в массив, и сравниваю массивы
  @Test
  public void testGetPrivateMethodsOfClass(){
    String[] actual = Reflection.getPrivateMethodsOfClass(MySomeClass.class);
    String[] expected = new String[]{"private void com.luxoft.reflection.MySomeClass.finalTestMethod(java.lang.String)"};

    assertNotNull(actual);
    assertEquals(1, actual.length);
    assertArrayEquals(expected, actual);
  }

  // Метод принимает Class и выводит всех предков класса и все интерфейсы которое класс имплементирует
  // Для теста помимо вывода, результат сохраняю в массив, и сравниваю массивы
  @Test
  public void testGetAllParentOfTheClasAndInterFaces(){
    String[] expected = new String[]{
      "java.util.List",
      "java.util.RandomAccess",
      "java.lang.Cloneable",
      "java.io.Serializable",
      "java.util.AbstractList",
      "java.util.List",
      "java.util.AbstractCollection",
      "java.util.Collection",
      "java.lang.Object"
    };

    String[] actual = Reflection.getAllParentOfTheClasAndInterFaces(ArrayList.class);
    assertNotNull(actual);
    assertEquals(9, actual.length);
    assertArrayEquals(expected, actual);
  }

  // Метод принимает объект и меняет всего его приватные поля на их нулевые значение (null, 0, false etc)+
  @Test
  public void testSetNullsValuesPrivatFields() throws IllegalAccessException {
    MySomeClass mySomeClass = new MySomeClass("Mike", 111, 56, true);
    Reflection.setNullsValuesPrivatFields(mySomeClass);

    assertNull(mySomeClass.getName());
    assertEquals(0, mySomeClass.getId());
    assertEquals(0, mySomeClass.getAge());
    assertFalse(mySomeClass.isSex());
  }
}
