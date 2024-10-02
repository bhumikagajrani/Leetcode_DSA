class Solution {
    public int numPairsDivisibleBy60(int[] time) {

        HashMap<Integer,Integer> map = new HashMap<>();
        int ans=0;

        for(int i=0;i<time.length;i++) {

            if(time[i]%60==0) {
                ans += map.getOrDefault(0,0);
            }
            else {
                ans += map.getOrDefault(60-time[i]%60,0);
            }
            map.put(time[i]%60,map.getOrDefault(time[i]%60,0)+1);
        }
        
        return ans;

    }
}
