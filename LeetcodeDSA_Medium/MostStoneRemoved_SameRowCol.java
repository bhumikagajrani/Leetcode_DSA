class DisjointSet {
    int parent[];
    int size[];
    public DisjointSet(int n) {
        parent = new int[n+1];
        size = new int[n+1];
        for(int i=0;i<=n;i++) {
            parent[i]=i;
            size[i]=1;
        }
    }

    public int findUP(int node) {
        if(node==parent[node]) {
            return node;
        }

        parent[node]=findUP(parent[node]);
        return parent[node];
    }

    public void UnionBySize(int u, int v) {
        int UP_u=findUP(u);
        int UP_v=findUP(v);
        if(UP_u==UP_v){
            return;
        }
        if(size[UP_u]<size[UP_v]) {
            parent[UP_u]=UP_v;
            size[UP_v]=size[UP_v]+size[UP_u];
        }
        else {
            parent[UP_v]=UP_u;
            size[UP_u]=size[UP_u]+size[UP_v];
        }
        
    }
}
class Solution {
    public int removeStones(int[][] stones) {

        int maxrow=0, maxcol=0;
        for(int i=0;i<stones.length;i++) {
            maxrow=Math.max(maxrow,stones[i][0]);
            maxcol=Math.max(maxcol,stones[i][1]);
        }

        int num_nodes=maxrow+maxcol+1;
        DisjointSet ds = new DisjointSet(num_nodes);
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<stones.length;i++) {
            int row = stones[i][0];
            int new_col = stones[i][1]+maxrow+1;
            ds.UnionBySize(row,new_col);
            map.put(row,1);
            map.put(new_col,1);
        }

        int num_comp=0;
        for(int k:map.keySet()) {
            if(k==ds.findUP(k)) {
                num_comp++;
            }
        }
        return stones.length-num_comp;
    }
}
