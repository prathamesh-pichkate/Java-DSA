

public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {64, 34, 25, 12, 22};
        int n = array.length;

        for(int i=n-1;i>=0;i--){
            for(int j=0;j<i;j++){
                if(array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }

        for(int i =0;i<array.length;i++){
            System.out.println(array[i]);
        }
    }
    
}
