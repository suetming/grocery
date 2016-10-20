/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.suetming.multithreading;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 *
 * @author suetming <suetming.ma at gmail.com>
 * Copyright(c) @2016 Luoteng Company, Inc. All Rights Reserved.
 */
public class Join implements Runnable {

    public static int a = 0;

    @Override
    public void run() {
        try {
            for (int k = 0; k < 5; k++) {
                a++;
                System.err.println(a);
                Thread.sleep(1000l);

            }

        } catch (InterruptedException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable r = new Join();
        Thread t = new Thread(r);
        t.start();
        t.join();
        System.err.println(a);
    }
}
