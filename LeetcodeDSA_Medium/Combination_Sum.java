class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        combinationsum(0,target,candidates,list,new ArrayList<>());
        return list;
    }
    void combinationsum(int index, int target, int[] arr, List<List<Integer>>list, List<Integer> ans )
    {
        if(index==arr.length)
        {
            if(target==0)
            {
                list.add(new ArrayList<>(ans));
            }
            return;
        }
        if(arr[index]<=target)
        {
            ans.add(arr[index]);
            combinationsum(index,target-arr[index],arr,list,ans);
            ans.remove(ans.size()-1);
        }
        combinationsum(index+1,target,arr,list,ans);
    }
}