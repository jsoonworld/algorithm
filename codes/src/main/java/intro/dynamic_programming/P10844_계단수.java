package intro.dynamic_programming;

import java.util.Scanner;

public class P10844_계단수 {
    static long mod = 1_000_000_000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long d[][] = new long[n + 1][11];
        for (int i = 1; i <= 9; i++) {
            d[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            d[i][0] = d[i - 1][1];
            d[i][9] = d[i - 1][8];
            for (int j = 1; j <= 8; j++) {
                d[i][j] = (d[i - 1][j - 1] + d[i - 1][j + 1]) % mod;
            }
        }

        long sum = 0;
        for (int i = 0; i < 10; i++) {
            sum = (sum + d[n][i]) % mod;
        }
        System.out.println(sum);

    }
}
