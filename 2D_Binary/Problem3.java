//378. Kth Smallest Element in a Sorted Matrix
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
     int n = matrix.length;
     int l = matrix[0][0], r = matrix[n-1][n-1];
     while(l < r){
        int mid = l + (r-l)/2;
        int val = isCheck(matrix,n,mid);

        if(val < k) l = mid+1;
        else r = mid; 
     }
     return l;
                
    }

    int isCheck(int[][] matrix,int n,int k){
        int count = 0;
        int i = n-1,j=0;
        while(j < n && i >= 0){
            if(matrix[i][j] <= k){
                count += i +1;
                j++;
            }
            else i--;
        }
        return count;
    }
}
