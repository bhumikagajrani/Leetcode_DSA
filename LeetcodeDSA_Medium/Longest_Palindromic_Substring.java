class Solution {
    public String longestPalindrome(String s) {
        
        int start=0, end=0;
        for(int i=0;i<s.length();i++)
        {
            int len1=expandaroundcenter(s,i,i);
            int len2=expandaroundcenter(s,i,i+1);
            
            int maxlength=Math.max(len1,len2);
            if(maxlength>(end-start))
            {
                start = i-(maxlength-1)/2;
                end = i+(maxlength)/2;
            }
        }
        return s.substring(start,end+1);
}

private int expandaroundcenter(String s, int left, int right)
{
    while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right))
    {
        left--;
        right++;
    }
    return right-left-1;
}
}
