class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String,List<String>> map = new HashMap<>();
        for(int i=0;i<strs.length;i++)
        {

            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            String sortarr = new String(charArray);
            if(!map.containsKey(sortarr))
            {
                map.put(sortarr,new ArrayList<>());
            }
            map.get(sortarr).add(strs[i]);

        }
        return new ArrayList<>(map.values());
    }
}
