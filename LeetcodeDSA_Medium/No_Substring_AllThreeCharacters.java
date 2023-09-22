class Solution {
    public int numberOfSubstrings(String s) {

        HashMap<Character,Integer> map = new HashMap<>();
        int count=0,start=0,end=0;
        while(end<s.length())
        {
            map.put(s.charAt(end),map.getOrDefault(s.charAt(end),0)+1);
            while((map.getOrDefault('a',0)>0) && (map.getOrDefault('b',0)>0) && (map.getOrDefault('c',0)>0))
            {
                count+=s.length()-end;
                map.put(s.charAt(start),map.get(s.charAt(start))-1);
                start++;
            }
            end++;
        }
        return count;
        
    }
}
