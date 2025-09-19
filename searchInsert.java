public class searchInsert {
    public static int f(int arr[] , int target){
        int low = 0;
        int right = arr.length-1;
        int n = arr.length;
        int ans = n;
        while(low<=right){
            int mid = low + (right - low)/2;

            if(arr[mid]>=target){
                ans = mid;
                right = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {

    }
}
