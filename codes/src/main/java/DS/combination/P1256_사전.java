package DS.combination;

import java.util.Scanner;

public class P1256_사전 {
    static int n, m, k;
    static int[][] d;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        d = new int[202][202];

        for (int i = 0; i <= 200; i++) {
            d[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                d[i][j] = Math.min(d[i - 1][j - 1] + d[i - 1][j], 1000000001);
            }
        }

        if (d[n + m][m] < k) {
            System.out.println("-1");
        } else {
            StringBuilder sb = new StringBuilder();
            while (n + m > 0) {
                if (m == 0 || (n > 0 && d[n + m - 1][m] >= k)) {
                    sb.append("a");
                    n--;
                } else {
                    sb.append("z");
                    k -= n > 0 ? d[n + m - 1][m] : 0;
                    m--;
                }
            }
            System.out.println(sb.toString());
        }
    }
}
