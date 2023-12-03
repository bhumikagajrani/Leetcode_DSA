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
       return true;
       
       return Helper(root.left,root.right);
        
    }

    private boolean Helper(TreeNode root1, TreeNode root2)
    {
        if(root1==null || root2==null)
        {
            return root1==root2;
        }

        return ((root1.val==root2.val) && (Helper(root1.left,root2.right)) && (Helper(root1.right,root2.left)));
        
    }

    
}
