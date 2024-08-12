import java.util.List;
import java.util.ArrayList;
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res= new ArrayList<>();
        findPath(root,new StringBuilder(),res);
        return res;
    }

    public void findPath(TreeNode root, StringBuilder path,List<String> res){
        if(root==null) return ;
        
        path.append(root.val);
        
        if(root.left==null && root.right==null){
            res.add(new String(path));
            return;
        }else{
            path.append("->");
        }
        findPath(root.left,new StringBuilder(path),res);
        findPath(root.right,new StringBuilder(path),res);
    }
}