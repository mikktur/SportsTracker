import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SportsLoggerTest {

    //tests the logActivity method, checks if the activity name, duration and date are stored correctly
    @Test
    public void testLogActivity() {
        SportsLogger sportsLogger = new SportsLogger();
        //creates an expected date for the test
        LocalDate expectedDate = LocalDate.of(2024, 9, 30);

        sportsLogger.logActivity("Running", 60, expectedDate);
        assertEquals("Running", sportsLogger.getActivityName(0));
        assertEquals(60, sportsLogger.getActivityDuration(0));
        assertEquals(expectedDate, sportsLogger.getActivityDate(0));
    }
}
