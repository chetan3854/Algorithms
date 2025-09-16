import java.util.ArrayList;

public class Merge_Sort {
    public static void mergesort(int[] arr, int low , int high){
        //base case
        if(low >= high){
            return;
        }
        int mid = (low + high)/2;
        mergesort(arr,low,mid); // left half
        mergesort(arr,mid+1,high); // right half
        merge(arr,low,mid,high); // merge them both for mw
    }
    public static void merge(int[] arr , int low , int mid , int high){
        int left = low;
        int right = mid+1;
        ArrayList<Integer> temp = new ArrayList<>();
        while(left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }
        // copy everything that is left
        while(left<=mid){
            temp.add(arr[left]);
            left++;
        }
        while(right<=high){
            temp.add(arr[right]);
            right++;
        }
        // copy temp back to the original array..

        for(int i = low ; i<= high ;i++){
            arr[i] = temp.get(i-low);
        }


    }

    public static void main(String[] args) {
        // The main usecase of the merge sort is to Divide the Elements and then
        // merge them together to get a sorted array.

        int[] arr = {3,1,9,2,7,1,4,4,99};
        int low = 0;
        int high = arr.length-1;
        int n = arr.length;
        mergesort(arr,low,high);

        for (int num : arr) {
            System.out.print(num + " ");
        }



    }
}
