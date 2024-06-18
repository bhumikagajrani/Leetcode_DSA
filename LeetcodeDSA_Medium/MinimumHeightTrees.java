class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        if(n<2) {
            return Collections.singletonList(0);
        }

        List<List<Integer>> list = new ArrayList<>();
        List<Integer> leaves = new ArrayList<>();
        for(int i=0;i<n;i++) {
            list.add(new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++) {
            list.get(edges[i][0]).add(edges[i][1]);
            list.get(edges[i][1]).add(edges[i][0]);
        }

        for(int i=0;i<list.size();i++) {
            if(list.get(i).size()==1) {
               leaves.add(i);
            }
        }

        int remainingnodes=n;
        while(remainingnodes>2) {

            remainingnodes -= leaves.size();
            List<Integer> newleaves = new ArrayList<>();
            for(Integer i:leaves) {
                Integer neighbour = list.get(i).iterator().next();
                list.get(neighbour).remove(i);
                if(list.get(neighbour).size()==1) {
                    newleaves.add(neighbour);
                }
            }
            leaves=newleaves;   
            
        }
        return leaves;
        
    }
}
