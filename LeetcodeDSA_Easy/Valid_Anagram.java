class Solution {
    public boolean isAnagram(String s, String t) {

        int val[] = new int[26];
        for(int i=0;i<s.length();i++)
        {
            val[s.charAt(i)-'a']++;
        }
        for(int i=0;i<t.length();i++)
        {
            val[t.charAt(i)-'a']--;
        }
        for(int i:val)
        {
            if(i!=0)
            return false;
        }
        return true;
        
    }
}
