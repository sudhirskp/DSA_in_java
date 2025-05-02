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

//        leet-206
        public ListNode reverseList(ListNode head){
          ListNode current = head;
          ListNode prev = null;
          while(current != null){
              ListNode nextNode = current.next;
              current.next = prev;
              prev = current;
              current = nextNode;
          }
          return prev;
        }

    //leet 92
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dm = new ListNode(0);
        dm.next = head;
        ListNode prev = dm;

        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        ListNode current = prev.next;
        ListNode nextNode;

        for (int i = 0; i < right - left; i++) {
            nextNode = current.next;
            current.next = nextNode.next;
            nextNode.next = prev.next;
            prev.next = nextNode;
        }
        return dm.next;
    }

    //leet 24 Swap Nodes in Pairs
    public ListNode swapPairs(ListNode head) {
          ListNode dm = new ListNode(0);
            dm.next = head;
            ListNode prev = dm;
            while (prev.next != null && prev.next.next != null) {
                ListNode first = prev.next;
                ListNode second = prev.next.next;

                // Swap the nodes
                first.next = second.next;
                second.next = first;
                prev.next = second;

                // Move to the next pair
                prev = prev.next.next;
            }
          return dm.next;
    }

    public static void main(String[] args) {
        CycleInlINk cycleInlINk = new CycleInlINk();
        ListNode head = cycleInlINk.new ListNode(1);
        cycleInlINk.AddNode(head, 2);
        cycleInlINk.AddNode(head, 3);
        cycleInlINk.AddNode(head, 4);
        cycleInlINk.AddNode(head, 5);
        //cycleInlINk.makeCycle(head, 1); // Create a cycle at index 1

        boolean hasCycle = cycleInlINk.hasCycle(head);
        System.out.println("Has Cycle: " + hasCycle); // Output: true

//        ListNode reversedHead = cycleInlINk.reverseBetween(head, 2, 4);
//        System.out.println("Reversed List: ");
//        while (reversedHead != null) {
//            System.out.print(reversedHead.val + " -> ");
//            reversedHead = reversedHead.next;
//        }

//       ListNode node = cycleInlINk.reverseList(head);
//        System.out.println("Reversed List: ");
//        while (node != null) {
//            System.out.print(node.val + " -> ");
//            node = node.next;
//        }

        ListNode swappedHead = cycleInlINk.swapPairs(head);
        System.out.println("\nSwapped List: ");
        while (swappedHead != null) {
            System.out.print(swappedHead.val + " -> ");
            swappedHead = swappedHead.next;
        }


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


//24. Swap Nodes in Pairs
//Medium
//        Topics
//Companies
//Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
//
//
//
//Example 1:
//
//Input: head = [1,2,3,4]
//
//Output: [2,1,4,3]
