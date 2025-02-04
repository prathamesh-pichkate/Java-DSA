
//Related to next greater element
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int span[] = new int[temperatures.length];
        Stack<Integer> s = new Stack<>();
        int n = temperatures.length;

        for(int i = n-1;i>=0;i--){
            while(!s.isEmpty() && temperatures[s.peek()] <= temperatures[i]){
                s.pop();
            }

            if(s.isEmpty()){
                span[i] = 0;
            }else{
                span[i] = s.peek() - i;
            }
            s.push(i);
        }
        return span;
    }
}