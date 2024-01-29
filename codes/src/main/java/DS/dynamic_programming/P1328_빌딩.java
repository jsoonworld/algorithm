package DS.dynamic_programming;

import java.util.Scanner;

public class P1328_빌딩 {
    static long mod = 1_000_000_007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        int r = sc.nextInt();

        long d[][][] = new long[101][101][101];
        d[1][1][1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= l; j++) {
                for (int k = 1; k <= r; k++) {
                    d[i][j][k] = (d[i - 1][j][k] * (i - 2) + (d[i - 1][j][k - 1] + d[i - 1][j - 1][k])) % mod;
                }
            }
        }
        System.out.println(d[n][l][r]);

    }
}
