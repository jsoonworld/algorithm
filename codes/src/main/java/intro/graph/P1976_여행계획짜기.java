package intro.graph;


import java.util.*;

public class P1976_여행계획짜기{

    public static int[] parent;

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] city = new int[n+1][n+1];
        for(int i = 1; i <=n; i++){
            for(int j = 1; j <= n; j++){
                city[i][j] = sc.nextInt();
            }
        }

        int[] route = new int[m+1];
        for(int i = 1; i <=m; i++){
            route[i] = sc.nextInt();
        }

        parent = new int[n+1];
        for(int i = 1; i <= n; i++){
            parent[i] = i;
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <=n; j++){
                if(city[i][j] == 1) union(i, j);
            }
        }

        int index = find(route[1]);
        for(int i = 2; i < route.length; i++){
            if(index != find(route[i])){
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }

    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        if( a != b){
            parent[b] = a;
        }
    }

    public static int find(int a){
        if(a == parent[a])
            return a;
        else
            return parent[a] = find(parent[a]);
    }
}