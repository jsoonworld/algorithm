package intro.sort;

import java.io.*;

public class P10989_수정렬하기3{

    public static int[] a;
    public static long result;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        a = new int[n];

        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(br.readLine());
        }

        br.close();
        radix_sort(a, 5);

        for(int i = 0; i < n; i++){
            bw.write(a[i] + "\n");
        }

        bw.flush();
        bw.close();
    }

    public static void radix_sort(int[] a, int max_size){

        int[] output = new int[a.length];
        int jarisu =1;
        int count = 0;

        while(count != max_size){

            int[] bucket = new int[10];

            for(int i =0; i < a.length; i++){
                bucket[ ( a[i] / jarisu ) % 10 ]++;
            }

            for(int i = 1; i < 10; i++){
                bucket[i] += bucket[i - 1];
            }

            for(int i = a.length -1; i >= 0; i--){
                output[ bucket[ (a[i] / jarisu % 10) ] -1] = a[i];
                bucket[ ( a[i] / jarisu) % 10]--;
            }

            for(int i = 0; i < a.length; i++){
                a[i] = output[i];
            }

            jarisu = jarisu * 10;
            count++;
        }
    }
}