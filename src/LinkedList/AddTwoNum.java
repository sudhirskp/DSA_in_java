package LinkedList;

public class AddTwoNum {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode temp = null;

        int cr = 0;

        while (l1 != null || l2 != null || cr != 0) {
            int v1 = (l1 == null) ? 0 : l1.val;
            int v2 = (l2 == null) ? 0 : l2.val;
            int val = v1 + v2 + cr;
            ListNode newNode = new ListNode(val % 10);
            cr = val / 10;
            if (head == null) {
                temp = newNode;
                head = newNode;
            } else {
                temp.next = newNode;
                temp = temp.next;
            }

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        AddTwoNum ob = new AddTwoNum();
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);


        ListNode result = ob.addTwoNumbers(l1, l2);


        // Print the result
        ListNode temp = result;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }

    }
}
//leet 2