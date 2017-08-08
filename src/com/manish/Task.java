package com.manish;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by mmaheshwari on 08/08/17.
 */
public class Task implements Runnable {

    private ThreadLocal<List<Set>> threadLocal =
            new ThreadLocal<List<Set>>();

    @Override
    public void run() {
        float freeFraction = (Runtime.getRuntime().freeMemory()*1.0F)/Runtime.getRuntime().maxMemory();
        System.out.println("Executing thread Id: " + Thread.currentThread().getId() +
                ", Total Memory: " + Runtime.getRuntime().maxMemory() +
                ", Free Memory: " + Runtime.getRuntime().freeMemory() +
                ", freeFraction: " + freeFraction);
        threadLocal.get().add(new HashSet(16));

    }


}

