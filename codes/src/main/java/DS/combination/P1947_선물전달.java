package DS.combination;

import java.util.Scanner;

public class P1947_선물전달 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long mod = 1000000000;

        if (n == 1) {
            System.out.println(0);
            return;
        } else if (n == 2) {
            System.out.println(1);
            return;
        }

        long d[] = new long[n + 1];
        d[1] = 0;
        d[2] = 1;

        for (int i = 3; i <= n; i++) {
            d[i] = (i - 1) * ((d[i - 1] + d[i - 2]) % mod);
            d[i] %= mod;
        }
        System.out.println(d[n]);
    }
}
