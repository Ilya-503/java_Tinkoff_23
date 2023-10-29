package edu.homeworks.hw3;

import java.util.HashMap;
import java.util.Map;

public final class Task3 {

    private Task3() {
    }

    public static <T> Map<T, Integer> getFreqDict(T[] sequence) {
        Map<T, Integer> freqDict = new HashMap<>();

        if (sequence == null) {
            return freqDict;
        }
        checkArrElemsType(sequence);

        for (var elem: sequence) {
            Integer freqVal = freqDict.get(elem);
            freqDict.put(elem, freqVal == null ? 1 : ++freqVal);
        }

        return freqDict;
    }

    private static <T> void checkArrElemsType(T[] elements) throws IllegalArgumentException {
        var type = elements[0].getClass();

        for (var elem: elements) {
            if (!elem.getClass().equals(type)) {
                throw new IllegalArgumentException("Types of array elements are not matching");
            }
        }
    }
}



