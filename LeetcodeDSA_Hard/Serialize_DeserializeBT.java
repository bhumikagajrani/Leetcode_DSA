/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    Queue<TreeNode> q = new LinkedList<>();

    public String serialize(TreeNode root) {

        if(root==null)
        return "";

        StringBuilder sb = new StringBuilder();
        q.add(root);
        while(!q.isEmpty())
        {
            TreeNode top = q.poll();
            if(top==null)
            {
                sb.append("# ");
                continue;
            }
            else
            {
                sb.append(top.val+" ");
            }
            q.add(top.left);
            q.add(top.right);

        }
        q.clear();
        return sb.toString();   
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if(data.length()==0)
        return null;

        String str[] = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(str[0]));
        q.add(root);
        for(int i=1;i<str.length;i++)
        {
            TreeNode top = q.poll();
            if(!str[i].equals("#"))
            {
                top.left = new TreeNode(Integer.parseInt(str[i]));
                q.add(top.left);

            }
            if(!str[++i].equals("#"))
            {
                top.right = new TreeNode(Integer.parseInt(str[i]));
                q.add(top.right);
            }
        }
        return root;
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
