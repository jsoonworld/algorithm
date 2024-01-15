package DS.search;

import java.util.*;

public class P13023_친구관계파악하기{

    static boolean visited[];
    static ArrayList<Integer>[] A;
    static boolean arrive;

    public static void main(String[] args) {

        int n;
        int m;
        arrive = false;

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        A = new ArrayList[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            A[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < m; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            A[s].add(e);
            A[e].add(s);
        }

        for (int i = 0; i < n; i++) {
            DFS(i, 1);
            if (arrive)
                break;
        }
        if (arrive) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }
        public static void DFS(int now, int depth){
            if (depth == 5 || arrive) {
                arrive = true;
                return;
            }
            visited[now] = true;
            for (int i : A[now]) {
                if (!visited[i]) {
                    DFS(i, depth + 1);
                }
            }
            visited[now] = false;
        }
    }

