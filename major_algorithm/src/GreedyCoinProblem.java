public class GreedyCoinProblem {
    public static void main(String[] args) {
        int[] coins = {1,5,10,25};
        int amount = 99;
        for(int i = coins.length-1 ; i>=0; i--){
            System.out.println( coins[i]+"원 : " + amount/coins[i]+"개");
            amount = amount%coins[i];
        }
    }
}
