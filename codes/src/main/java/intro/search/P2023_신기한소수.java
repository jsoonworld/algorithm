package intro.search;
import java.util.*;

public class P2023_신기한소수{

    static int n ;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        DFS(2, 1);
        DFS(3, 1);
        DFS(5, 1);
        DFS(7, 1);
    }
    static void DFS(int number, int digit){
        if(digit == n){
            if(isPrime(number)){
                System.out.println(number);
            }
            return;
        }
        for(int i = 1; i < 10; i++){
            if( i % 2 == 0){
                continue;
            }
            if(isPrime(number * 10 + i)){
                DFS(number * 10 + i, digit +1);
            }
        }
    }
    static boolean isPrime(int num){
        for(int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;

    }
}

