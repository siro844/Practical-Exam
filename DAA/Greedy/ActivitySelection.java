import java.util.*;

class Activity {
    int start, finish;

    public Activity(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }
}

class ActivitySelection {
    public static List<Activity> selectActivities(Activity[] activities) {
        List<Activity> selectedActivities = new ArrayList<>();

        // Sort activities based on finish time
        Arrays.sort(activities, Comparator.comparingInt((Activity a) -> a.finish));

        // Select the first activity
        selectedActivities.add(activities[0]);

        // Iterate through the remaining activities
        int lastSelectedActivityIndex = 0;
        for (int i = 1; i < activities.length; i++) {
            if (activities[i].start >= activities[lastSelectedActivityIndex].finish) {
                selectedActivities.add(activities[i]);
                lastSelectedActivityIndex = i;
            }
        }

        return selectedActivities;
    }

    public static void main(String[] args) {
        // Create an array of activities
        Activity[] activities = {
            new Activity(1, 4),
            new Activity(3, 5),
            new Activity(0, 6),
            new Activity(5, 7),
            new Activity(3, 8),
            new Activity(5, 9),
            new Activity(6, 10),
            new Activity(8, 11),
            new Activity(8, 12),
            new Activity(2, 13),
            new Activity(12, 14)
        };

        // Select activities
        List<Activity> selectedActivities = selectActivities(activities);

        // Print the selected activities
        System.out.println("Selected Activities:");
        for (Activity activity : selectedActivities) {
            System.out.println("[" + activity.start + ", " + activity.finish + "]");
        }
    }
}