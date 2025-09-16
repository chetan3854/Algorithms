package Dynamic_programming;

import java.util.Arrays;

// Find maximum sum subsequence but can't pick up adjacent elements.
public class Subsequence1 {
    public static int f(int ind , int[] arr , int[] dp){
        if(ind == 0){
            return arr[ind];
        }
        if(ind < 0) {
            return 0;
        }
        if(dp[ind] != -1 ){
            return dp[ind];
        }
        int pick = arr[ind] + f(ind -2, arr, dp);
        int np = 0 + f(ind -1, arr, dp);

        dp[ind] = Math.max(pick,np);
        return dp[ind];
    }
    public static int noadjacent(int[] arr){
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return f(n-1,arr,dp);
    }
    public static void main(String[] args) {
        int[] arr = {10,1,10,1,10};
        int n = arr.length;
        System.out.println(noadjacent(arr));

        // Tabulation solution

        int[] dp = new int[n];
        Arrays.fill(dp,0);
        dp[0] = arr[0];
        int neg = 0;
        for( int i = 1 ; i<n ;i++){
            int take = arr[i];
            if(i>0){
                take += dp[i-2];
            }
            int nt = 0 + dp[i-1];
            dp[i] = Math.max(take,nt);
        }
        System.out.println(dp[n-1]);
        
        //Space optimization solution ,
        // we only need the current , prev and prev2 element , others are irrelevent 
        
        int prev = arr[0];
        int prev2 = 0;
        for(int i = 1 ; i<n;i++){
            int t = arr[i];
            if(i>1){
                t += prev2;
            }
            int nt = 0 + prev;
            
            int curi = Math.max(t,nt);
            prev2 = prev ;
            prev = curi;
        }
        System.out.println(prev);
        
    }
}
