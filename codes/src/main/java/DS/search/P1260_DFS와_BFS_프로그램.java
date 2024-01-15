package DS.search;

import java.util.*;

public class P1260_DFS와_BFS_프로그램{

    static boolean visited[];
    static ArrayList<Integer>[] A;

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //노드 개수
        int m = sc.nextInt(); // 엣지 개수
        int start = sc.nextInt(); //시작점

        A = new ArrayList[n+1];
        for(int i = 1; i <=n; i++){
            A[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < m; i++){
            int s = sc.nextInt();
            int e = sc.nextInt();

            A[s].add(e);
            A[e].add(s);
        }

        // 번호가 작은 것을 먼저 방문하기 위해 정렬하기
        for(int i = 1; i <=n; i++){
            Collections.sort(A[i]);
        }

        visited = new boolean[n+1]; // 방문 배열 초기화하기.
        DFS(start);
        System.out.println();

        visited = new boolean[n+1]; // 방문 배열 초기화하기
        BFS(start);
        System.out.println();
    }

    public static void DFS(int node){ // DFS 구현하기

        System.out.print(node + " ");
        visited[node] = true;

        for(int i : A[node]){
            if(!visited[i]){
                DFS(i);
            }
        }
    }

    private static void BFS(int node){ // BFS 구현하기

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(node);
        visited[node] = true;

        while( !queue.isEmpty()){

            int now_node = queue.poll();
            System.out.print(now_node + " ");

            for(int i : A[now_node]){
                if(!visited[i]){
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

}
