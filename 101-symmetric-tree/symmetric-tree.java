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
    public boolean isSymmetric(TreeNode root) {

        if(root==null)
        {
            return true;
        }

        return verify(root.left, root.right);
    }

    boolean verify(TreeNode leftside, TreeNode rightside)
    {
        if(leftside == null && rightside == null)
        {
            return true;
        }
        if(leftside == null || rightside == null)
        {
            return false;
        }

        if(leftside == null || rightside == null)
        {
            return leftside==rightside;
        }
        
        return (leftside.val==rightside.val) && verify(leftside.left, rightside.right) && verify(leftside.right, rightside.left);
    }
}