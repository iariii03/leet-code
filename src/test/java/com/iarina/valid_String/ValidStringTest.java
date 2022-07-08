package com.iarina.valid_String;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ValidStringTest {

    @ParameterizedTest
    @CsvSource(value = {
            "aabbcc:true",
            "aaabbcc:false"
    }, delimiterString = ":")
    void testValidString(String stringValue, boolean expectedResponse) {
        assertEquals(expectedResponse, ValidString.isStringValid(stringValue));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "aabbcc:true",
            "aaabbcc:true",
            "aaaabbcc:false",
            "aabbbcc:true",
            "aabbccc:true",
            "aabbcdd:true",
            "aaabbbccdd:false",
            "abb:true",
            "aab:true",
            "abbb:false"
    }, delimiterString = ":")
    void testCanValidString(String stringValue, boolean expectedResponse) {
        assertEquals(expectedResponse, ValidString.canStringBeValid(stringValue));
    }


    @ParameterizedTest
    @CsvSource(value = {
            "aabbcc:true",
            "aaabbcc:true",
            "aaaabbcc:false",
            "aabbbcc:true",
            "aabbccc:true",
            "aabbcdd:true",
            "aaabbbccdd:false",
            "abb:true",
            "aab:true"
    }, delimiterString = ":")
    void testCanValidString_2(String stringValue, boolean expectedResponse) {
        assertEquals(expectedResponse, ValidString.canStringBeValid_DD(stringValue));
    }



}