package com.platform.utils;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public final class ExecutorProvider {

    private static Executor EXECUTOR = null;

    public static Executor getExecutor(Integer size) {
        if (EXECUTOR == null) {
            EXECUTOR = Executors.newFixedThreadPool(Math.min(size, 50), r -> {
                Thread thread = new Thread(r);
                thread.setDaemon(true);
                return thread;
            });
        }
        return EXECUTOR;
    }
}
