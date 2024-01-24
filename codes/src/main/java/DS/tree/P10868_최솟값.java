package DS.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10868_최솟값 {
    static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int treeHeight = (int) (Math.ceil(Math.log(n) / Math.log(2)));
        int treeSize = (int) Math.pow(2, treeHeight + 1);
        tree = new long[treeSize];

        // 트리 초기화
        for (int i = 0; i < n; i++) {
            tree[treeSize / 2 + i] = Long.parseLong(br.readLine());
        }
        for (int i = n + treeSize / 2; i < treeSize; i++) {
            tree[i] = Long.MAX_VALUE;
        }

        // 세그먼트 트리 생성
        for (int i = treeSize / 2 - 1; i > 0; i--) {
            tree[i] = Math.min(tree[i * 2], tree[i * 2 + 1]);
        }

        // 쿼리 처리
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1 + treeSize / 2;
            int e = Integer.parseInt(st.nextToken()) - 1 + treeSize / 2;
            System.out.println(getMin(s, e));
        }
        br.close();
    }

    private static long getMin(int s, int e) {
        long min = Long.MAX_VALUE;
        while (s <= e) {
            if (s % 2 == 1) min = Math.min(min, tree[s++]);
            if (e % 2 == 0) min = Math.min(min, tree[e--]);
            s /= 2;
            e /= 2;
        }
        return min;
    }
}
