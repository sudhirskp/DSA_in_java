package Tree;

//class Node{
//    int val;
//    Node l;
//    Node r;
//
//    Node{
//        this.val=val;
//        this.l=l;
//        this.r=r;
//    }


import java.sql.SQLOutput;

public class TreeSum {
    int  sum(Node root){
        if(root==null) {
            return 0;
        }
        int s=0;
        //sum of inorder tree traversal
        int lsum=sum(root.l);
        int rsum=sum(root.r);
        //System.out.println(s);
        return lsum+rsum+root.val;
    }

    public static void main(String[] args) {
        TreeSum ob = new TreeSum();
        Node root = new Node(10);
        root.l= new Node(1);
        root.l.l= new Node(3);
        root.r= new Node(3);
        root.r= new Node(4);
        root.r.r= new Node(5);
        //ob.sum(root);
        System.out.println(ob.sum(root));
    }


}
