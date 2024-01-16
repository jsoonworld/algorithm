package DS.greedy;

import java.util.*;

public class P11047_동전개수의_최솟값구하기{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] A = new int[n];

        for(int i = 0; i < n; i++){
            A[i] = sc.nextInt();
        }
        int count = 0;
        for(int i = n-1; i>=0; i--){
            if(A[i] <= k){
                count += (k / A[i]);
                k = k % A[i];
            }
        }
        System.out.println(count);
    }
}