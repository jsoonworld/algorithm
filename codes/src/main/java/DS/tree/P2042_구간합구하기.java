package DS.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2042_구간합구하기 {
    static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 수의 개수
        int m = Integer.parseInt(st.nextToken()); // 변경이 일어나는 횟수
        int k = Integer.parseInt(st.nextToken()); // 구간 합을 구하는 횟수

        int treeHeight = (int) (Math.ceil(Math.log(n) / Math.log(2)));
        int treeSize = (int) Math.pow(2, treeHeight + 1);
        tree = new long[treeSize];

        // 데이터를 리프 노드에 입력 받기
        for (int i = 0; i < n; i++) {
            tree[treeSize / 2 + i] = Long.parseLong(br.readLine());
        }

        // 세그먼트 트리 생성
        for (int i = treeSize / 2 - 1; i > 0; i--) {
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }

        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) { // update
                int index = treeSize / 2 + b - 1;
                changeVal(index, c);
            } else if (a == 2) { // sum
                int left = treeSize / 2 + b - 1;
                int right = treeSize / 2 + (int) c - 1;
                System.out.println(getSum(left, right));
            }
        }
        br.close();
    }

    private static long getSum(int s, int e) { // 구간 합을 구하는 함수
        long partSum = 0;
        while (s <= e) {
            if (s % 2 == 1) {
                partSum += tree[s++];
            }
            if (e % 2 == 0) {
                partSum += tree[e--];
            }
            s /= 2;
            e /= 2;
        }
        return partSum;
    }

    private static void changeVal(int index, long val) { // 값을 변경하는 함수
        long diff = val - tree[index];
        while (index > 0) {
            tree[index] += diff;
            index /= 2;
        }
    }
}
