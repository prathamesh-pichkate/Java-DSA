class Solution {
    public void findSubset(int idx,int sum,int arr[], ArrayList<Integer> result,int n){
        if(idx == n){
            result.add(sum);
            return;
        }
        
        //pick
        findSubset(idx+1,sum + arr[idx] ,arr,result,n);
        
        //not pick
        findSubset(idx+1,sum,arr,result,n);
    } 
    
    public ArrayList<Integer> subsetSums(int[] arr) {
        // code here
        int n = arr.length;
        
        ArrayList<Integer> result = new ArrayList<>();
        findSubset(0,0,arr,result,n);
        Collections.sort(result);
        return result;
    }
}