class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return createBST(nums,0,nums.length-1);
    }

    public TreeNode createBST(int[] nums, int low, int high){
        int mid=low+(high-low)/2;
        if(low>high){
            return null;    
        }

        TreeNode root= new TreeNode(nums[mid]);
        root.left=createBST(nums,low,mid-1);
        root.right=createBST(nums,mid+1,high);
        return root; 
    }
}