package com.luxoft.lesson15;

public class Test {
  public static void main(String[] args) {
    UserDao userDao = ApplicationContext.getUserDao();

    userDao.saveUser("Tony");
  }
}

class ApplicationContext {
  static UserDao getUserDao() {
    return new UserDao();
  }
}

//  15_01:04:26
