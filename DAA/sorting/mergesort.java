public class mergesort{
    public static void main(String[] args) {
        // Initialize the array
        int arr[]={1,4,7,10,12};
        // Call the mergesort method
        mergesort(arr,0,arr.length-1);
        // Print the sorted array
        for (int i =0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    // The mergesort method
    private static void mergesort(int[] arr, int l, int r) {
        // If the lower index is less than the higher index
        if(l<r){
            // Find the middle index
            int mid=(l+r)/2;
            // Recursively mergesort the first half
            mergesort(arr, l, mid);
            // Recursively mergesort the second half
            mergesort(arr, mid+1, r);
            // Merge the two halves
            merge(arr,l,mid,r);
        }
    }

    // The merge method
    private static void merge(int[] arr, int l, int mid, int r) {
        // Calculate the lengths of the two halves
        int n1=mid-l+1;
        int n2=r-mid;
        
        // Create temporary arrays for the two halves
        int lArr[] = new int[n1];
        int rArr[] = new int[n2];

        // Copy the elements to the temporary arrays
        for(int x=0;x<n1;x++){
            lArr[x]=arr[l+x];
        }
        for(int x=0;x<n2;x++){
            rArr[x]=arr[mid+1];
        }

        // Merge the temporary arrays back into the original array
        int i=0;
        int j=0;
        int k=l;

        // While there are elements in both arrays
        while(i<n1 && j<n2){
            // If the current element of the left array is smaller or equal to the current element of the right array
            if(lArr[i]<=rArr[j]){
                // Copy the element from the left array to the original array
                arr[k]=lArr[i];
                i++;
            }
            else{
                // Copy the element from the right array to the original array
                arr[k]=rArr[j];
                j++;
            }
            k++;
        }

        // Copy the remaining elements from the left array, if any
        while(i<n1){
            arr[k]=lArr[i];
            i++;
            k++;
        }
        // Copy the remaining elements from the right array, if any
        while(j<n2){
            arr[k]=rArr[j];
            j++;
            k++;
        }
    }
}