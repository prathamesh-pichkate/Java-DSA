public class FindPeakElement {
    public static int findPeak(int arr[]){ ///TC: O(log n)
        int n = arr.length;
        int left = 0;
        int right = n - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static int findPeak2(int arr[]){
        int n = arr.length;
        int peakIdx = 0;
        for(int i = 1; i < n - 1; i++){
             if(arr[i]>arr[peakIdx]){
                 peakIdx = i;
                 return i;
             }
        }
        return 0;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,1,3,5,6,4};
        // System.out.println(findPeak(arr));
        System.out.println(findPeak2(arr));
    }
}
