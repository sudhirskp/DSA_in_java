package LinkedList;


import java.util.ArrayList;
import java.util.List;

public class ReorderList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

        public void reorderList(ListNode head) {
            if (head == null || head.next == null) return;

            // Step 1: Find middle
            ListNode slow = head, fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            // Step 2: Reverse second half
            ListNode second = reverse(slow.next);
            slow.next = null; // cut the list into two halves

            // Step 3: Merge two halves
            ListNode first = head;
            while (second != null) {
                ListNode tmp1 = first.next;
                ListNode tmp2 = second.next;

                first.next = second;
                second.next = tmp1;

                first = tmp1;
                second = tmp2;
            }
        }

        private ListNode reverse(ListNode head) {
            ListNode prev = null, curr = head;
            while (curr != null) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            return prev;
        }

    public void reorderList1(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode temp = head;

        while(temp!=null){
            list.add(temp.val);
            temp = temp.next;
        }

        int i =0;
        int n = list.size()-1;
        boolean flag = true;
        // ListNode dm = new ListNode(-1);
        // temp = dm;
        temp = head;
        while(i<=n && temp!=null){
            if(flag){
                // ListNode newNode = new ListNode(list.get(i++));
                // temp.next = newNode;
                temp.val = list.get(i++);
                flag = false;
            }else{
                // ListNode newNode = new ListNode( list.get(n--));
                // temp.next = newNode;
                temp.val = list.get(n--);
                flag = true;
            }
            temp = temp.next;
        }
        //head.next = dm.next.next;
    }

    public static void main(String[] args) {
        ReorderList ob = new ReorderList();
            ListNode head = ob.new ListNode(1);
            head.next = ob.new ListNode(2);
            head.next.next = ob.new ListNode(3);
            head.next.next.next = ob.new ListNode(4);
            head.next.next.next.next = ob.new ListNode(5);

            ob.reorderList(head);

            // Print the reordered list
            ListNode temp = head;
            while (temp != null) {
                System.out.print(temp.val + " ");
                temp = temp.next;
            }
    }
}
//leet 143