package intro;
import java.util.*;
public class P1546_평균구하기 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int A[] = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        long max = 0;
        long sum = 0;
        for (int i = 0; i < N; i++) {
            if(A[i] > max){
                max = A[i];
            }
            sum+= A[i];
        }
        System.out.print(sum * 100.0 / max / N);
    }
}
