// Problem statement
// There is an integer array ‘A’ of size ‘N’.

// Number of inversions in an array can be defined as the number of pairs of ‘i’, ‘j’ such that ‘i’ < ‘j’ and ‘A[i]’ > ‘A[j]’.

// You must return the number of inversions in the array.

// For example,
// Input:
// A = [5, 3, 2, 1, 4], N = 5
// Output:
// 7
// Explanation: 
// The pairs satisfying the condition for inversion are (1, 2), (1, 3), (1, 4), (1, 5), (2, 3), (2, 4), and (3, 4). 
// The number of inversions in the array is 7.
// Detailed explanation ( Input/output format, Notes, Images )
// Sample Input 1:
// 4
// 4 3 2 1
// Sample Output 1:
// 6
// Explanation Of Sample Input 1:
// Input:
// A = [4, 3, 2, 1], N = 4
// Output:
// 6
// Explanation: 
// The pairs satisfying the condition for inversion are (1, 2), (1, 3), (1, 4), (2, 3), (2, 4), and (3, 4).    
// The number of inversions in the array is 6.
// Sample Input 2:
// 5
// 1 20 6 4 5
// Sample Output 2:
// 5
// Constraints:
// 1 <= N <= 10^5
// 1 <= A[i] <= 10^9
// Time Limit: 1 sec

class Solution {
    static int count=0;
    public static int numberOfInversions(int []a, int n) {
        // Write your code here.
        divide(a,0,n-1);
        return count;

    }

    public static void divide(int[] nums, int l, int r){
        if(l>=r) return;
        int mid= l+(r-l)/2;
        divide(nums,l,mid);
        divide(nums,mid+1,r);
        merge(nums,l,mid,r);
    }

    public static void merge(int[] nums,int l,int mid, int r){
        int[] res= new int[r-l+1];
        int i=l;
        int j=mid+1;
        int k=0;
        while(i<=mid && j<=r){
            if(nums[i]>nums[j]){
                res[k++]=nums[j++];
                count+=mid-i+1;
            }else{
                res[k++]=nums[i++];
            }
        }

        while(i<=mid){
            res[k++]=nums[i++];
        }
        while(j<=r){
            res[k++]=nums[j++];
        }

        for(i=l,k=0;i<=r;i++,k++){
            nums[i]=res[k];
        }
    }

}