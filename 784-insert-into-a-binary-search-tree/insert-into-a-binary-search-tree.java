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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode newNode = new TreeNode(val);

        if(root==null)
        {
            root = newNode;
        }

        else
        {
            TreeNode temp = root;
            TreeNode parent = null;

            while(temp!=null)
            {
                parent = temp;
                if(val<temp.val)
                {
                    temp = temp.left;
                }
                else if(val>temp.val)
                {
                    temp = temp.right;
                }
            }

            if(val<parent.val)
            {
                parent.left = newNode;
            }
            else
            {
                parent.right = newNode;
            }
        }

        return root;
    }
}