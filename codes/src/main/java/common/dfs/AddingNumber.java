package common.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

// 단지 번호 붙이기
// 백준 2667
public class AddingNumber {
    final static int max = 25 + 10;
    static boolean[][] graph;
    static boolean[][] visited;
    static int countPerDanji;
    // 상하좌우 탐색을 위해서
    static int dirY[] = {1, -1, 0, 0};
    static int dirX[] = {0, 0, 1, -1};

    static void dfs(int y, int x) {
        visited[y][x] = true;
        countPerDanji++;

        for (int i = 0; i < 4; i++) {
            int newY = y + dirY[i];
            int newX = x + dirX[i];
            if (!visited[newY][newX] && graph[newY][newX]) {
                dfs(newY, newX);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        graph = new boolean[max][max];
        visited = new boolean[max][max];
        for (int i = 1; i <= n; i++) {
            String s = br.readLine();
            for (int j = 1; j <= n; j++) {
                graph[i][j] = s.charAt(j - 1) == '1';
            }
        }

        // 1. (1,1) 부터 (n, n)까지 돌면 dfs
        ArrayList<Integer> countList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (graph[i][j] && !visited[i][j]) {
                    countPerDanji = 0;
                    dfs(i, j);
                    countList.add(countPerDanji);
                }
            }
        }

        // 2. 출력
        System.out.println(countList.size());
        Collections.sort(countList);
        for (int i = 0; i < countList.size(); i++) {
            System.out.println(countList.get(i));
        }

        br.close();

    }
}
