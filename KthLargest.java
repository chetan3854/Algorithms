import java.util.PriorityQueue;

public class KthLargest {
    public static int FindKthLargest(int[] nums , int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int num : nums){
            pq.add(num);

            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.peek();
    }
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 3;
        int result = FindKthLargest(nums, k);
        System.out.println(result);
    }
}
