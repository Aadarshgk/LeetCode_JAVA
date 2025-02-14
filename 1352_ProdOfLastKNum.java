import java.util.List;
import java.util.ArrayList;
class ProductOfNumbers {
    List<Integer> list;
    int prod;
    public ProductOfNumbers() {
        list=new ArrayList<>();
        prod=1;
    }
    
    public void add(int num) {
        if(num==0){
            list.clear();
            prod=1;
        }else{
            prod*=num;
            list.add(prod);
        }
    }
    
    public int getProduct(int k) {
        int len=list.size();
        if(k==len) return prod;
        if(len<k) return 0;

        int prev= (len-k-1 >=0)?list.get(len-k-1):1;
        return prod/prev;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */