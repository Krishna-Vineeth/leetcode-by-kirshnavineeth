class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int small = Math.min(p.val, q.val);
        int large = Math.max(p.val, q.val);
        while (root != null) {
            if (large < root.val) 
                root = root.left;
            else if (small > root.val) 
                root = root.right;
            else 
                return root;
        }
        return null;
    }
}