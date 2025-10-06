package Tree;



public class Root_SubRoot {

    //TC : O(N+M) , SC : O(N+M)
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        public boolean isSubtree(Node root, Node subRoot) {
            if(root==null) return false;
            post(root,sb1);
            post(subRoot,sb2);

            if(sb2.length()>sb1.length()) return false;

            // for(int i=0;i<sb1.length()-sb2.length()+1;i++){
            //     String str = sb1.substring(i,sb2.length());
            //     if(str.equals(sb2.toString())) return true;
            // }
            //System.out.println(sb1.toString());
            //System.out.print(sb2.toString());

            return sb1.toString().contains(sb2.toString());
        }

        void post(Node node, StringBuilder sb){
            if(node==null){
                sb.append(".");
                return ;
            }
            post(node.l,sb);
            post(node.r,sb);
            sb.append(node.val).append(",");
        }


    public static void main(String[] args) {
        Root_SubRoot ob = new Root_SubRoot();
        Node root = new Node(3);
        root.l = new Node(4);
        root.r = new Node(5);
        root.l.l = new Node(1);
        root.l.r = new Node(2);
        // root.l.r.l = new Node(0);
        Node subRoot = new Node(4);
        subRoot.l = new Node(1);
        subRoot.r = new Node(2);
        boolean ans = ob.isSubtree(root, subRoot);
        System.out.println(ans);
    }
}
//leetCode 572
//https://leetcode.com/problems/subtree-of-another-tree/description/