package cn.suetming.multithreading;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 *
 * @author suetming <suetming.ma at gmail.com>
 * Copyright(c) @2016 Luoteng Company, Inc. All Rights Reserved.
 */
public class Synchronized {

    public static class Task {

        public void task1() {
            synchronized (this) { // 对Task对象加锁
                for (int i = 0; i < 5; i++) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                    }
                    System.out.println(Thread.currentThread().getName() + " task 1 synchronized loop " + i);
                }
            }
        }

        public synchronized void task2() { // 对Task对象加锁
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " task 2 synchronized loop " + i);
            }
        }

        public synchronized void task3() { // 对Task对象加锁
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " task 3 synchronized loop " + i);
            }
        }

        public static void task4() {
            synchronized (Task.class) { // 对Task对象加锁
                for (int i = 0; i < 5; i++) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                    }
                    System.out.println(Thread.currentThread().getName() + " task 4 synchronized loop " + i);
                }
            }
        }

        public static synchronized void task5() {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                }
                System.out.println(Thread.currentThread().getName() + " task 5 synchronized loop " + i);
            }
        }
        
        public static synchronized void task6() {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                }
                System.out.println(Thread.currentThread().getName() + " task 6 synchronized loop " + i);
            }
        }
    }

    public static void main(String[] args) {
        // 相同对象和对象方法上加synchronized为互斥锁
//        Task t = new Task();
//        Thread ta = new Thread(t::task1, "A");
//        Thread tb = new Thread(t::task2, "B");
//        Thread tc = new Thread(t::task3, "C");
//        ta.start();
//        tb.start();
//        tc.start();
        
        Thread td = new Thread(Task::task4, "D");
        Thread te = new Thread(Task::task5, "E");
        Thread tf = new Thread(Task::task6, "F");
        td.start();
        te.start();
        tf.start();
    }
}
