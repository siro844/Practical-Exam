import java.util.Arrays;

public class CoinChange {
    public static void coinChangeGreedy(int[] coins, int amount) {
        Arrays.sort(coins);
        int n = coins.length;
        int count = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (coins[i] <= amount) {
                int numCoins = amount / coins[i];
                count += numCoins;
                amount -= numCoins * coins[i];
            }
        }

        if (amount == 0) {
            System.out.println("Minimum number of coins required: " + count);
        } else {
            System.out.println("Cannot make exact change.");
        }
    }

    public static void main(String[] args) {
        int[] coins = {1, 5, 10, 25};
        int amount = 30;
        coinChangeGreedy(coins, amount);
    }
}