class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String,List<String>> map = new HashMap<>();
        for(int i=0;i<strs.length;i++)
        {
            String freq = getfrequency(strs[i]);
            if(!map.containsKey(freq))
            {
                map.put(freq,new ArrayList<>());
            }
            map.get(freq).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }

    private String getfrequency(String s)
    {
        int freq[] = new int[26];
        for(char c:s.toCharArray())
        {
            freq[c-'a']++;
        }
        StringBuilder freqstring = new StringBuilder();
        char c ='a';
        for(int i=0;i<freq.length;i++)
        {
            freqstring.append(c);
            freqstring.append(freq[i]);
            c++;
        }
        return freqstring.toString();

    }
}
