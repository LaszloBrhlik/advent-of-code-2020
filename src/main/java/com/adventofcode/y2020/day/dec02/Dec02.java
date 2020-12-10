package com.adventofcode.y2020.day.dec02;

import java.util.ArrayList;

import com.adventofcode.y2020.util.FileReaderUtil;

/**
 * Part I.
 * The password policy indicates the lowest and highest number of times a given letter must appear for the password to be valid.
 * How many passwords are valid?
 * <p>
 * Part II.
 * Each policy actually describes two positions in the password, where 1 means the first character, 2 means the second character, and so on.
 * (Be careful; Toboggan Corporate Policies have no concept of "index zero"!) Exactly one of these positions must contain the given letter.
 * Other occurrences of the letter are irrelevant for the purposes of policy enforcement.
 */
public class Dec02 {

    public Dec02() {
        final ArrayList<String> input = FileReaderUtil.readLines("dec02/dec02.csv");

        System.out.println("DEC - 02");
        System.out.println("PI.");
        System.out.println("Valid passwords: " + this.getValidNumbers1(input));
        System.out.println("PII.");
        System.out.println("Valid passwords: " + this.getValidNumbers2(input));
    }

    private int getValidNumbers1( final ArrayList<String> input ) {
        int validCount = 0;
        int minOccurrence;
        int maxOccurrence;
        char key;
        String password;

        for ( final String line : input ) {
            int occurrence = 0;
            minOccurrence = Integer.valueOf(line.substring(0, line.indexOf('-')));
            maxOccurrence = Integer.valueOf(line.substring(line.indexOf('-') + 1, line.indexOf(' ')));
            key = line.substring(line.indexOf(' ') + 1, line.indexOf(':')).toCharArray()[0];
            password = line.substring(line.indexOf(':') + 2);

            for ( final char pwChar : password.toCharArray() ) {
                if ( pwChar == key ) {
                    occurrence++;
                }
            }

            if ( minOccurrence <= occurrence && occurrence <= maxOccurrence ) {
                validCount++;
            }
        }

        return validCount;
    }

    private int getValidNumbers2( final ArrayList<String> input ) {
        int validCount = 0;
        int minOccurrence;
        int maxOccurrence;
        char key;
        char[] password;

        for ( final String line : input ) {
            int posCounter = 0;
            minOccurrence = Integer.valueOf(line.substring(0, line.indexOf('-')));
            maxOccurrence = Integer.valueOf(line.substring(line.indexOf('-') + 1, line.indexOf(' ')));
            key = line.substring(line.indexOf(' ') + 1, line.indexOf(':')).toCharArray()[0];
            password = line.substring(line.indexOf(':') + 2).toCharArray();

            if ( password[minOccurrence - 1] == key ) {
                posCounter++;
            }

            if ( password[maxOccurrence - 1] == key ) {
                posCounter++;
            }

            if (posCounter == 1) {
                validCount++;
            }
        }

        return validCount;
    }
}
