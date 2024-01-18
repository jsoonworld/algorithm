package DS.numberTheory.primenumber;

import java.util.*;

public class P1016_제곱이아닌수{
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        long min = sc. nextLong();
        long max = sc. nextLong();
        // 최댓값괴 최솟값의 차이만큼 배열 선언하기
        boolean[] check = new boolean[(int)(max-min+1)];
        // 2의 제곱수인 4부터 max보다 작거나 같은 값까지 반복하기

        for(long i = 2; i * i <=max; i++){
            long pow = i*i;
            long start_index = min / pow;
            if(min % pow != 0){
                start_index++;
            }
            for(long j = start_index; pow*j <= max; j++){
                check[(int)((j*pow) - min)] = true;
            }
        }
        int count = 0;
        for(int i = 0; i <= max - min; i++){
            if(!check[i]){
                count++;
            }
        }
        System.out.println(count);
    }
}