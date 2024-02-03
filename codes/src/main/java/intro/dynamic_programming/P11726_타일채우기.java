package intro.dynamic_programming;

import java.util.Scanner;

public class P11726_타일채우기 {
    static long mod = 10007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long d[] = new long[1001];
        d[1] = 1;
        d[2] = 2;
        for (int i = 3; i <= n; i++) {
            d[i] = (d[i - 1] + d[i - 2]) % mod;
        }
        System.out.println(d[n]);

    }
}
