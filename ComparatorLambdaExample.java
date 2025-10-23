import java.util.Comparator;
import java.util.PriorityQueue;

class Task {
    String description;
    int priority; // 1=High, 2=Medium, 3=Low

    public Task(String description, int priority) {
        this.description = description;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Task(priority=" + priority + ", desc=" + description + ")";
    }
}

public class ComparatorLambdaExample {
    public static void main(String[] args) {
        Comparator<Task> priorityMinHeap = (task1, task2) -> task1.priority - task2.priority;

        // Pass the comparator to the PriorityQueue constructor
        PriorityQueue<Task> taskQueue = new PriorityQueue<>(priorityMinHeap);

        taskQueue.add(new Task("Write report", 2));
        taskQueue.add(new Task("Call mom", 3));
        taskQueue.add(new Task("Fix bug", 1));

        System.out.println("Lambda min-heap (low to high):");
        while (!taskQueue.isEmpty()) {
            System.out.println(taskQueue.poll());
        }

    }
}
