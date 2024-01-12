package DS;

import java.util.*;
import java.io.*;

public class P11286_절댓값힙{
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            int first_adb = Math.abs(o1);
            int second_abs = Math.abs(o2);
            if(first_adb == second_abs){
                return o1 > o2 ? 1 : -1;
            }
            else{
                return first_adb - second_abs;
            }

        });
        for(int i = 0; i < n; i++){
            int request = Integer.parseInt(bf.readLine());
            if(request == 0 ){
                if( queue.isEmpty()){
                    System.out.println("0");
                } else{
                    System.out.println(queue.poll());
                }

            } else{
                queue.add(request);
            }
        }
    }
}