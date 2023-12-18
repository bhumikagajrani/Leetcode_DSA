class Solution
{
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root)
    {
        // Code here
        ArrayList<Integer> list = new ArrayList<>();
        if(root==null) return list;
        Queue<Node> q = new LinkedList<>();
        TreeMap<Integer,Integer> map = new TreeMap<>();
        q.offer(root);
        root.hd=0;
        while(!q.isEmpty())
        {
            Node curr=q.poll();
            int ind = curr.hd;
            map.put(ind,curr.data);
            
            if(curr.left!=null)
            {
                curr.left.hd=ind-1;
                q.offer(curr.left);
            }
            
            if(curr.right!=null)
            {
                curr.right.hd=ind+1;
                q.offer(curr.right);
            }
        }
        
        for(int i:map.keySet())
        {
            list.add(map.get(i));
        }
        return list;
        
    }
}
