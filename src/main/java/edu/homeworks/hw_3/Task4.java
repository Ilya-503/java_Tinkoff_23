package edu.homeworks.hw_3;

import java.util.TreeMap;

@SuppressWarnings("MagicNumber")
public final class Task4 {

    private final static TreeMap<Integer, String> INT_TO_ROMAN_MAP = new TreeMap<>();


    static {
        INT_TO_ROMAN_MAP.put(1000, "M");
        INT_TO_ROMAN_MAP.put(900, "CM");
        INT_TO_ROMAN_MAP.put(500, "D");
        INT_TO_ROMAN_MAP.put(400, "CD");
        INT_TO_ROMAN_MAP.put(100, "C");
        INT_TO_ROMAN_MAP.put(90, "XC");
        INT_TO_ROMAN_MAP.put(50, "L");
        INT_TO_ROMAN_MAP.put(40, "XL");
        INT_TO_ROMAN_MAP.put(10, "X");
        INT_TO_ROMAN_MAP.put(9, "IX");
        INT_TO_ROMAN_MAP.put(5, "V");
        INT_TO_ROMAN_MAP.put(4, "IV");
        INT_TO_ROMAN_MAP.put(1, "I");
    }

    private Task4() {
    }

    public static String intToRoman(int number) throws IllegalArgumentException {
        if (number < 1 || number > 3999) {
            throw new IllegalArgumentException();
        }

        int numToConvert = number;

        StringBuilder romanNum = new StringBuilder();

        while (numToConvert > 0) {
            int floorNum = INT_TO_ROMAN_MAP.floorKey(numToConvert);
            romanNum.append(INT_TO_ROMAN_MAP.get(floorNum));
            numToConvert -= floorNum;
        }
        return romanNum.toString();
    }
}
