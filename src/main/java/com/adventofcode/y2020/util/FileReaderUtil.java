package com.adventofcode.y2020.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReaderUtil {

    private static final String REL_PATH_PREFIX = "src/main/resources/dec01/";

    public static ArrayList<Integer> readNumbers( final String fileName ) {
        ArrayList<Integer> list = new ArrayList<>();
        Scanner s;
        try {
            s = new Scanner(new File(REL_PATH_PREFIX + fileName));
            while ( s.hasNextInt() ) {
                list.add(s.nextInt());
            }
            s.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return list;
    }
}
