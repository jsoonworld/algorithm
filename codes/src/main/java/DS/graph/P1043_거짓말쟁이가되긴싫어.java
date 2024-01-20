package DS.graph;


import java.util.*;

public class P1043_거짓말쟁이가되긴싫어{

    public static int[] parent;
    public static int[] trueP;
    public static ArrayList<Integer>[] party;
    public static int result;

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int t = sc.nextInt();
        result = 0;

        trueP = new int[t];
        for(int i = 0; i < t; i++){
            trueP[i] = sc.nextInt();
        }

        party = new ArrayList[m];
        for(int i = 0; i < m; i++){

            party[i] = new ArrayList<>();
            int party_size = sc.nextInt();

            for(int j = 0; j< party_size; j++){
                party[i].add(sc.nextInt());
            }
        }

        parent = new int[n +1];
        for(int i = 0; i <=n; i++){
            parent[i] = i;
        }

        for(int i = 0; i < m; i++){
            int firstPeople = party[i].get(0);
            for(int j = 1; j < party[i].size(); j++){
                union(firstPeople, party[i].get(j));
            }
        }

        for(int i = 0; i < m; i++){

            boolean isPossible = true;
            int cur = party[i].get(0);

            for(int j = 0; j < trueP.length; j++){
                if(find(cur) == find(trueP[j])){
                    isPossible = false;
                    break;
                }
            }
            if(isPossible) result++;
        }
        System.out.println(result);
    }

    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        if( a != b){
            parent[b] = a;
        }
    }

    public static int find(int a){
        if( a == parent[a])
            return a;
        else
            return parent[a] = find(parent[a]);
    }
}