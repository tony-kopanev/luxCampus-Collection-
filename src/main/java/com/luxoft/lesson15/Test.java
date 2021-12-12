package com.luxoft.lesson15;

public class Test {
  public static void main(String[] args) {
    UserDao userDao = ApplicationContext.getUserDao();

    userDao.saveUser("Tony");
  }
}

class ApplicationContext {
  static UserDao getUserDao() {
    TransactionUserDao transactionUserDao = new TransactionUserDao(new DbUserDao());
    return new LogInUserDao(transactionUserDao);
  }
}

//  15_01:12:00
