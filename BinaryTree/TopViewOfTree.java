import java.util.*;

public class TopViewOfTree {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class Info {
        Node node;
        int hd;

        public Info(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static void topView(Node root) {
        Queue<Info> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();
        int min = 0, max = 0;

        q.add(new Info(root, 0));

        while (!q.isEmpty()) {
            Info curr = q.remove();  // curr is of type Info, not Node

            // Only put the node in the map if this horizontal distance (hd) hasn't been encountered yet
            if (!map.containsKey(curr.hd)) {
                map.put(curr.hd, curr.node);
            }

            if (curr.node.left != null) {
                q.add(new Info(curr.node.left, curr.hd - 1));
                min = Math.min(min, curr.hd - 1);  // Update min horizontal distance
            }

            if (curr.node.right != null) {
                q.add(new Info(curr.node.right, curr.hd + 1));
                max = Math.max(max, curr.hd + 1);  // Update max horizontal distance
            }
        }

        // Print the nodes in the top view
        for (int i = min; i <= max; i++) {
            System.out.print(map.get(i).data + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Since Node is static, no need to use 'tree.new'
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        
        topView(root);
    }
}

/*
 * Steps to Solve the Problem:

    1.Use Level Order Traversal with Horizontal Distance (HD):
        Start from the root, with an initial horizontal distance (HD) of 0.
        Traverse the tree level by level (using a queue for BFS), and keep track of the HD of each node.
        As you move left from a node, decrease the HD by 1.
        As you move right from a node, increase the HD by 1.

    2.Store First Node at Each Horizontal Distance:
        Use a HashMap to store the first node encountered at each HD. This node will be part of the top view.
        If a horizontal distance has already been encountered (i.e., already exists in the map), you don't update the map since you only need the first node seen from the top.

    3.Keep Track of the Minimum and Maximum Horizontal Distances:
        As you traverse the tree, update the minimum and maximum HD values to determine the range of HDs you need to print from the map.

    4.Print the Top View:
        After completing the traversal, iterate over the HashMap starting from the minimum HD to the maximum HD and print the corresponding nodes.
 */