package com.iarina.valid_String;


//Write a function checking that the given string is valid. We consider a string
//        to be valid if all the characters of the string have exactly the same frequency.
//
//        Examples:
//        "aabbcc" is a valid string
//        "aabbccc" is an invalid string
//        8.1. Check if the string is valid as it is (same condition as before) or if one character
//        at one position can be removed from the string so it will become valid.

import java.util.*;

public class ValidString {

    public static boolean isStringValid(String stringValue) {
        Map<String, Integer> stringCounter = getFrequencyMap(stringValue);
        return new HashSet<>(stringCounter.values()).size() == 1;
    }

    public static boolean canStringBeValid(String stringValue) {
        Map<String, Integer> stringCounter = getFrequencyMap(stringValue);
        List<Integer> valuesFrequency = new ArrayList<>(stringCounter.values());
        List<Integer> valuesFrequencySet = new ArrayList<>(new HashSet<>(stringCounter.values()));

        switch (valuesFrequencySet.size()) {
            case 1:
                return true;
            case 2:
                long count1 = valuesFrequency.stream()
                        .filter(v -> v.equals(valuesFrequencySet.get(0)))
                        .count();
                long count2 = valuesFrequency.stream()
                        .filter(v -> v.equals(valuesFrequencySet.get(1)))
                        .count();
                Integer freqValue;
                Integer invalidValue;
                if (count1 > 1 && count2 == 1) {
                    freqValue = valuesFrequencySet.get(0);
                    invalidValue = valuesFrequencySet.get(1);
                } else if (count1 == 1 && count2 > 1) {
                    freqValue = valuesFrequencySet.get(1);
                    invalidValue = valuesFrequencySet.get(0);
                } else if (count1 == 1 && count2 == 1) {
                    freqValue = valuesFrequencySet.get(1);
                    invalidValue = valuesFrequencySet.get(0);
                    return freqValue - invalidValue == Math.abs(1);
                } else {
                    return false;
                }

                return freqValue.equals(invalidValue - 1) || 0 == (invalidValue - 1);
            default:
                return false;
        }
    }


    public static boolean canStringBeValid_DD(String stringValue) {
        Map<String, Integer> stringCounter = getFrequencyMap(stringValue);
        List<Integer> valuesFrequency = new ArrayList<>(stringCounter.values());
        Collections.sort(valuesFrequency);
        int valMin = valuesFrequency.get(0);
        boolean reduced = false;
        int secondVal = valuesFrequency.get(1);
        if (valMin == secondVal - 1 && valMin == 1) {
            valuesFrequency.remove(0);
            valMin = secondVal;
            reduced = true;
        }
        for (int i : valuesFrequency) {
            if (valMin != i) {
                if(!reduced) {
                    reduced = true;
                    if (valMin != i - 1)
                        return false;
                } else {
                    return false;
                }

            }
        }
        return true;
    }

    private static Map<String, Integer> getFrequencyMap(String stringValue) {
        Map<String, Integer> stringCounter = new HashMap<>();
        Arrays.stream(stringValue.split(""))
                .forEach(s -> updateMap(stringCounter, s));
        return stringCounter;
    }

    private static void updateMap(Map<String, Integer> stringCounter, String string) {
        Integer frequency = stringCounter.get(string);
        if (Objects.nonNull(frequency)) {
            stringCounter.put(string, ++frequency);
        } else {
            stringCounter.put(string, 1);
        }
    }

}
