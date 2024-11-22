import java.util.Scanner;

public class DiceCombinations{
    public static void main(String[] args) {
        // Modulus értéke
        final int MOD = 1000000007;

        // Input olvasása
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // DP tömb inicializálása
        int[] dp = new int[n + 1];
        dp[0] = 1; // 0 összeg elérésének egyetlen módja

        // Dinamikus programozás töltése
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 6; j++) {
                if (i - j >= 0) {
                    dp[i] = (dp[i] + dp[i - j]) % MOD;
                }
            }
        }

        // Eredmény kiírása
        System.out.println(dp[n]);
    }
}