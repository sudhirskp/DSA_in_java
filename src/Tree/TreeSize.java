package Tree;

public class TreeSize {
    int TSize(Node root){
        if(root==null){
            return 0;
        }
        int left= TSize(root.l);
        int right= TSize(root.r);
        return left+right+1;
    }

    public static void main(String[] args) {
        TreeSize ob = new TreeSize();
        Node root = new Node(1);
        root.l= new Node(2);
        root.l= new Node(3);
        root.l.l= new Node(4);
        root.r= new Node(5);
        root.r.r=new Node(6);
        System.out.println(ob.TSize(root));
    }
}
