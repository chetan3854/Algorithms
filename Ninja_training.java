package Dynamic_programming;

import java.util.Arrays;

public class Ninja_training {
    public static int f(int day,int last,int[][] points , int[][] dp){
        if(day==0){
            int maxi = 0;
            for(int task = 0; task<3 ; task++){
                if(task != last){
                    maxi = Math.max(maxi, points[day][task]);

                }
            }
            return maxi;
        }

        if(dp[day][last] != -1){
            return dp[day][last];
        }

        int maxi = 0;
        for(int task = 0; task < 3; task++){
            if(task != last){
                int point = points[day][task] + f(day -1 ,task ,points ,dp);
                maxi = Math.max(maxi,point);
            }
        }
        return dp[day][last] = maxi;
    }
    public static int ninjaTraining(int n, int points[][]){
        int dp[][] = new int[n][4];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }

//        for(int i = 0; i< dp.length ;i++){
//            Arrays.fill(dp[i] , -1);
//        }
        return f(n-1,3,points,dp);
    }
    public static void main(String[] args) {
        int[][] arr = {{2,1,3},{3,4,6},{10,1,6},{8,3,7}};
        System.out.println(ninjaTraining(4,arr));



    }
}
