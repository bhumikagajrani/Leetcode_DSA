class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n=arr.length;
        int l=0,h=n-1;
        while(l<=h)
        {
            int mid=(l+h)/2;
            int missing=arr[mid]-(mid+1);
            if(missing<k)
            {
                l=mid+1;
            }
            else
            {
                h=mid-1;
            }

        }
        return l+k;
    }
}
