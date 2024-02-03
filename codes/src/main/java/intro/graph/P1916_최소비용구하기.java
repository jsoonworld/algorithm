package intro.graph;


import java.util.*;
import java.io.*;

public class P1916_최소비용구하기{

    static int n, m;
    static ArrayList<Node>[] list; //인접 리스트 그래프
    static int[] dist; // 최단 거리 배열
    static boolean[] visit;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        list = new ArrayList[n+1];
        dist = new int[n+1];
        visit = new boolean[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE); // 거리 배열을 충분히 큰 수로 초기화.

        for(int i = 1; i <= n; i++){
            list[i] = new ArrayList<Node>(); // 각 인덱스에 ArrayList<Node> 객체 생성
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[start].add(new Node(end, weight));
        }
        st = new StringTokenizer(br.readLine());
        int startIndex = Integer.parseInt(st.nextToken());
        int endIndex = Integer.parseInt(st.nextToken());
        bw.write(dijkstra(startIndex, endIndex) + " \n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int dijkstra(int start, int end){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;
        while(!pq.isEmpty()){
            Node nowNode = pq.poll();
            int now = nowNode.targetNode;
            if(!visit[now]){
                visit[now] = true;
                for(Node n : list[now]){
                    if(!visit[n.targetNode] && dist[n.targetNode] > dist[now] + n.value){
                        dist[n.targetNode] = dist[now] + n.value;
                        pq.add(new Node(n.targetNode, dist[n.targetNode]));
                    }
                }
            }
        }
        return dist[end];
    }
}

class Node implements Comparable<Node>{
    int targetNode;
    int value;
    Node(int targetNode, int value) {
        this.targetNode = targetNode;
        this.value = value;
    }
    @Override
    public int compareTo(Node o) {
        return value -o.value;
    }
}