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
class Pair {
    TreeNode node;
    int ind;
    Pair(TreeNode temp, int index)
    {
        this.node=temp;
        this.ind=index;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        
        if(root==null)
        return 0;

        int ans=0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root,0));
        while(!q.isEmpty())
        {
            int size=q.size();
            int currmin=q.peek().ind;
            int left=0, right=0;
            for(int i=0;i<size;i++)
            {
                int currid=q.peek().ind-currmin;
                TreeNode curr=q.peek().node;
                q.poll();
                if(i==0)
                {
                    left=currid;
                }
                if(i==size-1)
                {
                    right=currid;
                }
                if(curr.left!=null)
                {
                    q.offer(new Pair(curr.left,2*currid+1));
                }
                if(curr.right!=null)
                {
                    q.offer(new Pair(curr.right,2*currid+2));
                }

            }
            ans=Math.max(ans,right-left+1);
        }
        return ans;

        
    }
}
