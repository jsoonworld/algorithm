package org.algorithm.inflearn.map.p3;

import java.util.*;

public class SalesTypeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        List<Integer> result = findSalesDiversity(arr, n, k);
        for (int count : result) {
            System.out.print(count + " ");
        }
    }

    public static List<Integer> findSalesDiversity(int[] arr, int n, int k) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;

        for (int i = 0; i < k; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        result.add(map.size());

        for (int right = k; right < n; right++) {
            int outgoing = arr[left];
            map.put(outgoing, map.get(outgoing) - 1);
            if (map.get(outgoing) == 0) {
                map.remove(outgoing);
            }
            left++;

            int incoming = arr[right];
            map.put(incoming, map.getOrDefault(incoming, 0) + 1);

            result.add(map.size());
        }

        return result;
    }
}
