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
class Vertical {
    TreeNode node;
    int row;
    int col;
    Vertical(TreeNode node, int row, int col) {
        this.node=node;
        this.row=row;
        this.col=col;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {

        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Vertical> q = new LinkedList<>();
        q.offer(new Vertical(root,0,0));
        while(!q.isEmpty())
        {
            Vertical vertical = q.poll();
            TreeNode curr=vertical.node;
            int x = vertical.col;
            int y = vertical.row;

            if(!map.containsKey(x))
            map.put(x, new TreeMap<>());

            if(!map.get(x).containsKey(y))
            map.get(x).put(y, new PriorityQueue<>());

            map.get(x).get(y).offer(curr.val);

            if(curr.left!=null)
            {
                q.offer(new Vertical(curr.left,y+1,x-1));
            }
            if(curr.right!=null)
            {
                q.offer(new Vertical(curr.right,y+1,x+1));
            }

        }

        List<List<Integer>> list = new ArrayList<>();
        for(TreeMap<Integer,PriorityQueue<Integer>> i:map.values())
        {
            list.add(new ArrayList<>());
            for(PriorityQueue<Integer> pq:i.values())
            {
                while(!pq.isEmpty())
                {
                    list.get(list.size()-1).add(pq.poll());
                }
            }
        }
        return list;
    }
}
