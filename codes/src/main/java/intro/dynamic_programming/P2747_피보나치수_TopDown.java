package intro.dynamic_programming;

import java.util.Scanner;

public class P2747_피보나치수_TopDown {
    static int[] d;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        d = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            d[i] = -1;
        }

        d[0] = 0;
        d[1] = 1;
        fibo(n);
        System.out.println(d[n]);
    }

    static int fibo(int n) {
        if (d[n] != -1) {
            return d[n];
        }
        return d[n] = fibo(n - 2) + fibo(n - 1);
    }
}
