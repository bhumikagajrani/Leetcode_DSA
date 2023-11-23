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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode curr=root;
        if(curr!=null)
        {
            q.offer(curr);
        }
        while(!q.isEmpty())
        {
            List<Integer> list = new ArrayList<>();
            int size=q.size();
            while(size>0)
            {
                TreeNode top=q.peek();
                if(top.left!=null)
                {
                    q.offer(top.left);
                }
                if(top.right!=null)
                {
                    q.offer(top.right);
                }
                list.add(q.poll().val);
                size--;
            }
            res.add(new ArrayList<>(list));
        }

        return res;
    }
}
