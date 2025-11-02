package Daily_Task.Nov2025;


import java.util.HashSet;
import java.util.Set;

 class ListNode {
      int val;
      ListNode next;
     ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

public class DeleteNodeLinkedList {

        public ListNode modifiedList(int[] nums, ListNode head) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode temp = dummy;
            Set<Integer> list = new HashSet<>();
            for(int i : nums){
                list.add(i);
            }
            while(temp.next!=null){
                if(list.contains(temp.next.val)){
                    temp.next = temp.next.next;
                }else{
                    temp = temp.next;
                }
            }
            return dummy.next;
        }



    public static void main(String[] args) {
        DeleteNodeLinkedList deleteNodeLinkedList = new DeleteNodeLinkedList();
        int[] nums = {1, 2, 3, 4, 5};
        ListNode head = new ListNode(nums[0]);
        ListNode curr = head;
        for (int i = 1; i < nums.length; i++) {
            curr.next = new ListNode(nums[i]);
            curr = curr.next;
        }
        int[] toDelete = {2, 4};
        ListNode modifiedHead = deleteNodeLinkedList.modifiedList(toDelete, head);
        while (modifiedHead != null) {
            System.out.print(modifiedHead.val + " ");
            modifiedHead = modifiedHead.next;
        }
    }

}
//LeetCode : 3217
//1nov 2025
