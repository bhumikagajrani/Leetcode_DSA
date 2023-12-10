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
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level=0;
        while(!q.isEmpty())
        {
            int size=q.size();
            List<Integer> list = new ArrayList<>();
            while(size>0)
            {
                TreeNode curr=q.poll();
                if(curr!=null)
                {
                    list.add(curr.val);
                    q.offer(curr.left);
                    q.offer(curr.right);
                }
                size--;
            }
            if(list.size()>0)
            {
                if(level%2==1)
                {
                    Collections.reverse(list);
                }
                res.add(list); 
            }
            
            level++;
        }
        return res;
        
        
    }
}
