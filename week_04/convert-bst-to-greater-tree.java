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
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        vistNode(root);
        buildSum();
        rebuild(root);
        
        return root;
    }
    
    // 重新构建累加值
    private void rebuild(TreeNode root) {
        if (root == null) {
            return;
        }
        int node = root.val;
        root.val = nodeSum.get(node);
        rebuild(root.left);
        rebuild(root.right);
        
    }
    
    // 构建前缀和，产生每个节点的对于前缀和映射
    private void buildSum() {
        preSum = new ArrayList<>(orderArr.size() + 1);
        preSum.add(0);
        
        for(int i=1; i <= orderArr.size(); i++) {
            preSum.add(preSum.get(i-1) + orderArr.get(i-1));
        }
        
        nodeSum = new HashMap<>(orderArr.size());
        int lastSum = preSum.get(preSum.size() - 1);
        for(int i=1; i <= orderArr.size(); i++ ) {
            int node = orderArr.get(i-1);
            int sum = lastSum - preSum.get(i-1);
            
            nodeSum.put(node, sum);
        }
    }
    
    // 中序遍历，需要前缀和
    private void vistNode(TreeNode root) {
        if (root == null) {
            return;
        }
        vistNode(root.left);
        orderArr.add(root.val);
        vistNode(root.right);
    }
    
    private Map<Integer,Integer> nodeSum;
    
    private List<Integer> orderArr = new ArrayList<>();
    
    private List<Integer> preSum;
}
