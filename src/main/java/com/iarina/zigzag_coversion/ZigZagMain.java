package com.iarina.zigzag_coversion;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ZigZagMain {

    public static void main(String[] args) {
        System.out.println(Solution.convert("PAYPALISHIRING", 3));
        System.out.println(Solution.convert("PAYPALISHIRING", 4));
    }

    static class Solution {
        public static String convert(String s, int numRows) {
            if (s.length() < 2 || numRows < 2)
                return s;

            List<StringBuilder> sConverted = Stream.generate(StringBuilder::new)
                    .limit(numRows).collect(Collectors.toList());
            int level = 0;
            boolean isDecreasing = true;

            for (char c : s.toCharArray()) {
                sConverted.get(level).append(c);
                if (level == 0)
                    isDecreasing = true;
                else if (level == numRows - 1)
                    isDecreasing = false;
                level += !isDecreasing ? -1 : 1;
            }

            return sConverted.stream().collect(Collectors.joining());
        }
    }


}
