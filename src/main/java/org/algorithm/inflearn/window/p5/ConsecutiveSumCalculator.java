package org.algorithm.inflearn.window.p5;

import java.util.Scanner;

public class ConsecutiveSumCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int count = findConsecutiveSums(n);
        System.out.println(count);
    }

    public static int findConsecutiveSums(int n) {
        int count = 0;
        int start = 1;
        int end = 1;
        int sum = 1;

        while (start <= n / 2) {
            if (sum == n) {
                count++;
                sum -= start;
                start++;
            } else if (sum < n) {
                end++;
                sum += end;
            } else {
                sum -= start;
                start++;
            }
        }
        return count;
    }
}
