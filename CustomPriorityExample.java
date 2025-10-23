import java.util.PriorityQueue;

class CustomP implements Comparable<CustomP> {
    String description;
    int priority;

    public CustomP(String description, int priority){
        this.description = description;
        this.priority = priority;
    }
    @Override
    public String toString(){
        return "Task(priority=" + priority + ", desc=" + description + ")";
    }

    @Override

    public int compareTo(CustomP other){
        return this.priority - other.priority;
    }
}
public class CustomPriorityExample {
    public static void main(String[] args) {
        PriorityQueue<CustomP> taskQueue = new PriorityQueue<>();

        // Add tasks in random order
        taskQueue.add(new CustomP("Write report", 2)); // Medium
        taskQueue.add(new CustomP("Call mom", 3));     // Low
        taskQueue.add(new CustomP("Fix bug", 1));      // High

        // Now, let's poll them to see the order
        System.out.println("Polling tasks by priority:");
        while (!taskQueue.isEmpty()) {
            System.out.println(taskQueue.poll());
        }
    }
}
