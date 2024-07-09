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
    boolean Is = true;
    long prev = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        Inorder(root);
        return Is;
    }

    void Inorder(TreeNode root)
    {
        if(root==null) return;

        Inorder(root.left);
        if(root.val<=prev) Is=false;

        prev = root.val;

        Inorder(root.right);
    }
}