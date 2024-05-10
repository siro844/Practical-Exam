import java.util.Arrays;

public class ActivitySelection {
    // Sort the activities according to their finishing time
    // Select the first activity from the sorted array and print it
    // Do the following for the remaining activities in the sorted array
    // If the start time of this activity is greater
    // than or equal to the finish time of the previously
    /// selected activity then select this activity and print it
    public static void main(String[] args) {
        int[] s = { 1, 3, 0, 5, 8, 5 };
        int[] f = { 2, 4, 6, 7, 9, 9 };
        int n = s.length;
        printMaxActivities(s, f, n);

    }

    public static void printMaxActivities(int s[], int f[],
            int n) {
        // Create an array of indices
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        // Sort the array of indices according to the finish times
        Arrays.sort(indices, (i, j) -> Integer.compare(f[i], f[j]));

        int i, j;

        System.out.print("Following activities are selected : ");

        // The first activity always gets selected
        i = indices[0];
        System.out.print(i + " ");

        // Consider rest of the activities
        for (j = 1; j < n; j++) {
            // If this activity has start time greater than or
            // equal to the finish time of previously selected
            // activity, then select it
            if (s[indices[j]] >= f[i]) {
                System.out.print(indices[j] + " ");
                i = indices[j];
            }
        }
    }
}
