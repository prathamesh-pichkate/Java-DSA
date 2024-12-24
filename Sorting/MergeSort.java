public class MergeSort {
    public static void merge(int arr[],int low,int high){
        if(low >= high){
            return;
        }
        int mid = low+(high-low)/2;
        merge(arr,low,mid); //left recursion
        merge(arr,mid+1,high); //right recursion
        mergeSo(arr,low,mid,high);
    }

    public static void mergeSo(int arr[],int low,int mid,int high){
        int leftPoi = low;
        int rightPoi = mid+1;
        int temp[] = new int[high-low+1];
        int k=0;

        while(leftPoi <= mid && rightPoi <= high){
            if(arr[leftPoi] < arr[rightPoi]){
                temp[k++] = arr[leftPoi++];
            }else{
                temp[k++] = arr[rightPoi++];
            }
        }
        while(leftPoi <= mid){
            temp[k++] = arr[leftPoi++];
        }
        while(rightPoi <= high){
            temp[k++] = arr[rightPoi++];
        }
        for(int i=low;i<=high;i++){
            arr[i] = temp[i-low];
        }
    }
    public static void main(String[] args) {
        int[] arr = {5, 2, 8, 1, 9};
        merge(arr,0,arr.length-1);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
