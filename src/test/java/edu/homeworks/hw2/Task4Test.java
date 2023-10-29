package edu.homeworks.hw2;

import edu.homeworks.hw2.Task4.CallingInfo;
import edu.homeworks.hw2.Task4.SystemUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.function.Supplier;
import static edu.homeworks.hw2.Task4.SystemUtils.callingInfo;
import static org.assertj.core.api.Assertions.assertThat;

public class Task4Test {

    @DisplayName("Check Task4")
    @Test
    public void callingInfoTest() {
        var curInfo = callingInfo();
        var expectedInfo = new CallingInfo(this.getClass().getName(),  "callingInfoTest");

        assertThat(curInfo).isEqualTo(expectedInfo);
    }

    @DisplayName("Check Task4 with lambda")
    @Test
    public void lambdaCallingInfoTest() {
        Supplier<CallingInfo> calInfoSupplier = SystemUtils::callingInfo;

        var curInfo = calInfoSupplier.get();
        var expectedInfo = new CallingInfo(this.getClass().getName(),  "lambdaCallingInfoTest");

        assertThat(curInfo).isEqualTo(expectedInfo);
    }


    @DisplayName("Check Task4 with nested class")
    @Test
    public void nestedClassCallingInfoTest() {
        var nestedClassObj = new NestedClass();
        var callInfo = nestedClassObj.getCallInfo();

        assertThat(callInfo).isEqualTo(
            new CallingInfo(NestedClass.class.getName(), "getCallInfo")
        );
    }

    class NestedClass {

        CallingInfo getCallInfo() {
            return callingInfo();
        }
    }

}
