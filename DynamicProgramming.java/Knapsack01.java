public class Knapsack01 {

    // 0-1 Knapsack Problem: Reccursion
    public static int knapSack(int W, int wt[], int val[], int n) {
        if(W == 0 || n == 0){
            return 0;
        }
        if(wt[n-1] <= W){
            return Math.max(val[n-1] + knapSack(W-wt[n-1], wt, val, n-1), knapSack(W, wt, val, n-1));
        }else{
            return knapSack(W, wt, val, n-1);
        }
    }


    //Memoization
    public static int knapSack(int W, int wt[], int val[], int n, int[][] dp) {
        if(W == 0 || n == 0){
            return 0;
        }

        if(dp[n][W] != -1){
            return dp[n][W];
        }

        if(wt[n-1] <= W){
            dp[n][W] = Math.max(val[n-1] + knapSack(W-wt[n-1], wt, val, n-1, dp), knapSack(W, wt, val, n-1, dp));
            return dp[n][W];
        }else{
            dp[n][W] = knapSack(W, wt, val, n-1, dp);
            return dp[n][W];
        }
    }

    //tabulation
    public static int knapSackt(int W, int wt[], int val[], int n){
        int[][] dp = new int[n+1][W+1];

        for(int i=0;i<n+1;i++){
            dp[i][0] = 0;
        }

        for(int i=1;i<W+1;i++){
            dp[0][i] = 0;
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<W+1;j++){
                int v = val[i-1];
                int w = wt[i-1];

                if(w <= j){
                    int incValue = v + dp[i-1][j-w];
                    int excValue = dp[i-1][j];
                    dp[i][j] = Math.max(incValue, excValue);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][W];
    }

    public static void main(String[] args) {
        int[] weights = {2, 5, 1, 3,4};
        int[] values = {15, 14, 10, 45,30};
        int  w = 7;
        int n = weights.length;

        //Reccursion
        System.out.println(knapSack(w, weights, values, n));

        //Memoization
        int dp[][] = new int[n+1][w+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<w+1;j++){
                dp[i][j] = -1;
            }
        }
        System.out.println(knapSack(w, weights, values, n, dp));


        //Tabulation
        System.out.println(knapSackt(w, weights, values, n));

    }
}
