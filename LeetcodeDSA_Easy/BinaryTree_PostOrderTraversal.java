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
    public List<Integer> postorderTraversal(TreeNode root) {

        Stack<TreeNode> st = new Stack<>();
        List<Integer> res = new ArrayList<>();
        TreeNode curr=root;
        
        while(curr!=null || !st.isEmpty())
        {
            if(curr!=null)
            {
                st.push(curr);
                curr=curr.left;
            }
            else
            {
                TreeNode temp=st.peek().right;
                if(temp!=null)
                {
                    curr=temp;
                }
                else
                {
                    temp=st.peek();
                    st.pop();
                    res.add(temp.val);

                    while(!st.isEmpty() && temp==st.peek().right)
                    {
                        temp=st.peek();
                        res.add(temp.val);
                        st.pop();
                    }
                }
            }
        }

        return res;

    }
}
