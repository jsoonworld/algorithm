package intro.graph;

import java.util.*;

public class P1717_집합표현하기{

    public static int[] parent;

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        parent = new int[n+1];

        for(int i = 0; i <=n; i++){
            parent[i] = i;
        }

        for(int i = 0; i < m; i++){
            int question = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            if(question == 0){
                union(a, b);
            } else{
                if(checkSame(a, b)){
                    System.out.println("YES");
                } else{
                    System.out.println("NO");
                }
            }
        }
    }

    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a != b){
            parent[b] = a;
        }
    }

    public static int find(int a){
        if(a == parent[a])
            return a;
        else
            return parent[a] = find(parent[a]);
    }

    public static boolean checkSame(int a, int b){
        a = find(a);
        b = find(b);
        if(a == b){
            return true;
        }
        return false;
    }
}
