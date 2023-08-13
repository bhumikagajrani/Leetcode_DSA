class Solution {
    public int[] sortArray(int[] nums) {
        int low=0, high=nums.length-1;
        Quicksort(nums,low,high);
        return nums;
    }

    void Quicksort(int nums[], int low, int high)
    {
        if(low<high)
        {
            int partIndex = Partition(nums,low,high);
            Quicksort(nums,low,partIndex-1);
            Quicksort(nums,partIndex+1,high);
        }

    }

    int Partition(int nums[], int low, int high)
    {
        int pivot = low, i=low,j=high;
        while(i<j)
        {
            while((nums[i]<=nums[pivot]) && (i<=high-1))
            i++;
            while((nums[j]>nums[pivot]) && (j>=low+1))
            j--;
            if(i<j)
            {
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
            }
        }
        int temp=nums[j];
        nums[j]=nums[low];
        nums[low]=temp;
        return j;

    }

}