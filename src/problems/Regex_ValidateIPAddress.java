package problems;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

//IP address is a string in the form "A.B.C.D", where the value of A, B, C, and D may range from 0 to 255.
// Leading zeros are allowed. The length of A, B, C, or D can't be greater than 3.
public class Regex_ValidateIPAddress {
    public static void main(String[] args) {
        String regex = "^(25[0-5]|2[0-4][0-9]|[01]?[0-9]{1,2})\\." +
                "(25[0-5]|2[0-4][0-9]|[01]?[0-9]{1,2})\\." +
                "(25[0-5]|2[0-4][0-9]|[01]?[0-9]{1,2})\\." +
                "(25[0-5]|2[0-4][0-9]|[01]?[0-9]{1,2})$";

        /*
            25[0-5] → 250 to 255
            2[0-4][0-9] → 200 to 249
            [01]? -> 0 or 1 may be present or not
            [01]?[0-9]{1,2} → 0 to 199
            \\. → match the dot literally
        */
        assertTrue("000.12.12.034".matches(regex));
        assertTrue("121.234.12.12".matches(regex));
        assertTrue("23.45.12.56".matches(regex));

        assertFalse("00.12.123.123123.123".matches(regex));
        assertFalse("122.23".matches(regex));
        assertFalse(" Hello.IP".matches(regex));
    }
}
