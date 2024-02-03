package intro.dynamic_programming;

import java.util.Scanner;

public class P2193_이친수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long d[][] = new long[n + 1][2];
        d[1][1] = 1; // 1자리 이친수는 한 가지
        d[1][0] = 0; // 이친수는 0으로 시작하지 않기 때문에 1차리 0으로 끝나는 이친수는 없음

        for (int i = 2; i <= n; i++) {
            d[i][0] = d[i - 1][1] + d[i - 1][0];
            d[i][1] = d[i - 1][0];
        }
        System.out.println(d[n][0] + d[n][1]);
    }
}
