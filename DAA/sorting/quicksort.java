public class quicksort{

    public static void quiksort(int[] arr,int low , int high){
        // If the lower index is less than the higher index
        if(low<high){
            // Partition the array and get the pivot index
            int pivot=partition(arr,low,high);
            // Recursively quicksort the part before pivot
            quiksort(arr, low,pivot-1 );
            // Recursively quicksort the part after pivot
            quiksort(arr,pivot+1,high);
        }
    }

    // The partition method
    private static int partition(int[] arr, int low, int high){
        // Choose the pivot element
        int pivot=arr[high];
        // Index for smaller element
        int i=low-1;
        // Traverse through each element
        for (int j=low;j<high;j++){
            // If element smaller than pivot is found, swap it with the first element greater than pivot
            if(arr[j]<pivot){
                i++;
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        // Swap the pivot element with the first element greater than pivot
        int temp=arr[i+1];
        arr[i+1]=arr[high];
        arr[high]=temp;

        // Return the pivot index
        return i+1;
    }

    // The main method
    public static void main(String[] args) {
        // Initialize the array
        int arr[]={1,3,5,6,7,9,10,3,1};
        // Call the quicksort method
        quiksort(arr,0,arr.length-1);
        // Print the sorted array
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}