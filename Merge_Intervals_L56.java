import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Merge_Intervals_L56 {
    public int[][] merge(int[][] intervals) {
        // playing block by block

        List<int[]> res = new ArrayList<>();

        Arrays.sort(intervals,(a, b)-> a[0] - b[0]);// same as Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0])); // Sorting makes it easier to compare, otherwise we have to employ multple cases. (in step below)

        int[] curr = intervals[0];

        for(int k = 1 ; k< intervals.length ; k++){
            if(curr[1] >= intervals[k][0]){
                curr[1] = Math.max(curr[1],intervals[k][1]); // not adding curr to res here as there could be more overlaps
            }else{
                res.add(curr);
                curr = intervals[k];
            }
        }
        res.add(curr);
        int[][] ans = new int[res.size()][];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
    public static void main(String[] args) {


    }
}
