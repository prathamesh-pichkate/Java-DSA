class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int right[] = new int[n];
        int left[] = new int[n];


        Stack<Integer> s = new Stack<>();

        //Next right smallest
        for(int i=n-1;i>=0;i--){
            while(!s.isEmpty() && heights[s.peek()] >= heights[i]){
                s.pop();
            }

            if(s.isEmpty()){
                right[i] = n;
            }else{
                right[i] = s.peek();
            }
            s.push(i);
        }

        s.clear();

        
        //Next left smallest
        for(int i=0;i<n;i++){
            while(!s.isEmpty() && heights[s.peek()] >= heights[i]){
                s.pop();
            }

            if(s.isEmpty()){
                left[i] = -1;
            }else{
                left[i] = s.peek();
            }
            s.push(i);
        }

         int maxVal = 0;
         for(int i=0;i<n;i++){
            int width = right[i]-left[i] -1;
            int area = width * heights[i];
             maxVal = Math.max(maxVal,area);
         }
          
          return maxVal;

    }
}