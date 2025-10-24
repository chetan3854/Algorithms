import java.util.*;

public class Topkfrequent {

    public static List<Integer> findTopKFrequent(int[] nums, int k) {

        // --- Step 1: Count frequencies ---
        // Create a HashMap to store (number, frequency)
        Map<Integer, Integer> countsMap = new HashMap<>();
        for (int num : nums) {
            // .getOrDefault() is a clean way to increment the count
            countsMap.put(num, countsMap.getOrDefault(num, 0) + 1);
        }

        // --- Step 2: Build the Min-Heap ---
        // Create a min-heap (PriorityQueue).
        // It will store the *numbers* (the keys).
        // The Comparator tells it to sort by frequency (the values from the map).
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                // (a, b) -> frequencyOf(a) - frequencyOf(b)
                (a, b) -> countsMap.get(a) - countsMap.get(b)
        );

        // --- Step 3: Find the "Top K" ---
        // Loop through all unique numbers in our map
        for (int num : countsMap.keySet()) {
            pq.add(num); // Add the number to the heap

            // This is our "Top K" trick:
            // If the heap is too big, remove the *least* frequent item.
            if (pq.size() > k) {
                pq.poll();
            }
        }

        // --- Step 4: Extract the result ---
        // At this point, the heap contains *only* the k most frequent numbers.
        // We poll them out to create our final list.
        List<Integer> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }

        // Note: The result list might be in order of frequency (e.g., [3, 2, 1])
        // The problem usually doesn't care about the final order.
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3, 5, 5, 5, 5};
        int k = 2;

        List<Integer> topK = findTopKFrequent(nums, k);

        // Output: [1, 5] (or [5, 1])
        // '5' appears 4 times, '1' appears 3 times. '2' and '3' appear less.
        System.out.println("The " + k + " most frequent elements are: " + topK);
    }
}
