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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++)
        {
            map.put(inorder[i],i);
        }
        return Helper(inorder,0,inorder.length-1,postorder,0,postorder.length-1,map);
        
    }

    public TreeNode Helper(int[] inorder,int instart, int inend, int[] postorder, int poststart, int postend, HashMap<Integer,Integer> map)
    {
        if(instart>inend || poststart>postend)
        {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postend]);
        int ind = map.get(root.val);
        int leftsize = ind-instart;
        int rightsize = inend-ind;
        root.left = Helper(inorder,instart,ind-1,postorder,poststart,poststart+leftsize-1,map);
        root.right = Helper(inorder,ind+1,inend,postorder,postend-rightsize,postend-1,map);
        return root;
    }
}
