package intro.tree;

import java.util.ArrayList;
import java.util.Scanner;

public class P1068_리프노드 {
    static ArrayList<Integer>[] tree;
    static boolean[] visited;
    static int answer = 0;
    static int deleteNode = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        tree = new ArrayList[n];
        visited = new boolean[n];
        int root = 0;

        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<Integer>();
        }


        for (int i = 0; i < n; i++) {
            int p = sc.nextInt();
            if (p != -1) {
                tree[i].add(p);
                tree[p].add(i);
            } else {
                root = i;
            }
        }
        deleteNode = sc.nextInt();
        if (deleteNode == root) {
            System.out.println(0);
        } else {
            DFS(root);
            System.out.println(answer);
        }
    }

    static void DFS(int number) {
        visited[number] = true;
        int cNode = 0;
        for (int i : tree[number]) {
            if (visited[i] == false && i != deleteNode) {
                cNode++;
                DFS(i);
            }
        }
        if (cNode == 0) {
            answer++;
        }
    }
}
