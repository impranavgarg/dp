import java.util.Arrays;

public class climbingStairs {

    // using recursion with complexity -> O(2^n)
    private static int countWays(int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }

        return countWays(n - 1) + countWays(n - 2);

    }

    // using memoziation with linear time complexity - O(n)
    private static int countWaysOptimize(int n, int[] ways) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        if (ways[n] != -1) {
            return ways[n];
        }

        ways[n] = countWaysOptimize(n - 1, ways) + countWaysOptimize(n - 2, ways);

        return ways[n];

    }

    // using tabulation
    private static int countWaysTabulation(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];

        }

        return dp[n];

    }

    public static void main(String[] args) {
        int n = 5;
        int[] ways = new int[n + 1]; // 0 0 0 0 0
        Arrays.fill(ways, -1);// -1 -1 -1 -1 -1
        System.out.println(countWays(n));
        System.out.println(countWaysTabulation(n));
        System.out.println(countWaysOptimize(n, ways));

    }

}
