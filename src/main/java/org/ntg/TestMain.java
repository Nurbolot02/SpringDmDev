package org.ntg;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestMain {

    public static void main(String[] args) {
        int[] arr = new int[5];
    }
}

class User {
    private String name;
    private static Lock lock = new ReentrantLock();
    private static User user;
    private User(String name){

        this.name = name;
    }
    public static User getUser(String name){
        if (user == null) {
            lock.lock();
            user = new User(name);
            lock.unlock();
        }
        return user;
    }
}