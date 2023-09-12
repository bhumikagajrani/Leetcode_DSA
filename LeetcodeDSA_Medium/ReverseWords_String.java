class Solution {
    public String reverseWords(String s) {
        s=s.trim();
        s=" "+s;
        String res="";
        String ans="";
        for(int i=s.length()-1;i>=0;i--)
        {
            if(s.charAt(i)==' ')
            {
                
                if(res.length()>0)
                {
                    if(ans.length()==0)
                {
                    ans=res;
                    res="";
                }
                else
                {
                    ans=ans+ " " +res;
                    res="";
                }
                    
                }
            }
            else
            {
                res=s.charAt(i)+res;
            }
            
        }
        return ans;

        
    }
}
