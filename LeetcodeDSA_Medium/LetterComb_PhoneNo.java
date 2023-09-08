class Solution {
    public List<String> letterCombinations(String digits) {
        
        if(digits.length()==0) return Collections.emptyList();
        HashMap<Character,String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        List<String> ans = new ArrayList<>();
        String temp="";
        generatecomb(0,digits,temp,ans,map);
        return ans;

    }

    private void generatecomb(int i, String s, String temp, List<String> ans, HashMap<Character, String> map)
    {
        if(i==s.length())
        {
            ans.add(temp);
            return;
        }

        String str = map.get(s.charAt(i));
        for(int j=0;j<str.length();j++)
        {
            char c = str.charAt(j);
            generatecomb(i+1,s,temp+c,ans,map);
           
            
        }
    }
}
