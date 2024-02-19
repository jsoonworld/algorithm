package common.dfs;

import java.util.Scanner;

public class Virus {
    static boolean[][] graph;
    static boolean[] visited;
    static int n, m;
    static int answer;

    public static void dfs(int index) {
        answer++;
        visited[index] = true;
        for (int i = 1; i <= n; i++) {
            if (!visited[i] && graph[index][i]) {
                dfs(i); 
            }
        }
    }

    public static void main(String[] args) {
        // 입력 및 초기화
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        graph = new boolean[n + 1][n + 1];
        visited = new boolean[n + 1];

        // 1. 그래프 정보 입력
        int x, y;
        for (int i = 0; i < m; i++) {
            x = sc.nextInt();
            y = sc.nextInt();
            graph[x][y] = graph[y][x] = true;
        }

        // 2. dfs 결과 및 출력
        dfs(1);

        System.out.println(answer - 1);
        sc.close();

    }
}
