//668. Kth Smallest Number in Multiplication Table
class Solution {
    public int findKthNumber(int m, int n, int k) {
     int l = 1, r = m*n;

     while(l < r){
        int mid = l + (r-l)/2;
        int val = isCheck(m,n,mid);

        if(val < k) l = mid + 1;
        else r = mid;
     }
     return l;
    }

    int isCheck(int m ,int n, int mid){
        int count = 0;
        int r = 1;
        while(m >= 1 && r <= n){
            if(m*r <= mid){
                count += m;
                r++;
            }
            else m--;
        }
        return count;
    }
}
