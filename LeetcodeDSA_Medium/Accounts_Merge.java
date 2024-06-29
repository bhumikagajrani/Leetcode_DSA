class DisjointSet {
    int parent[];
    int rank[];
    int size[];
    public DisjointSet(int n) {
        parent = new int[n];
        rank = new int[n];
        size = new int[n];
        for(int i=0;i<n;i++) {
            rank[i]=0;
            parent[i]=i;
            size[i]=1;
        }
    }

    public int findUP(int node) {
        if(node==parent[node]){
            return node;
        }

        int UP = findUP(parent[node]);
        parent[node]=UP;
        return parent[node];
    }

    public void UnionBySize(int u, int v) {
        int UP_u=findUP(u);
        int UP_v=findUP(v);
        if(UP_u==UP_v)
        {
            return;
        }
        if(size[UP_u]<size[UP_v]) {
            parent[UP_u]=UP_v;
            size[UP_v]=size[UP_v]+size[UP_u];
        }
        else {
            parent[UP_v]=UP_u;
            size[UP_v]=size[UP_u]+size[UP_v];
        }
    }

}
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        HashMap<String,Integer> map = new HashMap<>();
        DisjointSet ds = new DisjointSet(accounts.size());
        for(int i=0;i<accounts.size();i++) {
            for(int j=1;j<accounts.get(i).size();j++) {
                if(map.containsKey(accounts.get(i).get(j))) {
                    int adj = map.get(accounts.get(i).get(j));
                    ds.UnionBySize(i,adj);
                }
                else {
                    map.put(accounts.get(i).get(j),i);
                }
                
            }
        }

        ArrayList<String>[] mergedemail = new ArrayList[accounts.size()];
        for(int i=0;i<accounts.size();i++) {
            mergedemail[i]=new ArrayList<String>();
        }

        for (Map.Entry<String, Integer> it : map.entrySet()) {
            String mail = it.getKey();
            int node = ds.findUP(it.getValue());
            mergedemail[node].add(mail);
        }

        List<List<String>> res = new ArrayList<>();

        for(int i=0;i<accounts.size();i++) {
            if(mergedemail[i].size()==0) continue;
            Collections.sort(mergedemail[i]);
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for(String j:mergedemail[i]) {
                temp.add(j);
            }
            res.add(temp);
        }
        return res; 
    }
}
