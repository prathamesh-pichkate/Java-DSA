public class BTonArray{

    public static void btOnArr(int arr[],int i,int value){
        if(i==arr.length){
           printArr(arr);
           return;
        }

        arr[i] = value;
        btOnArr(arr, i+1, value+1);
        arr[i] = arr[i]-2;  /// backtracking step
    }

    public static void printArr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = new int[5];
        btOnArr(arr, 0, 1);
        printArr(arr);
    }
}