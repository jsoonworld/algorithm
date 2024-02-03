package intro.dynamic_programming;

import java.io.*;
import java.util.StringTokenizer;

public class P13398_연속합2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int[] l = new int[n];
        l[0] = a[0];
        int result = l[0];
        for (int i = 1; i < n; i++) {
            l[i] = Math.max(a[i], l[i - 1] + a[i]);
            result = Math.max(result, l[i]);
        }

        int[] r = new int[n];
        r[n - 1] = a[n - 1];
        for (int i = n - 2; i > 0; i--) {
            r[i] = Math.max(a[i], r[i + 1] + a[i]);
        }

        for (int i = 1; i < n - 1; i++) {
            int temp = l[i - 1] + r[i + 1];
            result = Math.max(result, temp);
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
