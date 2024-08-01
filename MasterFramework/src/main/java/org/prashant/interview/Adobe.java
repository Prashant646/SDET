package org.prashant.interview;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Adobe {

    public String transform(String s) {

        String transFormedString = "";
        String[] strarr = s.split(" ");

        for (String s1 : strarr) {
            transFormedString += transfromFirstChar(s1) + " ";
        }
        return transFormedString.trim();
    }

    public String transfromFirstChar(String s) {

        String transformedString = "";
        transformedString += Character.toUpperCase(s.charAt(0));
        transformedString += s.substring(0);
        return transformedString;

    }

    static boolean isSubSequence(String A, String B) {
        int i = 0;
        int j = 0;
        while (i < A.length() && j < B.length()) {
            if (A.charAt(i) == B.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == A.length();
    }

    static String firstRepChar(String s) {
        int index = 0;
        HashSet<Character> set = new HashSet<Character>();
        for (char c : s.toCharArray()) {
            if (!set.add(c)) {
                index = s.indexOf(c);
            }
        }
        return String.valueOf(s.charAt(index));
    }

    private static Integer sumOfListUsingReduce() {
        List<Integer> list = Arrays.asList(1, 3, 5, 5);
        Optional<Integer> optional = list.stream().reduce((a, b) -> a + b);
        return optional.get();
    }


    public static void main(String[] args) {

    }
}