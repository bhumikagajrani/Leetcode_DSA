class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
       
       int m=nums1.length, n=nums2.length, size=m+n;
       if(m>n) return findMedianSortedArrays(nums2,nums1);
       int left=(m+n+1)/2;
       int l=0, h=m;
       while(l<=h)
       {
           int mid1=(l+h)/2;
           int mid2=left-mid1;
           int l1=(mid1>0)?nums1[mid1-1]:Integer.MIN_VALUE;
           int r1=(mid1<m)?nums1[mid1]:Integer.MAX_VALUE;
           int l2=(mid2>0)?nums2[mid2-1]:Integer.MIN_VALUE;
           int r2=(mid2<n)?nums2[mid2]:Integer.MAX_VALUE;

           if(l1<=r2 && l2<=r1)
           {
               if(size%2==1)
               {
                   return Math.max(l1,l2);
               }
               else
               {
                   return (double)((Math.max(l1,l2))+(Math.min(r1,r2)))/2;
               }
           }
           else if(l1>r2)
           {
               h=mid1-1;
           }
           else
           {
               l=mid1+1;
           }

       }
       return 0;

    }
}