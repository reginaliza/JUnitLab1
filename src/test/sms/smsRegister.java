package test.sms;

import sms.model.SMS;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.HashMap;

public class smsRegister {

    @Test
    public void testMessageContent () {
        SMS sms = new SMS();

        HashMap<String, String> entryOne = new HashMap<>();
        entryOne.put("Message", "Register");

        HashMap<String, String> entryTwo = new HashMap<>();
        entryTwo.put("Message", "REGISTER");

        HashMap<String, String> entryThree = new HashMap<>();
        entryThree.put("Message", "register");

        assertEquals("Register", entryOne.get("Message"));
        assertEquals("REGISTER", entryTwo.get("Message"));
        assertEquals("register", entryThree.get("Message"));
    }
}
