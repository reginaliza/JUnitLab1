package test;

import model.SMSModel;
import model.SMS;
import org.junit.Test;
import java.util.HashMap;
import static org.junit.Assert.*;

public class TestUserInfo {

    //SMS sms = new SMS();

    @Test
    public void testUser1(){
        HashMap<String, String> entry = new HashMap<>();
        SMSModel sms = new SMSModel();
        entry.put("First Name", "Regina");
        entry.put("Last Name", "Diloy");
        entry.put("Birthday: Year", "1998");
        entry.put("Birthday: Month", "04");
        entry.put("Birthday: Day", "21");
        entry.put("Address", "Bacoor City");

        assertEquals(SMS.checkUserInfo(entry, sms), "Valid User Information");
    }
}
