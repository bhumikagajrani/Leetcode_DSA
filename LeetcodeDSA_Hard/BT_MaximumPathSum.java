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
    int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxpath(root);
        return max;
    }

    private int maxpath(TreeNode curr)
    {
        if(curr==null)
        return 0;

        int leftmax=Math.max(0,maxpath(curr.left));
        int rightmax=Math.max(0,maxpath(curr.right));

        max=Math.max(max,leftmax+rightmax+curr.val);
        return (curr.val)+(Math.max(leftmax,rightmax));

    }
}
