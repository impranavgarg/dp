/**
 * fibonacciRecursive
 */
public class fibonacciRecursive {

    public static void main(String[] args) {
        int n = 6;
        int f[] = new int[n+1];
        System.out.println(fib(n));
        System.out.println(fibTabulation(n));
        System.out.println(fibOptimised(n,f));

        
    }

    private static int fib(int n) { // o(2^n)
        if(n==0 || n==1){
            return n;
        }

        return fib(n-1) +fib(n-2);
    }

    // more optimized by using dynaming programming
    private static int fibOptimised(int n,int f[]) { // o(n)
        if(n==0 || n==1){
            return n;
        }
        if(f[n]!=0){
            return f[n];
        }
        f[n] = fibOptimised(n-1,f) +fibOptimised(n-2,f);

        return f[n];
    }

    private static int fibTabulation(int  n){ // O(n)
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <=n; i++) {
            dp[i] = dp[i-2]+dp[i-1];
            
        }
        return dp[n];
    }

    
}