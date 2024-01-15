package DS.search;


import java.util.*;

public class P1167_트리의지름{

    static boolean visited[];
    static int[] distance;
    static ArrayList<Edge>[] A;

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 노드 개수
        A = new ArrayList[n+1];

        for(int i = 1; i <= n; i++){
            A[i] = new ArrayList<Edge>();
        }

        for(int i = 0; i <n; i++){ // A 인접리스트에 그래프 데이터 저장하기
            int s= sc.nextInt();
            while(true){
                int e = sc.nextInt();
                if(e == -1){
                    break;
                }
                int v = sc.nextInt();
                A[s].add(new Edge(e, v));
            }
        }

        distance = new int[n+1];
        visited = new boolean[n+1];
        BFS(1);
        int max = 1;
        for(int i =2; i<=n; i++){
            if(distance[max] > distance[i]){
                max = i;
            }
        }

        distance = new int[n+1];
        visited = new boolean[n+1];
        BFS(max);
        Arrays.sort(distance);
        System.out.println(distance[n]);
    }

    private static void BFS(int index){ // BFS 구현하기

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(index);
        visited[index] = true;
        while(!queue.isEmpty()){

            int now_node = queue.poll();
            for(Edge i : A[now_node]){

                int e = i.e;
                int v = i.value;
                if(!visited[e]){
                    visited[e] =true;
                    queue.add(e);
                    distance[e] = distance[now_node] + v; // 거리 배열 업데이트하기
                }
            }
        }
    }
}
class Edge{

    int e;
    int value;

    public Edge(int e, int value){
        this.e = e;
        this.value = value;
    }
}


