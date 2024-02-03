package intro.dynamic_programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2098_외판원순회 {
    private static final int INF = 1000000 * 16 + 1;
    private static int n;
    private static int[][] w;
    private static int[][] d;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());
        w = new int[16][16];
        d = new int[16][1 << 16];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            for (int j = 0; j < n; j++) {
                w[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(tsp(0, 1));
    }

    private static int tsp(int c, int v) {
        if (v == (1 << n) - 1) {
            return w[c][0] == 0 ? INF : w[c][0];
        }
        if (d[c][v] != 0) {
            return d[c][v];
        }
        int min_val = INF;
        for (int i = 0; i < n; i++) {
            if ((v & (1 << i)) == 0 && w[c][i] != 0) {
                min_val = Math.min(min_val, tsp(i, (v | (1 << i))) + w[c][i]);
            }
        }
        d[c][v] = min_val;
        return d[c][v];
    }
}
