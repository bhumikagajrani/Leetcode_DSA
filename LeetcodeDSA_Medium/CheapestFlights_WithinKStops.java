class Pair {
    int first;
    int second;
    Pair(int f, int s) {
        this.first=f;
        this.second=s;
    }
}

class Tuple {
    int first;
    int second;
    int third;
    Tuple(int f, int s, int t) {
        this.first=f;
        this.second=s;
        this.third=t;
    }
}


class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        List<List<Pair>> adjList = new ArrayList<>();
        int dist[]=new int[n];
        Queue<Tuple> q = new LinkedList<>();

        for(int i=0;i<n;i++) {
            adjList.add(new ArrayList<Pair>());
        }

        for(int i=0;i<flights.length;i++) {
            adjList.get(flights[i][0]).add(new Pair(flights[i][1],flights[i][2]));
        }

        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;

        q.add(new Tuple(0,src,0));

        while(!q.isEmpty()) {
            Tuple temp = q.poll();
            int node = temp.second;
            int stops = temp.first;
            int cost = temp.third;
            if(stops>k) continue;
            for(Pair pair:adjList.get(node)) {
                int adjnode = pair.first;
                int wt = pair.second;
                if((dist[adjnode]>cost+wt) && (stops<=k)) {
                    dist[adjnode]=cost+wt;
                    q.add(new Tuple(stops+1,adjnode,dist[adjnode]));
                }
            }
        }

        if(dist[dst]==Integer.MAX_VALUE) {
            dist[dst]=-1;
        }

        return dist[dst];
    }
}
