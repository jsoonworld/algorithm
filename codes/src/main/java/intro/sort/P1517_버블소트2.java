package intro.sort;

import java.util.*;
import java.io.*;

public class P1517_버블소트2{

    public static int[] a, temp;
    public static long result;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        a = new int[n + 1];
        temp = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        result = 0;
        merge_sort(1, n);
        System.out.println(result);
    }

    private static void merge_sort(int s, int e){
        if(e - s < 1){
            return;
        }
        int m = s + (e -s )/2;
        merge_sort(s, m);
        merge_sort(m+1, e);

        for(int i = s; i <=e; i++){
            temp[i] = a[i];
        }

        int k = s;
        int index1= s;
        int index2 = m+1;

        while(index1<=m && index2 <= e){
            if(temp[index1] > temp[index2]){
                a[k] = temp[index2];
                result = result + index2 - k;
                k++;
                index2++;
            } else{
                a[k] = temp[index1];
                k++;
                index1++;
            }
        }

        while(index1 <= m){
            a[k] = temp[index1];
            k++;
            index1++;
        }
        while(index2 <= e){
            a[k] = temp[index2];
            k++;
            index2++;
        }
    }
}