package com.luxoft.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Reflection {

  // Метод принимает класс и возвращает созданный объект этого класса
  public static Object setNewInstance(Class<MySomeClass> clazz) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    return clazz.getDeclaredConstructor().newInstance();
  }

  // Метод принимает object и вызывает у него все методы без параметров
  public static List<String> callAllMethodsWithoutArgs(Object object) throws InvocationTargetException, IllegalAccessException {
    List<String> result = new ArrayList<>();
    Method[] methods = object.getClass().getDeclaredMethods();
    for(Method curMethod: methods){
      curMethod.setAccessible(true);
      result.add((String) curMethod.invoke(object));
    }
    return result;
  }

  // Метод принимает object и выводит на экран все сигнатуры методов в который есть final
  public static String[] getSignaturesWithFinal(Object object){
    List<String> result = new ArrayList<>();

    Arrays.stream(MySomeClass.class.getDeclaredMethods()).forEach(method -> {
      if(method.toString().contains("final")) result.add(method.toString());
    });

    result.forEach(System.out::println);
    return result.toArray(String[]::new);
  }

  //  Метод принимает Class и выводит все не публичные методы этого класса
  public static String[] getPrivateMethodsOfClass(Class clazz){
    Arrays.stream(MySomeClass.class.getDeclaredMethods())
            .filter(method -> Modifier.isPrivate(method.getModifiers()))
            .forEach(System.out::println);

    /// вернем массив для тестов:
    return Arrays.stream(MySomeClass.class.getDeclaredMethods())
            .filter(method -> Modifier.isPrivate(method.getModifiers()))
            .map(Method::toString)
            .toArray(String[]::new);
  }

  // Метод принимает Class и выводит всех предков класса и все интерфейсы которое класс имплементирует
  public static String[] getAllParentOfTheClasAndInterFaces(Class clazz){
    List<String> result = new ArrayList<>();
    Class curInstance = clazz;
    while (true){
      // заносим все интерфейсы в result, ну и выводим на экран
      Arrays.stream(curInstance.getInterfaces()).forEach(interf -> result.add(interf.getName()));
      Arrays.stream(curInstance.getInterfaces()).forEach(interf -> System.out.println(interf.getName()));
      // получим класс родитель и запишем в result
      curInstance = curInstance.getSuperclass();
      // выводим предка
      result.add(curInstance.getName());
      System.out.println(curInstance.getName());
      // возвращаем результат, когда доберемся до родителя Object
      if(curInstance.getSimpleName().equals("Object")){
        return result.toArray(String[]::new);
      }
    }
  }

  // Метод принимает объект и меняет всего его приватные поля на их нулевые значение (null, 0, false etc)+
  public static void setNullsValuesPrivatFields(Object object) throws IllegalAccessException {
    List<String> primitives = new ArrayList<>(List.of(new String[]{"int", "byte", "double", "long"}));
    for(Field f: object.getClass().getDeclaredFields()){
      if(Modifier.isPrivate(f.getModifiers())){
        f.setAccessible(true);
        if(primitives.contains(f.getType().toString())){
          f.set(object, 0);
        } else if(f.getType().toString().equals("boolean")){
          f.set(object, false);
        } else {
          f.set(object, null);
        }
      }
    }
  }
}
