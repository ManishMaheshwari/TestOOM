package com.manish;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        Thread.setDefaultUncaughtExceptionHandler((thread, throwable) -> {
            System.out.format("Caught {}, from ThreadId {}. This message printed by: {} %n",
                    throwable.getClass(), thread.getId(), Thread.currentThread().getId());

        });

        ExecutorService fixedPool = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 1000000000; i++) {
            fixedPool.submit(new Task());
        }
    }

}
