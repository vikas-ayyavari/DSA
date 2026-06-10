class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int maxi = 0;
        for(int n : nums){
            maxi = Math.max(maxi,n);
        }

        int l = 1;
        int res = -1;

        while(l <= maxi){
            int mid = l + (maxi - l)/2;

            int check = 0;
            for(int n : nums){
                check += (n + mid -1) /mid;
            }

            if(check <= threshold){
                res = mid;
                maxi = mid -1;
            }
            else l = mid+1;
        }

        return res;
    }
}
