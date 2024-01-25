import Utilities.Utilities;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UtilitiesTest {
    @Test
    public void numberInRange() {
        assertTrue(Utilities.checkNumberInRange("1", 1, 10));
        assertTrue(Utilities.checkNumberInRange("2", 1, 10));
        assertTrue(Utilities.checkNumberInRange("9", 1, 10));

        assertFalse(Utilities.checkNumberInRange("10", 1, 10));
        assertFalse(Utilities.checkNumberInRange("0", 1, 10));

        assertFalse(Utilities.checkNumberInRange("character", 1, 10));
        assertFalse(Utilities.checkNumberInRange("++", 1, 10));
    }
}
