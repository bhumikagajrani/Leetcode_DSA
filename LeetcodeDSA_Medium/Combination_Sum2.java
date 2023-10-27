class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> ans = new ArrayList<>();
        Helper(0,candidates,target,new ArrayList<>(),ans);
        return ans;

    }

    private void Helper(int ind, int[] arr, int target, List<Integer> list, List<List<Integer>> ans)
    {

        if(target==0)
        {
            ans.add(new ArrayList<>(list));
        }
        
        for(int i=ind;i<arr.length;i++)
        {
            if(i!=ind && arr[i]==arr[i-1])
            {
                continue;
            }
            if(arr[i]>target)
            {
                break;
            }
            list.add(arr[i]);
            Helper(i+1,arr,target-arr[i],list,ans);
            list.remove(list.size()-1);

        }


    }
}
