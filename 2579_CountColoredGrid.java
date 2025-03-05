class Solution {
    public long coloredCells(int n) {
        return 1+ (long)2*n*(n-1);
    }
}

// class Solution {
//     public long coloredCells(int n) {
//         long res=1;
//         int count=1;
//         while(count<n){
//             res+=(4*count++);
//         }
//         return res;
//     }
// }