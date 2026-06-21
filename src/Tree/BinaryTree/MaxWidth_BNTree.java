package Tree.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class MaxWidth_BNTree {

        class TreeNode{
            Node node;
            int index;
            TreeNode(Node node, int index){
                this.node = node;
                this.index = index;
            }
        }

        public int widthOfBinaryTree(Node root) {
            int res = 0;
            Queue<TreeNode> que = new LinkedList<>();
            que.offer(new TreeNode(root, 0));

            while (!que.isEmpty()) {
                int size = que.size();
                int f = 0, l = 0;

                for (int i = 0; i < size; i++) {

                    TreeNode no = que.poll();
                    int cur = no.index;
                    Node nn = no.node;

                    if (i == 0) f = cur;
                    if (i == size - 1) l = cur;

                    if (nn.left != null) {
                        que.offer(new TreeNode(nn.left, cur * 2 + 1));
                    }

                    if (nn.right != null) {
                        que.offer(new TreeNode(nn.right, cur * 2 + 2));
                    }
                }
                res = Math.max(res, l - f + 1);
            }
            return res;
        }

    public static void main(String[] args) {
        MaxWidth_BNTree ob = new MaxWidth_BNTree();
        Node root = new Node(1);
        root.left = new Node(3);
        root.right = new Node(2);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.right.right = new Node(9);
        System.out.println(ob.widthOfBinaryTree(root));
    }
}
//LeetCode 662