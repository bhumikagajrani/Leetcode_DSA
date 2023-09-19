class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer> map = new HashMap<>();
        int start=0, end=0, mostfreq=0, maxlen=0;
        while(end<s.length())
        {
           
            map.put(s.charAt(end),(map.getOrDefault(s.charAt(end),0)+1));
            
            int size=end-start+1;
            mostfreq = Math.max(mostfreq, map.get(s.charAt(end)));
            if(size-mostfreq<=k)
            {
                maxlen=Math.max(maxlen,size);
            }
            else
            {
                map.put(s.charAt(start),(map.getOrDefault(s.charAt(start),0)-1));
                start++;

            }
            end++;

        }
        return maxlen;
        


    }
}
