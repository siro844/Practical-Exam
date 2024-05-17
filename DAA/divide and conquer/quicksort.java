import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 7, 6, 3};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Choose the pivot element (in this case, the last element)
        int i = low - 1; // Initialize the index of the smaller element

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++; // Increment the index of the smaller element
                swap(arr, i, j); // Swap arr[i] and arr[j]
            }
        }

        swap(arr, i + 1, high); // Swap the pivot element with the element at the correct position

        return i + 1; // Return the index of the pivot element
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}