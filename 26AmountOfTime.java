/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int amountOfTime(TreeNode root, int start) {
        // Step 1: Create the graph (undirected) using a map.
        Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
        
        // Helper method to build the graph.
        buildGraph(root, null, graph);

        // Step 2: Perform BFS starting from the 'start' node.
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        
        // Find the start node and start BFS
        TreeNode startNode = findStartNode(root, start);
        queue.offer(startNode);
        visited.add(startNode);
        
        int minutes = 0;
        
        // Step 3: BFS to spread the infection.
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                
                for (TreeNode neighbor : graph.get(node)) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.offer(neighbor);
                    }
                }
            }
            minutes++;
        }

        return minutes - 1;
    }


      private TreeNode findStartNode(TreeNode root, int start) {
        if (root == null) {
            return null;
        }
        if (root.val == start) {
            return root;
        }
        TreeNode leftResult = findStartNode(root.left, start);
        if (leftResult != null) {
            return leftResult;
        }
        return findStartNode(root.right, start);
    }

     private void buildGraph(TreeNode node, TreeNode parent, Map<TreeNode, List<TreeNode>> graph) {
        if (node == null) return;
        
        if (!graph.containsKey(node)) {
            graph.put(node, new ArrayList<>());
        }
        
        if (parent != null) {
            graph.get(node).add(parent);
            graph.get(parent).add(node);
        }
        
        buildGraph(node.left, node, graph);
        buildGraph(node.right, node, graph);
    }
}
