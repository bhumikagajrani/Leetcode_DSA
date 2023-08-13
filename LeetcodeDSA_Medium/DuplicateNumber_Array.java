class Solution {
    public int findDuplicate(int[] nums) {
        int size = nums.length;
        int slow=nums[0], fast=nums[0];
        do {
            slow=nums[slow];
            fast=nums[nums[fast]];            
        } while(slow!=fast);

        fast=nums[0];
        while(slow!=fast) {
            slow=nums[slow];
            fast=nums[fast];
        }
        return fast;
    }
}