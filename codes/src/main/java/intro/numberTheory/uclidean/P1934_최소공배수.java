package intro.numberTheory.uclidean;

import java.io.*;
import java.util.Scanner;

public class P1934_최소공배수{

    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int i = 0; i < t; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int result = a * b / gcd(a, b);
            System.out.println(result);
        }
    }

    public static int gcd(int a, int b){
        if(b==0){
            return a;
        } else{
            return gcd(b, a%b);
        }
    }
}