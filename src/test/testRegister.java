package test;

import model.SMS;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class TestRegister {

    SMS sms = new SMS();

    private String input;
    private String expectedOutput;

    public TestRegister(String input, String expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Parameterized.Parameters
    public static Collection<String[]> registerConditions() {
        String expectedOutputs[][] = {
                {"Register", "register"},
                {"REGISTER", "register"},
                {"  register", "register"},
                {"1rEgIsTeR", "register"}
        };
        return Arrays.asList(expectedOutputs);
    }

    @Test
    public void registerMultipleConditions() {
        assertEquals(expectedOutput, sms.register(input));
    }

    @Test
    public void testMSISDN() {
        String actual = sms.mobileNumber("09177132479");
        String expected = "09177132479";
        assertEquals(expected, actual);
    }

    /* //OLD TEST
    @Test
    public void testRegister() {
        String actual = sms.register("ReGiSteR");
        String expected = "register";
        assertEquals(expected, actual);
    }

     */
}
