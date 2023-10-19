package edu.hw2.Task4;

import java.util.Arrays;

public final class SystemUtils {

    private SystemUtils() {
    }

    public static CallingInfo callingInfo() {
        String className = "";
        String methodName = "";

        var stackTrace = new Throwable().getStackTrace();
        var upperTraceInfo = Arrays
            .stream(stackTrace)
            .toList()
            .get(1);

        className = upperTraceInfo.getClassName();
        methodName = upperTraceInfo.getMethodName();

        return new CallingInfo(className, methodName);
    }

}
