package DS.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P11437_최소공통조상 {
    static ArrayList<Integer>[] tree;
    static int[] depth;
    static int[] parent;
    static boolean[] visited;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 노드의 수
        tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < n - 1; i++) {  // A 인접 리스트에 그래프 데이터 저장하기
            int s = sc.nextInt();
            int e = sc.nextInt();
            tree[s].add(e);
            tree[e].add(s);
        }

        depth = new int[n + 1];
        parent = new int[n + 1];
        visited = new boolean[n + 1];
        BFS(1);
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            // 공통 조상을 구할 두 노드
            int a = sc.nextInt();
            int b = sc.nextInt();
            int LCA = excuteLAC(a, b);
            System.out.println(LCA);
        }
    }

    static int excuteLAC(int a, int b) {
        // 두 노드의 깊이를 맞춥니다.
        while (depth[a] != depth[b]) {
            if (depth[a] > depth[b]) {
                a = parent[a];
            } else {
                b = parent[b];
            }
        }

        // 같은 깊이에서 두 노드의 공통 조상을 찾습니다.
        while (a != b) {
            a = parent[a];
            b = parent[b];
        }

        return a;
    }


    // BFS 구현하기
    private static void BFS(int node) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(node);
        visited[node] = true;
        int level = 1;
        int now_size = 1;
        int count = 0;
        while (!queue.isEmpty()) {
            int now_node = queue.poll();
            for (int next : tree[now_node]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                    parent[next] = now_node;
                    depth[next] = level;
                }
            }

            count++;
            if (count == now_size) {
                count = 0;
                now_size = queue.size();
                level++;
            }
        }
    }
}
