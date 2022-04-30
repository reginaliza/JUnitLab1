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
                {"Register", "register"}, //success
                {"REGISTER", "register"}, //success
                {"register", "register"}, //success
                {"rEgIsTeR", "register"},//success
                {"  register", "register"}, //failed because of whitespace
                {"reg1ster", "register"}, //failed because of number
                {"reg!ster", "register"}, //failed because of special character
                {" regi ster ", "register"} //failed because of spaces
        };
        return Arrays.asList(expectedOutputs);
    }

    @Test
    public void registerMultipleConditions() {
        assertEquals(expectedOutput, sms.register(input));
    }


}
