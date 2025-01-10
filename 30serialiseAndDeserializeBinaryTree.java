/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfsSerialize(root, sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // Split the input string into a queue for easier deserialization
        String[] nodes = data.split(",");
        Queue<String> queue = new LinkedList<>(Arrays.asList(nodes));
        return dfsDeserialize(queue); // Deserialize using the queue
    }

    // Helper function to perform DFS and append values for serialization
    private void dfsSerialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null,");
            return;
        }
        sb.append(root.val).append(",");
        dfsSerialize(root.left, sb);   // Recur for left subtree
        dfsSerialize(root.right, sb);  // Recur for right subtree
    }

    // Helper function to deserialize the tree
    private TreeNode dfsDeserialize(Queue<String> queue) {
        String val = queue.poll();  // Get the next value in the queue
        if (val.equals("null")) {
            return null;  // Return null for "null" values
        }
        TreeNode root = new TreeNode(Integer.parseInt(val));  // Create a new node
        root.left = dfsDeserialize(queue);  // Recursively build the left subtree
        root.right = dfsDeserialize(queue); // Recursively build the right subtree
        return root;
    }
    
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
