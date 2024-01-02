import java.util.Arrays;

public class DpCoinProblem {
    public static void main(String[] args) {
        /*
        f(n) = min( f(n-a) : for a in coins) + 1
         */
        int[] coins = {1,4,5};

        int amount = 13;
        int[] dp = new int[amount + 1];
        dp[1] = 1;
        for (int i = 2; i <= amount; i++) {
            int min = amount;
            for(int c : coins){
                if(i-c < 0){
                    continue;
                }
                if(min>dp[i-c]){
                    min = dp[i-c];
                }
            }
            dp[i] = min+1;
        }
        System.out.println(Arrays.toString(dp));
    }
}
