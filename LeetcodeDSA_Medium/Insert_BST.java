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
        
        if(root==null) 
        {
            return new TreeNode(val);
        }
        if(val>root.val)
        {
            TreeNode curr=insertIntoBST(root.right,val);
            root.right=curr;
        }
        if(val<root.val)
        {
            TreeNode curr=insertIntoBST(root.left,val);
            root.left=curr;
        }
        return root;
        
    }
}
