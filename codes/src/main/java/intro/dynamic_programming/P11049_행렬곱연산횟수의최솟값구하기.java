package intro.dynamic_programming;

import java.io.IOException;
import java.util.Scanner;

public class P11049_행렬곱연산횟수의최솟값구하기 {
    static int n;
    static matrix[] m;
    static int[][] d;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = new matrix[n + 1];
        d = new int[n + 1][n + 1];
        for (int i = 0; i < d.length; i++) {
            for (int j = 0; j < d[i].length; j++) {
                d[i][j] = -1;
            }
        }
        for (int i = 1; i <= n; i++) {
            int y = sc.nextInt();
            int x = sc.nextInt();
            m[i] = new matrix(y, x);
        }
        System.out.println(excute(1, n));
    }

    static int excute(int s, int e) {
        if (d[s][e] != -1) {
            return d[s][e];
        }
        if (s == e) {
            return 0;
        }
        int result = Integer.MAX_VALUE;
        for (int i = s; i < e; i++) {
            int cost = m[s].y * m[i].x * m[e].x + excute(s, i) + excute(i + 1, e);
            result = Math.min(result, cost);
        }
        d[s][e] = result;
        return result;
    }


    static class matrix{
        private int y;
        private int x;

        matrix(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
