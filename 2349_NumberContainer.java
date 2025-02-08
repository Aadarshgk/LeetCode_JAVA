import java.util.HashMap;
import java.util.TreeSet;
class NumberContainers {
    HashMap<Integer,TreeSet<Integer>>map;
    HashMap<Integer,Integer> indMap;
    public NumberContainers() {
        map= new HashMap<>();        
        indMap= new HashMap<>();        
    }
    
    public void change(int index, int number) {
        if(indMap.containsKey(index)){
            int n=indMap.get(index);
            map.get(n).remove((Integer)index);
        }
        indMap.put(index,number);
        if(!map.containsKey(number)){
            map.put(number,new TreeSet<>());
        }
        map.get(number).add(index);
    }
    
    public int find(int number) {
        if(!map.containsKey(number) || map.get(number).isEmpty()){
            return -1;
        }else{
            return map.get(number).first();
        }
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */