import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SportsLogger {

    // Lists to store activity data
    private List<String> activityNames;
    private List<Integer> activityDurations;
    private List<LocalDate> activityDates;
    private Scanner scanner;

    public SportsLogger() {
        // Initialize the lists
        activityNames = new ArrayList<>();
        activityDurations = new ArrayList<>();
        activityDates = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    // main method which creates an instance of SportsLogger and starts the program
    public static void main(String[] args) {

    }


    // start the program and display the "main menu"
    public void start() {

    }
    // ask for activity name, duration, and date, and store them in the lists
    private void logActivity() {

    }

    // display all the activities that have been logged
    private void viewActivities() {

    }
    // calculate the total time spent on sports activities for the current week
    private void calculateWeeklyTotal() {

    }
}