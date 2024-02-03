package intro;


import java.util.*;
public class P2164_카드게임{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();
        int n = sc.nextInt();
        for(int i = 1; i <= n; i++){ // 카드를 큐에 저장하기
            queue.add(i);
        }
        while(queue.size() > 1){
            queue.poll();
            queue.add(queue.poll());
        }
        System.out.println(queue.poll()); // 마지막으로 남은 카드 출력
    }
}