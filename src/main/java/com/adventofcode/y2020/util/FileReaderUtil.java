package com.adventofcode.y2020.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReaderUtil {

    private static final String REL_PATH_PREFIX = "src/main/resources/";

    public static ArrayList<Integer> readNumbers( final String fileName ) {
        ArrayList<Integer> numbers = new ArrayList<>();
        Scanner s;
        try {
            s = new Scanner(new File(REL_PATH_PREFIX + fileName));
            while ( s.hasNextInt() ) {
                numbers.add(s.nextInt());
            }
            s.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return numbers;
    }

    public static ArrayList<String> readLines( final String fileName ) {
        ArrayList<String> lines = new ArrayList<>();
        Scanner s;
        try {
            s = new Scanner(new File(REL_PATH_PREFIX + fileName));
            while ( s.hasNextLine() ) {
                lines.add(s.nextLine());
            }
            s.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return lines;
    }
}
