package com.luxoft.lesson15;

public class UserDao {
  public void saveUser(String user) {
    System.out.println("[start] Save user to db");

    try {
      Thread.sleep((long) (Math.random() * 5_000));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("[finish] Save user to db");
  }
}
