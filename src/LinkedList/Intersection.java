package LinkedList;

import java.util.List;

public class Intersection {

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        ListNode t1 = headA;
        ListNode t2 = headB;
        while(t1!=t2){
            t1 = t1==null ? headB : t1.next;
            t2 = t2==null ? headA : t2.next;
        }
        return t1;
    }

    public int length(ListNode head){
        int count=0;
        while(head!=null){
            count++;
            head=head.next;
        }
        return count;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode h1 = headA;
        ListNode h2 = headB;
        int n1  = length(headA);
        int n2 = length(headB);

        while(h1!=null && h2!=null){
            if(h1.val==h2.val && h1 == h2){
                ListNode result = new ListNode(h1.val);
                return result;
            }
            if(n1>n2){
                h1=h1.next;
                n1--;
            }else if(n1==n2){
                h1=h1.next;
                h2=h2.next;
                n1--;
                n2--;
            }
            else{
                h2=h2.next;
                n2--;
            }
        }
        ListNode h =null;
        return h;
    }

    public static void main(String[] args) {
        Intersection ob = new Intersection();
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        ListNode common = new ListNode(8);
        headA.next.next = common;
        headA.next.next.next = new ListNode(4);
        headA.next.next.next.next = new ListNode(5);
        ListNode headB = new ListNode(5);
        headB.next = new ListNode(0);
        headB.next.next = new ListNode(1);
        headB.next.next.next = common;
         ListNode node  = ob.getIntersectionNode(headA, headB);
            if(node!=null)
                System.out.println(node.val);

    }
}
// 160. Intersection of Two Linked Lists