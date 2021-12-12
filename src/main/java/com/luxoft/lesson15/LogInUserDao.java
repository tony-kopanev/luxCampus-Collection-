package com.luxoft.lesson15;

public class LogInUserDao implements UserDao {
  private UserDao target;

  public LogInUserDao(UserDao target) {
    this.target = target;
  }

  @Override
  public void saveUser(String user) {
    long start = System.currentTimeMillis();
    target.saveUser(user);
    long finish = System.currentTimeMillis();
    long time = finish - start;
    System.out.printf("save user %s, took: %d ms", user, time);
  }
}
