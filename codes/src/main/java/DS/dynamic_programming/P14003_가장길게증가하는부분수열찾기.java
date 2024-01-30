package DS.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14003_가장길게증가하는부분수열찾기 {
    static int n, maxLength;
    static int[] a = new int[1000001];
    static int[] b = new int[1000001];
    static int[] d = new int[1000001];
    static int[] ans = new int[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        int index;
        b[++maxLength] = a[1];
        d[1] = 1;

        for (int i = 2; i <= n; i++) {
            if (b[maxLength] < a[i]) {
                b[++maxLength] = a[i];
                d[i] = maxLength;
            } else {
                index = binarySearch(1, maxLength, a[i]);
                b[index] = a[i];
                d[i] = index;
            }
        }

        System.out.println(maxLength);
        index = maxLength;
        int x = b[maxLength] + 1;
        for (int i = n; i >= 1; i--) {
            if (d[i] == index && a[i] < x) {
                ans[index] = a[i];
                x = a[i];
                index--;
            }
        }

        for (int i = 1; i <= maxLength; i++) {
            System.out.print(ans[i] + " ");
        }
    }

    static int binarySearch(int l, int r, int now) {
        int mid;
        while (l < r) {
            mid = (l + r) / 2;
            if (b[mid] < now) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;  // 이동: 반복문 밖으로 이동하여 항상 값을 반환하도록 함
    }
}
