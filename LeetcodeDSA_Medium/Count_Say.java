class Solution {
    public String countAndSay(int n) {

        String res="1";
        for(int i=2;i<=n;i++)
        {
            res=helper(res);
        }
        return res;
        
    }

    private String helper(String res)
    {
        
        StringBuilder sb = new StringBuilder();
        res=res+'$';
        int count=1;
        for(int i=1;i<res.length();i++)
        {
            if(res.charAt(i)==res.charAt(i-1))
            {
                count++;
            }
            else
            {
                sb.append(count);
                sb.append(res.charAt(i-1));
                count=1;
            }
        }
        return sb.toString();


    }
}
