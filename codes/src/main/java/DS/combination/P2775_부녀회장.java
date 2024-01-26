package DS.combination;

import java.util.Scanner;

public class P2775_부녀회장 {
    static int t, n, k;
    static int[][] d;

    public static void main(String[] args) throws Exception {
        d = new int[15][15];
        for (int i = 0; i < 15; i++) {
            d[i][1] = 1;
            d[0][i] =i;
        }

        for (int i = 1; i < 15; i++) {
            for (int j = 2; j < 15; j++) {
                d[i][j] = d[i][j - 1] + d[i - 1][j];
            }
        }

        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            k = sc.nextInt();
            n = sc.nextInt();
            System.out.println(d[k][n]);
        }
    }
}
