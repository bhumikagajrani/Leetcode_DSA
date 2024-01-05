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
    public TreeNode bstFromPreorder(int[] preorder) {
        
        return Helper(preorder, 0, preorder.length-1);
    }

    private TreeNode Helper(int[] preorder, int start, int end)
    {
        if(start>end)
        {
            return null;
        }

        TreeNode root = new TreeNode(preorder[start]);
        int i;
        for(i=start;i<=end;i++)
        {
            if(preorder[i]>root.val)
            {
                break;
            }
        }
        root.left = Helper(preorder,start+1,i-1);
        root.right = Helper(preorder,i,end);
        return root;        
    } 
}
