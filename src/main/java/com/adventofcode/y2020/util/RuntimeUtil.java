package com.adventofcode.y2020.util;

import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;

public class RuntimeUtil {

    private static Stopwatch stopwatch;

    public static void startTimer() {
        if ( stopwatch == null ) {
            stopwatch = Stopwatch.createStarted();
        } else {
            stopwatch.start();
        }
    }

    public static void endTimer() {
        stopwatch.stop();
        System.out.println("Time elapsed: " + stopwatch.elapsed(TimeUnit.MILLISECONDS));
        stopwatch.reset();
    }
}
