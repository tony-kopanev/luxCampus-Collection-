package com.luxoft.lesson15;

public class TransactionUserDao implements UserDao {
  private UserDao target;

  public TransactionUserDao(UserDao target) {
    this.target = target;
  }

  @Override
  public void saveUser(String user) {
    System.out.println("Start transaction");
    target.saveUser(user);
    System.out.println("Commit transaction");
  }
}
