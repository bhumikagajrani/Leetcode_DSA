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
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr=root;
        if(curr!=null)
        {
            st.push(root);
        }
        while(!st.isEmpty())
        {  
            TreeNode temp=st.peek();
            res.add(temp.val);
            st.pop();
            if(temp.right!=null)
            {
                st.push(temp.right);
                
            }

            if(temp.left!=null)
            {
                st.push(temp.left);
               
            }
        }
        return res;
    }
}
