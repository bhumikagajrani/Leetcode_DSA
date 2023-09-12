class Solution {
    public int myAtoi(String s) {
        s=s.trim();
        if(s.length()==0) return 0;
        long ans=0;
        int sign=1;
        int i=0;
        if(s.charAt(0)=='-')
        {
            sign=-1;
            i++;
        }
        if(s.charAt(0)=='+')
        {
            i++;
        }
        for(int j=i;j<s.length();j++)
        {
            if(!Character.isDigit(s.charAt(j)) || s.charAt(j)==' ')
            break;

            ans=ans*10+(s.charAt(j)-'0');
            if(sign==-1 && (-1*ans)<Integer.MIN_VALUE)
            {
                return Integer.MIN_VALUE;
            }
            if(sign==1 && ans>Integer.MAX_VALUE)
            {
                return Integer.MAX_VALUE;
            }
            
        }
        return (int)ans*sign;
        
        
    }
}
