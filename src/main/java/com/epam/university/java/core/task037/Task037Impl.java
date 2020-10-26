package com.epam.university.java.core.task037;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Task037Impl implements Task037 {
    @Override
    public Collection<String> switcher(Callable<String> ticker, Callable<String> tacker) {
        if (ticker == null || tacker == null) {
            throw new IllegalArgumentException();
        }
        List<String> tickTacks = new ArrayList<>();
        ExecutorService executor1 = Executors.newFixedThreadPool(1);
        Future<String> future1 = executor1.submit(tacker);
        ExecutorService executor2 = Executors.newFixedThreadPool(1);
        Future<String> future2 = executor2.submit(ticker);
        for (int i = 0; i < 5; i++) {
            try {
                tickTacks.add(future2.get());
                tickTacks.add(future1.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        return tickTacks;
    }
}
