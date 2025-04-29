package Pattern.fastSlowPointers;

public class CycleInlINk {

      class ListNode {
          int val;
          ListNode next;

          ListNode(int x) {
              val = x;
              next = null;
          }
      }

        public boolean hasCycle(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;
            while(fast!=null && fast.next!=null){
                slow = slow.next;
                fast = fast.next.next;
                if(fast == slow){
                    return true;
                }
            }
            return false;
        }

        public void AddNode(ListNode head, int val) {
            ListNode newNode = new ListNode(val);
            if (head == null) {
                head = newNode;
                return;
            }
            ListNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        public void makeCycle(ListNode head, int pos) {
            if (head == null) return;
            ListNode cycleNode = null;
            ListNode current = head;
            int index = 0;
            while (current.next != null) {
                if (index == pos) {
                    cycleNode = current;
                }
                current = current.next;
                index++;
            }
            if (cycleNode != null) {
                current.next = cycleNode; // Create the cycle
            }
        }
    public static void main(String[] args) {
        CycleInlINk cycleInlINk = new CycleInlINk();
        ListNode head = cycleInlINk.new ListNode(3);
        cycleInlINk.AddNode(head, 2);
        cycleInlINk.AddNode(head, 0);
        cycleInlINk.AddNode(head, -4);
        cycleInlINk.makeCycle(head, 1); // Create a cycle at index 1

        boolean hasCycle = cycleInlINk.hasCycle(head);
        System.out.println("Has Cycle: " + hasCycle); // Output: true
    }
}


//141. Linked List Cycle
//        Solved
//Easy
//        Topics
//Companies
//        Given head, the head of a linked list, determine if the linked list has a cycle in it.
//
//There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
//
//Return true if there is a cycle in the linked list. Otherwise, return false.

//Example 1:
//
//
//Input: head = [3,2,0,-4], pos = 1
//Output: true
//Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
