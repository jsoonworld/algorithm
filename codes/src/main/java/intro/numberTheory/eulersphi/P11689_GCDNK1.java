package intro.numberTheory.eulersphi;

import java.io.*;

public class P11689_GCDNK1{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long result  = n;
        for(long p =2; p <= Math.sqrt(n); p++){
            if( n % p == 0){
                result = result - result/p;
                while(n % p == 0){
                    n /= p;
                }
            }
        }
        if( n > 1){
            result = result - result /n;
        }
        System.out.println(result);
    }

}