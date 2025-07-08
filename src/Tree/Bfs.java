package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class Bfs {


    public void bfs(Node root) {
        if (root == null) return;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            Node curr = q.poll();
            System.out.print(curr.val + " ");
            if (curr.l != null) {
                q.offer(curr.l);
            }
            if (curr.r != null) {
                q.offer(curr.r);
            }
        }
    }

    public static void main(String[] args) {
        Bfs ob = new Bfs();
        Node root = new Node(1);
        root.l = new Node(2);
        root.r = new Node(3);
        root.l.l = new Node(4);
        root.l.r = new Node(5);
        ob.bfs(root);
        return;
    }
}