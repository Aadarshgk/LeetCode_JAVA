/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    List<Integer> res=null;
    int count=0;
    public NestedIterator(List<NestedInteger> nestedList) {
        res=new ArrayList<>();
        for(NestedInteger integer: nestedList){
            flattenList(integer);
        }
    }

    @Override
    public Integer next() {
        return  res.get(count++);
    }

    @Override
    public boolean hasNext() {
        return count<res.size();
    }

    public void flattenList(NestedInteger list){
        if(list.isInteger()){
            res.add(list.getInteger());
        }else{
            for(NestedInteger num: list.getList()){
                flattenList(num);
            }
        }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */