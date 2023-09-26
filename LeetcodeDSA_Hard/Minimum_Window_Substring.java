class Solution {
    public String minWindow(String s, String t) {
        
        int start=0, end=0, count=0, min=Integer.MAX_VALUE;
        String res="";
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<t.length();i++)
        {
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)+1);
        }
        while(end<s.length())
        {
            map.put(s.charAt(end),map.getOrDefault(s.charAt(end),0)-1); 
            if(map.get(s.charAt(end))>=0)
            {
                count++;
            }  
            
            while(count==t.length())
            {
               int currwin=end-start+1;
               if(min>currwin)
               {
                   min=currwin;
                   res=s.substring(start,end+1);
               }

                map.put(s.charAt(start),map.getOrDefault(s.charAt(start),0)+1);

                if(map.get(s.charAt(start))>0)
                {
                    count--;
                }
                start++;
            }
            end++;
        }
        return res;
        
    }
}
