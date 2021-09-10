package com.iarina.zigzag_coversion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ZigZagTest {

    private ZigZag zigZag;
    private ZigZag zigZagS;

    @BeforeEach
    private void init() {
        zigZag = new ZigZag("PAYPALISHIRING");
        zigZagS = new ZigZag("P");
    }

    @Test
    void convert_with_3rows() {
        Assertions.assertEquals("PAHNAPLSIIGYIR", zigZag.convert(3));
    }

    @Test
    void convert_with_4rows() {
        Assertions.assertEquals("PINALSIGYAHRPI", zigZag.convert(4));
    }

    @Test
    void convert_with_1_row() {
        Assertions.assertEquals(zigZag.toString(), zigZag.convert(1));
    }

    @Test
    void convert_with_length_1() {
        Assertions.assertEquals(zigZagS.toString(), zigZagS.convert(10));
    }
}