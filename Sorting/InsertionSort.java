public class InsertionSort{
    public static void sortArr(int arr[]){
        int n = arr.length;

        for(int i=0;i<n;i++){
            int j = i;
            while(j > 0 && arr[j-1] > arr[j]){
                int temp = arr[j-1];
                arr[j-1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }
    }
    public static void main(String[] args) {
        int arr[] = {14,9,6,17,1,2,16,12};
        sortArr(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }
}