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
    int count = 0;
    int small = 0;

    public int kthSmallest(TreeNode root, int k) {
        inorder(root,k);
        return small;
    }

    void inorder(TreeNode node, int k)
    {
        if(node==null || count>=k) return;

        inorder(node.left, k);
        count++;
        if(count==k)
        {
            small = node.val;
            return;
        }

        inorder(node.right,k);

    }
}