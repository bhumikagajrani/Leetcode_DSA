class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int left=m-1, right=n-1, pos=m+n-1;
        while(left>=0 && right>=0)
        {
            if(nums1[left]>=nums2[right])
            {
                nums1[pos] = nums1[left];
                pos--;
                left--;
            }
            else if(nums1[left]<nums2[right])
            {
                nums1[pos] = nums2[right];
                right--;
                pos--;
            }

        }
        while(right>=0)
        {
            nums1[pos--] = nums2[right--];
        }
        

    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int nums1[] = new int[m+n];
        int nums2[] = new int[n];
        for(int i=0;i<m;i++)
        {
            nums1[i] = sc.nextInt();
        }
        for(int i=0;i<n;i++)
        {
            nums2[i] = sc.nextInt();
        }
        Solution obj = new Solution();
        obj.merge(nums1,m,nums2,n);
    }
}