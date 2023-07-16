class knapSack_01 {

    // O(2^W)
    private static int knapSack(int val[], int wt[], int W, int n) {

        if (W == 0 || n == 0) {
            return 0;
        }
        if (wt[n - 1] <= W) {
            // include
            int ans1 = val[n - 1] + knapSack(val, wt, W - wt[n - 1], n - 1);
            // exclude
            int ans2 = knapSack(val, wt, W, n - 1);
            return Math.max(ans2, ans1);
        } else {
            return knapSack(val, wt, W, n - 1);
        }
    }

    // O(n*W) ---> usning Memoization
    private static int knapSackMemoization(int val[], int wt[], int W, int n, int[][] dp) {

        if (W == 0 || n == 0) {
            return 0;
        }
        if (dp[n][W] != -1) {
            return dp[n][W];
        }

        if (wt[n - 1] <= W) {
            // include
            int ans1 = val[n - 1] + knapSackMemoization(val, wt, W - wt[n - 1], n - 1, dp);
            // exclude
            int ans2 = knapSackMemoization(val, wt, W, n - 1, dp);
            dp[n][W] = Math.max(ans2, ans1);
            return dp[n][W];
        } else {
            dp[n][W] = knapSackMemoization(val, wt, W, n - 1, dp);
            return dp[n][W];
        }
    }

    // using Tabulation --> O(n*w)
    private static int knapSackTabulation(int[] val, int[] wt, int w) {
        int[][] dp = new int[val.length + 1][w + 1];
        int n =val.length;
        for (int i = 0; i < dp.length; i++) {
            dp[i][0]=0;

        }
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j]=0;

        }
        for(int i =1;i<n+1;i++){
            for (int j = 1; j < w+1; j++) {
                int value = val[i-1]; // ith item value
                int weight = wt[i-1]; // ith item weight
                if(weight<=j){ // valid
                    int incProfit = value+ dp[i-1][j-weight];
                    int excProfit = dp[i-1][j];
                    dp[i][j] = Math.max(incProfit, excProfit);
                }else{
                    int excProfit = dp[i-1][j];
                    dp[i][j] = excProfit;
                }
                
            }
        }
        return dp[n][w];

    }

    public static void main(String[] args) {
        int[] val = { 15, 14, 10, 45, 30 };
        int wt[] = { 2, 5, 1, 3, 4 };
        int W = 7;
        int[][] dp = new int[val.length + 1][W + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;

            }

        }

        System.out.println(knapSackTabulation(val, wt, W));

        System.out.println(knapSack(val, wt, W, val.length));
        System.out.println(knapSackMemoization(val, wt, W, val.length, dp));

    }
}