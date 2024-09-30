import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SportsLogger {

    // Lists to store activity data, stupid method, but since the instructions stated to use single class, I see no other way
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
        SportsLogger sportsLogger = new SportsLogger();
        sportsLogger.start();
    }


    // start the program and display the "main menu"
    public void start() {

    }
    // Method  to get activity data from the user
    public void getActivityFromUser() {
        System.out.println("Log a New Activity");

        System.out.print("Enter activity name: ");
        String name = scanner.nextLine();

        System.out.print("Enter duration in minutes: ");
        String durationString = scanner.nextLine();
        int duration = Integer.parseInt(durationString);

        System.out.print("Enter date (yyyy-MM-dd): ");
        String dateString = scanner.nextLine();
        LocalDate date = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        logActivity(name, duration, date);
    }

    // log a new activity with the given name, duration, and date
    public void logActivity(String name, int duration, LocalDate date) {
        activityNames.add(name);
        activityDurations.add(duration);
        activityDates.add(date);
        System.out.println("Activity logged successfully.");
    }

    // display all the activities that have been logged
    private void viewActivities() {

    }
    // calculate the total time spent on sports activities for the current week
    private void calculateWeeklyTotal() {

    }

    public int getActivityCount() {
        return activityNames.size();
    }
    public String getActivityName(int index) {
        return activityNames.get(index);
    }
    public int getActivityDuration(int index) {
        return activityDurations.get(index);
    }
    public LocalDate getActivityDate(int index) {
        return activityDates.get(index);
    }
}