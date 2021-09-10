package com.iarina.zigzag_coversion;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ZigZag {

    private String textValue;

    public ZigZag(String textValue) {
        this.textValue = textValue;
    }

    @Override
    public String toString() {
        return textValue;
    }

    public String convert(int numRows) {
        if (textValue.length() < 2 || numRows < 2)
            return textValue;

        List<StringBuilder> sConverted = Stream.generate(StringBuilder::new)
                .limit(numRows).collect(Collectors.toList());
        int level = 0;
        boolean isDecreasing = true;

        for (char c : textValue.toCharArray()) {
            sConverted.get(level).append(c);
            if (level == 0)
                isDecreasing = true;
            else if (level == numRows - 1)
                isDecreasing = false;
            level += !isDecreasing ? -1 : 1;
        }

        return String.join("", sConverted);
    }

}
