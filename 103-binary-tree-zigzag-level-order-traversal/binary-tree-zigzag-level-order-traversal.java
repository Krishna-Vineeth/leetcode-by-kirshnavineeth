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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null)
        {
            return res;
        }

        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.offer(root);
        boolean flag = false;
        while(!dq.isEmpty())
        {
            int size = dq.size();
            List<Integer> value = new ArrayList<>();
            

            for(int i=0;i<size;i++)
            {
                root = dq.poll();
                
                // if (flag) ? value.add(0,root.val) : value.add(root.val);
                if(flag)
                {
                    value.add(0,root.val);
                }
                else
                {
                    value.add(root.val);
                }
                
                if(root.left!=null)
                {
                    dq.offer(root.left);
                }

                if(root.right!=null)
                {
                    dq.offer(root.right);
                }
                 
            }
            
            res.add(value);
            flag = !flag;
        }
        return res;
    }
}