//Optimal solution
class Solution {
    public void flatten(TreeNode root) {
        if(root==null) return;

        TreeNode tempLeft=root.left;
        TreeNode tempRight=root.right;

        root.left=null;
        flatten(tempLeft);
        flatten(tempRight);

        root.right=tempLeft;
        TreeNode curr=root;
        while(curr!=null && curr.right!=null){
            curr=curr.right;
        }
        curr.right=tempRight;
    }
}


//Brute force solution
// class Solution {
//     public void flatten(TreeNode root) {
//         if(root==null) return;
//         List<Integer> res= new ArrayList<>();
//         preOrder(root,res);
//         TreeNode head= root;
//         res.remove(0);
//         for(Integer a: res){
//             head.right=new TreeNode(a);
//             head.left=null;
//             head=head.right;
//         }
//     }

//     public void preOrder(TreeNode root,List<Integer> res){
//         if(root!=null){
//             res.add(root.val);
//             preOrder(root.left,res);
//             preOrder(root.right,res);
//         }
//         return;
//     }
// }