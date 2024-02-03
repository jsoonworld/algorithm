package intro.greedy;

import java.util.*;

public class P1744_수묶기{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        PriorityQueue<Integer> plusPq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minusPq = new PriorityQueue<>();
        int one = 0;
        int zero = 0;

        for(int i = 0; i < n; i++){
            int data = sc.nextInt();
            if(data > 1){
                plusPq.add(data);
            } else if(data ==1){
                one++;
            } else if(data == 0){
                zero++;
            } else{
                minusPq.add(data);
            }
        }

        int sum = 0;

        while(plusPq.size() > 1){
            int first = plusPq.remove();
            int second = plusPq.remove();
            sum = sum + first * second;
        }

        if(!plusPq.isEmpty()){
            sum = sum + plusPq.remove();
        }

        while(minusPq.size() > 1){
            int first = minusPq.remove();
            int second = minusPq.remove();
            sum = sum + first * second;
        }

        if(!minusPq.isEmpty()){
            if(zero == 0){
                sum = sum + minusPq.remove();
            }
        }

        sum = sum + one;
        System.out.println(sum);
    }
}
