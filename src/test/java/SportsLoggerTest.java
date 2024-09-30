import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.List;

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
    //tests the getFormattedActivities method, checks if the activities are formatted correctly
    @Test
    public void testGetFormattedActivities() {

        SportsLogger logger = new SportsLogger();

        // Test empty case
        List<String> result = logger.getFormattedActivities();
        assertEquals(1, result.size());
        assertEquals("No activities logged.", result.get(0));

        // Test non-empty case
        logger.logActivity("Running", 30, LocalDate.of(2024, 10, 1));


        result = logger.getFormattedActivities();
        assertEquals(1, result.size());
        assertEquals("Activity: Running, Duration: 30 minutes, Date: 2024-10-01", result.get(0));
    }
}
