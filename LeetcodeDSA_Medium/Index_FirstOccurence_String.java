//KMP alg
class Solution {
    public int strStr(String haystack, String needle) {
        
        if(needle.length()==0) return 0;
        int lps[] = new int[needle.length()];

        int prevlps=0, i=1;
        while(i<needle.length())
        {
            if(needle.charAt(i)==needle.charAt(prevlps))
            {
                prevlps++;
                lps[i]=prevlps;
                i++;
            }
            else if(prevlps==0)
            {
                lps[i]=0;
                i++;
            }
            else
            {
                prevlps=lps[prevlps-1];
            }
        }

        i=0;
        int j=0;
        while(i<haystack.length())
        {
            if(haystack.charAt(i)==needle.charAt(j))
            {
                i++;
                j++;
            }
            else {
                if(j==0)
                i++;
                else
                j=lps[j-1];
            }
            if(j==needle.length())
            {
                return i-needle.length();
            }
        }
        return -1;
        
    }
}
