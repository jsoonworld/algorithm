package DS;
import java.util.*;
import java.io.*;

public class P1253_좋은수 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int result = 0;
        long A[] = new long[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i = 0; i <N; i++){
            A[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(A);
        for(int k = 0; k <N; k++){
            long find = A[k];
            int i = 0;
            int j = N-1;
            while( i < j){
                if(A[i] + A[j] == find){
                    if( i != k && j !=k ){
                        result++;
                        break;
                    } else if( i == k){
                        i++;
                    } else if (j == k){
                        j--;
                    }
                } else if(A[i] + A[j] < find) {
                    i++;
                } else{
                    j--;
                }
            }
        }
        System.out.println(result);
        bf.close();

    }

}
