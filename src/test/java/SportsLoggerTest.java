import org.junit.Test;

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

    @Test
    public void calculateWeeklyTotalTest() {
        SportsLogger logger = new SportsLogger();
        LocalDate today = LocalDate.now();

        // Add two activities with dates from the last two days --- should be included in the total
        LocalDate date1 = today.minusDays(1);
        LocalDate date2 = today.minusDays(2);
        //add activities outside the 7 day window --- should not be included in the total
        LocalDate date3 = today.minusDays(8);
        LocalDate date4 = today.minusDays(9);


        logger.logActivity("Running", 60, date1);
        logger.logActivity("Swimming", 45, date2);
        logger.logActivity("Cycling", 30, date3);
        logger.logActivity("Walking", 15, date4);
        // Calculate the weekly total and assert the expected value
        assertEquals(105, logger.calculateWeeklyTotal());
        //add an activity for today --- should be included in the total
        LocalDate date5 = today;
        logger.logActivity("Running", 60, date5);
        assertEquals(165, logger.calculateWeeklyTotal());

        //add an activity for 7 days ago --- should not be included in the total
        LocalDate date6 = today.minusDays(7);
        logger.logActivity("Running", 60, date6);
        assertEquals(165, logger.calculateWeeklyTotal());



    }
}
