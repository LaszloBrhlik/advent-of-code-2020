package com.adventofcode.y2020.day.dec01;

import java.util.ArrayList;
import java.util.HashSet;

import com.adventofcode.y2020.util.FileReaderUtil;
import com.adventofcode.y2020.util.RuntimeUtil;

/**
 * Part I.
 * Find the two entries that sum to 2020; what do you get if you multiply them together?
 * <p>
 * Part II.
 * What is the product of the three entries that sum to 2020?
 */
public class Dec01 {

    public Dec01() {
        final ArrayList<Integer> input = FileReaderUtil.readNumbers("dec01/dec01.csv");

        //If you want to measure runtime performance.
        //RuntimeUtil.startTimer();

        System.out.println("DEC - 01");
        System.out.println("PI.");
        System.out.println("The product of 2: " + this.getProduct2Sol2(input));
        System.out.println("PII.");
        System.out.println("The product of 3: " + this.getProduct3Sol2(input));

        //RuntimeUtil.endTimer();
    }

    private Integer getProduct2Sol1( final ArrayList<Integer> input ) {
        for ( int i = 0; i < input.size() - 1; i++ ) {
            for ( int j = i + 1; j < input.size(); j++ ) {
                if ( input.get(i) + input.get(j) == 2020 ) {
                    System.out.println("first number: " + input.get(i));
                    System.out.println("second number: " + input.get(j));
                    return input.get(i) * input.get(j);
                }
            }
        }
        return 0;
    }

    private Integer getProduct3Sol1( final ArrayList<Integer> input ) {
        for ( int i = 0; i < input.size() - 2; i++ ) {
            for ( int j = i + 1; j < input.size() - 1; j++ ) {
                for ( int k = j + 1; k < input.size(); k++ ) {
                    if ( input.get(i) + input.get(j) + input.get(k) == 2020 ) {
                        System.out.println("first number: " + input.get(i));
                        System.out.println("second number: " + input.get(j));
                        System.out.println("third number: " + input.get(k));
                        return input.get(i) * input.get(j) * input.get(k);
                    }
                }
            }
        } return 0;
    }

    private Integer getProduct2Sol2( final ArrayList<Integer> input ) {
        HashSet<Integer> set = new HashSet<>();
        Integer target = 2020;
        for ( int i = 0; i < input.size(); i++ ) {
            Integer pair = target - input.get(i);
            if ( set.contains(pair) ) {
                System.out.println("first number: " + pair);
                System.out.println("second number: " + input.get(i));
                return input.get(i) * pair;
            } else {
                set.add(input.get(i));
            }
        }
        return 0;
    }

    private Integer getProduct3Sol2( final ArrayList<Integer> input ) {
        Integer target = 2020;
        for ( int i = 0; i < input.size(); i++ ) {
            HashSet<Integer> set = new HashSet<>();
            Integer sumMinusFirst = target - input.get(i);
            for ( int j = i + 1; j < input.size(); j++ ) {
                Integer sumMinusSecond = sumMinusFirst - input.get(j);
                if ( set.contains(sumMinusSecond) ) {
                    System.out.println("first number: " + sumMinusSecond);
                    System.out.println("second number: " + input.get(j));
                    System.out.println("third number: " + input.get(i));
                    return input.get(i) * input.get(j) * sumMinusSecond;
                } else {
                    set.add(input.get(j));
                }
            }
        }
        return 0;
    }
}
