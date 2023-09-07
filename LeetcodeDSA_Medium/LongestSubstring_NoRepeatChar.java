class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0) return 0;
        int maxans=Integer.MIN_VALUE;
        HashMap<Character,Integer> map = new HashMap<>();
        int l=0;
        for(int r=0;r<s.length();r++)
        {
            if(map.containsKey(s.charAt(r)))
            {
               l=Math.max(map.get(s.charAt(r))+1,l);
                
            }
            map.put(s.charAt(r),r);
            maxans=Math.max(maxans,r-l+1);

        }
        return maxans;
        
    }
}
