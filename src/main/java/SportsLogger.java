import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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
        while (true) {
            System.out.println("\n--- Sports Logger ---");
            System.out.println("1. Log an activity");
            System.out.println("2. View activities");
            System.out.println("3. Calculate total time for the week");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    getActivityFromUser();
                    break;
                case 2:
                    viewActivities();
                    break;
                case 3:
                    displayWeeklyTotal();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

    }

    // Method  to ask for the user input and log the activity
    public void getActivityFromUser() {
        System.out.println("Log a New Activity");

        //if the user does not enter a name, the default name will be "Activity" + the number of activities logged
        String name = "Activity " + (getActivityCount() + 1);
        System.out.print("Enter activity name (or leave blank to use default): ");
        String userInput = scanner.nextLine();
        if (!userInput.trim().isEmpty()) {
            name = userInput;
        } else {
            System.out.println("No name entered. Activity will be logged as: " + name);
        }

        int duration = 0;
        //ask the user for the duration of the activity, the input must be a positive number
        while (true) {
            try {
                System.out.print("Enter duration in minutes: ");
                String durationString = scanner.nextLine();
                duration = Integer.parseInt(durationString);

                if (duration <= 0) {
                    System.out.println("Duration must be a positive number. Please try again.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number for the duration.");
            }
        }

        LocalDate date = null;
        //ask the user for the date of the activity, the input must be in the format yyyy-MM-dd
        while (true) {
            try {
                System.out.print("Enter date (yyyy-MM-dd): ");
                String dateString = scanner.nextLine();
                date = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please enter the date in the format yyyy-MM-dd.");
            }
        }

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
        List<String> formattedActivities = getFormattedActivities();
        for (String activity : formattedActivities) {
            System.out.println(activity);
        }
    }

    public List<String> getFormattedActivities() {
        List<String> formattedActivities = new ArrayList<>();
        if (activityNames.isEmpty()) {
            formattedActivities.add("No activities logged.");
        } else {
            for (int i = 0; i < activityNames.size(); i++) {
                formattedActivities.add("Activity: " + activityNames.get(i) + ", Duration: " + activityDurations.get(i) + " minutes, Date: " + activityDates.get(i));
            }
        }
        return formattedActivities;
    }

    // calculate the total time spent on sports activities for the current week
    public void displayWeeklyTotal() {

        int totalDuration = calculateWeeklyTotal();

        System.out.println("Total time spent on sports this week: " + totalDuration + " minutes.");
    }
    // calculate the total time spent on sports activities for the last 7 days
    public int calculateWeeklyTotal(){
        int totalDuration = 0;
        LocalDate today = LocalDate.now();
        LocalDate startDate = today.minusDays(6);

        for (int i = 0; i < activityDates.size(); i++) {
            LocalDate activityDate = activityDates.get(i);
            if (!activityDate.isBefore(startDate) && !activityDate.isAfter(today)) {
                totalDuration += activityDurations.get(i);
            }
        }
        return totalDuration;
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