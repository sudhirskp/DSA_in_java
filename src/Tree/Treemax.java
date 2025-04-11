package Tree;

public class Treemax {
    int max(Node root){
        if(root==null){
            return Integer.MIN_VALUE; //smallest value - infinte
        }
        int lmax=max(root.l);
        int rmax=max(root.r);
        return Math.max(Math.max(lmax, rmax), root.val); //Math for comprison
    }

    public static void main(String[] args) {
        Treemax ob = new Treemax();
        Node root = new Node(1);
        root.l = new Node(2);
        root.l = new Node(3);
        root.l = new Node(15);
        root.l.l = new Node(5);
        root.r= new Node(6);
        root.r= new Node(7);
        root.r.r= new Node(8);

        System.out.println(ob.max(root));
    }
}
