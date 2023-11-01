class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        Helper(1,n,k, new ArrayList<>(),ans);
        return ans;
    }


    private void Helper(int ind, int num, int k, List<Integer> list, List<List<Integer>> ans)
    {
        if(k==0)
        {
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i=ind;i<=num;i++)
        {
            list.add(i);
            Helper(i+1,num,k-1,list,ans);
            list.remove(list.size()-1);
        }
        
       
    }
}
