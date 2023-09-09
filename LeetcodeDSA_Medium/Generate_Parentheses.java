class Solution {
    public List<String> generateParenthesis(int n) {
        
    List<String> ans = new ArrayList<>();
    generaterecur(n,0,0,"",ans);
    return ans;
    }
    private void generaterecur(int n, int open, int close, String res, List<String> ans)
    {
        if(open==n && close==n)
        {
            ans.add(res);
            return;
        }
        if(open<n)
        {
            generaterecur(n,open+1,close,res+'(',ans);
        }
        if(open>close)
        {
            generaterecur(n,open,close+1,res+')',ans);
        }

    }

        
}
