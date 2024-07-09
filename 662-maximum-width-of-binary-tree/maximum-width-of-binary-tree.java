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

 class Pair
 {
    TreeNode node;
    int data;

    Pair(TreeNode node,int data)
    {
        this.node = node;
        this.data = data;
    }
 }
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
       if(root==null)
       {
        return 0;
       }

       int width = 0;
       Queue<Pair> q = new LinkedList<>();
       q.offer(new Pair(root,0));
       while(!q.isEmpty())
       {
            int size = q.size();
            int minValue = q.peek().data;
            int first = 0, last = 0;
            for(int i=0;i<size;i++)
            {
                int id = q.peek().data-minValue;
                TreeNode node = q.peek().node;
                q.poll();

                if(i==0)
                {
                    first = id;
                }
                if(i == size-1)
                {
                    last = id;
                }

                if(node.left != null)
                {
                    q.offer(new Pair(node.left,id*2+1));
                }

                if(node.right != null)
                {
                    q.offer(new Pair(node.right,id*2+2));
                }

            }
            width = Math.max(width,last-first+1);
       }
       return width;


    }

}