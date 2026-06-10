class Solution {
    public int splitArray(int[] nums, int k) {
        int l = 0;
        int r = 0;
        for(int n:nums){
            l = Math.max(l,n);
            r += n;
        }
        
        int res = -1;
        while(l <= r){
            int mid =  l + (r-l)/2;
            
            int temp = 0;
            int c = 1;
            for(int i:nums){
                 temp += i;
                if(temp > mid){
                    c++;
                    temp = i;
                }
            }

            if( c <= k){
                res = mid;
                r = mid -1;
            }
            else l = mid + 1;
        }

        return res;
    }

}
