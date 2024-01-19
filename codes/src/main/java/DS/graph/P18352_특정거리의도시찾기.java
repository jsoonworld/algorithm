package DS.graph;


import java.util.*;

public class P18352_특정거리의도시찾기{

    static int visited[];
    static ArrayList<Integer>[] A;
    static int n, m, k, x;
    static List<Integer> answer;

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 노드의 수
        m = sc.nextInt(); // 엣지의 수
        k = sc.nextInt(); // 목표 거리
        x = sc.nextInt(); // 시작점
        A = new ArrayList[n + 1];
        answer = new ArrayList<Integer>();

        for(int i = 1; i <= n; i++){
            A[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < m; i++){
            int s = sc.nextInt();
            int e = sc.nextInt();
            A[s].add(e);
        }

        visited = new int[ n + 1]; // 방문 배열 초기화 하기
        for(int i = 0; i <=n; i++){
            visited[i] = -1;
        }

        BFS(x);
        for(int i = 0; i <=n; i++){
            if(visited[i] == k){
                answer.add(i);
            }
        }

        if(answer.isEmpty()){
            System.out.println("-1");
        } else{
            Collections.sort(answer);
            for(int temp : answer){
                System.out.println(temp);
            }
        }
    }

    // BFS 구현하기
    private static void BFS(int node){

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(node);
        visited[node]++;
        while(!queue.isEmpty()){
            int now_node = queue.poll();
            for(int i : A[now_node]){
                if(visited[i] == -1){
                    visited[i] = visited[now_node] + 1;
                    queue.add(i);
                }
            }
        }

    }
}
