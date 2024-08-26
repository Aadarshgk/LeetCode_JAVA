import java.util.List;
import java.util.ArrayList;
class Solution {
    List<Integer> res= new ArrayList<>();
    public List<Integer> postorder(Node root) {
        if(root!=null){
            if(root.children.size()!=0){
                for(Node n: root.children){
                    postorder(n);
                }
            }
            res.add(root.val);
        }
        return res;
    }
}
