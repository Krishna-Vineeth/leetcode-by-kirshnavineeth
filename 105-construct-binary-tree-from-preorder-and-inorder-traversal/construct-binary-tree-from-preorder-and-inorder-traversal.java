// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode() {}
//  *     TreeNode(int val) { this.val = val; }
//  *     TreeNode(int val, TreeNode left, TreeNode right) {
//  *         this.val = val;
//  *         this.left = left;
//  *         this.right = right;
//  *     }
//  * }
//  */
// class Solution {
//     public TreeNode buildTree(int[] preorder, int[] inorder) {

//         Map<Integer,Integer> mp = new HashMap<>();

//         for(int i=0;i<inorder.length;i++)
//         {
//             mp.put(inorder[i],i);
//         }

//         TreeNode root = constructBT(preorder,0,preorder.length-1,
//                                     inorder,0,inorder.length-1,
//                                     mp);

//         return root;
//     }

//     TreeNode constructBT(int[] preorder, int preStart, int preEnd, 
//                          int[] inorder, int inStart, int inEnd,
//                          Map<Integer,Integer> mp){
        
//         if(preStart > preEnd || inStart > inEnd) return null;

//         TreeNode root = new TreeNode(preorder[preStart]);

//         int inorderRootIndex = mp.get(root.val);
//         int numsLeft = inorderRootIndex - inStart;

//         root.left = constructBT(preorder, preStart+1, preStart+numsLeft,
//                                 inorder, inStart, inorderRootIndex-1,
//                                 mp);
//         root.right = constructBT(preorder, preStart+numsLeft+1,preEnd,
//                                  inorder, inorderRootIndex+1, inEnd,
//                                  mp);

//         return root;


//     }
// }

class Solution {
    int i = 0; 
    int p = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // preorder N->L->R
        // in order L->N->R
        return build(preorder, inorder, Integer.MIN_VALUE);
    }

    public TreeNode build(int[] pre, int[] in, int stop){
        if(p >= pre.length){
            return null;
        }

        if(in[i] == stop){
            i++;
            return null;
        }

        TreeNode node = new TreeNode(pre[p++]);
        node.left = build(pre, in, node.val);
        node.right = build(pre, in, stop);

        return node;
    }
}