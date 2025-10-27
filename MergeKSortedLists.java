import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (ListNode head : lists) {
            if (head != null) pq.add(head);
        }

        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;

        while (!pq.isEmpty()) {
            ListNode smallestNode = pq.poll();
            tail.next = smallestNode;
            tail = tail.next;

            if (smallestNode.next != null) pq.add(smallestNode.next);
        }

        return dummyHead.next;
    }

    // MAIN method for testing
    public static void main(String[] args) {
        // Example: merge 3 sorted lists
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] lists = {l1, l2, l3};

        MergeKSortedLists obj = new MergeKSortedLists();
        ListNode merged = obj.mergeKLists(lists);

        // Print
        System.out.print("Merged List: ");
        while (merged != null) {
            System.out.print(merged.val + " ");
            merged = merged.next;
        }
    }
}

