import java.util.HashSet;
class FindElements {
    HashSet<Integer> set;
    public FindElements(TreeNode root) {
        set=new HashSet<>();
        set.add(0);
        if(root.left!=null){
            addNodes(root.left,1);
            set.add(1);
        }
        if(root.right!=null){
            addNodes(root.right,2);
            set.add(2);
        }
    }

    public void addNodes(TreeNode root,int val){
        if(root.left!=null){
            int left=val*2+1;
            addNodes(root.left,left);
            set.add(left);
        }
        if(root.right!=null){
            int right=val*2+2;
            addNodes(root.right,right);
            set.add(right);
        }
    }
    
    public boolean find(int target) {
        return set.contains(target);
    }
}