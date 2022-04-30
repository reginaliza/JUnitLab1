package test;

import model.SMSModel;
import model.SMS;
import org.junit.Test;
import java.util.HashMap;
import static org.junit.Assert.*;

public class testUserInfo {

    // *************** NOT WORKING ***
    @Test
    public void testUser1(){
        HashMap<String, String> entry = new HashMap<>();
        SMSModel sms = new SMSModel();
        entry.put("Message", "register");
        entry.put("Full Name", "Regina Diloy");
        entry.put("Birthday: Year", "1998");
        entry.put("Birthday: Month", "04");
        entry.put("Birthday: Day", "21");
        entry.put("Address", "Bacoor City");

        assertNotNull("Verify that HashMap is not NULL", sms);
        assertEquals(SMS.checkUserInfo(entry, sms), "Success");
    } // WITH ERROR


    // ******************* WORKING TEST CASES ****
    @Test
    public void user1() {
        SMS sms = new SMS();

        String fullName = "Regina Diloy";
        String birthday = "1998-04-21";
        String address = "Bacoor City";

        assertEquals("Regina Diloy, 1998-04-21, Bacoor City", sms.userInfo(fullName, birthday, address));
    }

    @Test
    public void user2() {
        SMS sms = new SMS();

        String fullName = "Regina Diloy";
        String birthday = "XXX";
        String address = "Bacoor City";

        assertEquals("Regina Diloy, 1998-04-21, Bacoor City", sms.userInfo(fullName, birthday, address));
    }

    @Test
    public void user3() {
        SMS sms = new SMS();

        String fullName = "Regina Diloy";
        String birthday = "04-21-1998";
        String address = "Bacoor City";

        assertEquals("Regina Diloy, 1998-04-21, Bacoor City", sms.userInfo(fullName, birthday, address));
    }

    @Test
    public void user4() {
        SMSModel sms = new SMSModel();

        sms.setMessage("Marco Valmores, 1973-09-10, Marikina City");

        assertTrue(SMS.hasValidMessageInput(sms));
    }

}
