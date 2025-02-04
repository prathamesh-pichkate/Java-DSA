public class Fibonacci {
    /// Type 1: Recursion
    public static int fib(int n){
        if(n==0 || n==1){
            return n;
        }
        return fib(n-1) + fib(n-2);
    }

    //Type 2: Memoization
    public static int fibMemo(int n, int[] memo){
        if(n==0 || n==1){
            return n;
        }
        if(memo[n] != 0){
            return memo[n];
        }
        memo[n] = fibMemo(n-1, memo) + fibMemo(n-2, memo);
        return memo[n];
    }

    //Type 3: Tabulation
    public static int fibTab(int n){
        if(n==0 || n==1){
            return n;
        }
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n=5;
        int memo[]=new int[n+1];
    }
}
