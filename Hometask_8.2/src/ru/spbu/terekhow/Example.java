package ru.spbu.terekhow;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Example {
    private boolean isAlive = true;
    private ExecutorService service;

    public void initialize() {
        f(8);
    }

    private void f(int n) {
        System.out.println(Thread.currentThread().getName() + " " + n);
        if (n == 1) {
            return;
        } else {
            Thread l = new Thread(() -> f(n/2));
            Thread r = new Thread(() -> f(n/2));
            l.start();
            r.start();
            try {
                l.join();
                r.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
