package intro.graph;
import java.io.*;
import java.util.*;


public class P1753_최단경로구하기{

    public static int v, e, k;
    public static int distance[];
    public static boolean visited[];
    public static ArrayList<Edge> list[];
    public static PriorityQueue<Edge> q = new PriorityQueue<Edge>();

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());

        distance = new int[v+1];
        visited = new boolean[v+1];
        list = new ArrayList[v+1];

        for(int i = 1; i <= v; i++){
            list[i] = new ArrayList<Edge>();
        }

        for(int i = 0; i <= v; i++){
            distance[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < e; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[u].add(new Edge(v,w));
        }

        q.add(new Edge(k, 0));
        distance[k] = 0;
        while(!q.isEmpty()){

            Edge current = q.poll();
            int c_v = current.vertex;
            if(visited[c_v]) continue;
            visited[c_v] = true;

            for(int i = 0; i < list[c_v].size(); i++){
                Edge temp = list[c_v].get(i);
                int next = temp.vertex;
                int value = temp.value;
                if(distance[next] > distance[c_v] + value){
                    distance[next] = value + distance[c_v];
                    q.add(new Edge(next, distance[next]));
                }
            }
        }

        for(int i = 1; i <= v; i++){
            if(visited[i])
                System.out.println(distance[i]);
            else
                System.out.println("INF");
        }
    }
}

class Edge implements Comparable<Edge>{
    int vertex, value;
    Edge(int vertex, int value){
        this.vertex = vertex;
        this.value = value;
    }

    public int compareTo(Edge e){
        if(this.value > e.value) return 1;
        else return -1;
    }
}