package com.luxoft.reflection;

public class MySomeClass {
  private String name;
  private int id, age;
  private boolean sex = true;
  private final String testFinal = "testFinal";

  public MySomeClass(){}

  public MySomeClass(String name, int id, int age){
    this.name = name;
    this.id = id;
    this.age = age;
  }

  public MySomeClass(String name, int id, int age, boolean sex){
    this(name, id, age);
    this.sex = sex;
  }

  public String getName() {
    return name;
  }

  private void finalTestMethod(final String str){
    System.out.println(str);
  }

  public int getId() {
    return id;
  }

  public int getAge() {
    return age;
  }

  public boolean isSex() {
    return sex;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public void setSex(boolean sex) {
    this.sex = sex;
  }

  @Override
  public String toString(){
    String result = String.format("User #%d;\nName: %s;\nAge:%d;\n", id, name, age);
    result += sex ? "Sex: male" : "Sex: female";
    return result;
  }
}
