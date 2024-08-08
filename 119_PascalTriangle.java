class Solution {
    public List<Integer> getRow(int rowIndex) {
        Integer[] row= new Integer[rowIndex+1];
        Arrays.fill(row,0);
        row[0]=1;
        for(int i=1;i<=rowIndex;i++){
            for(int j=i;j>0;j--){
                row[j]=row[j]+row[j-1];
            }
        }

        return Arrays.asList(row);
        
    }
}