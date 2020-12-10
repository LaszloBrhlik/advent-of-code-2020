package com.adventofcode.y2020;

import com.adventofcode.y2020.day.dec01.Dec01;
import com.adventofcode.y2020.day.dec02.Dec02;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RunApplication {

    public static void main( String[] args ) {
        SpringApplication.run(RunApplication.class, args);

        new Dec02();
    }
}
