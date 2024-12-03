package org.algorithm.inflearn.map.p2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Anagram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();

        System.out.println(isAnagram(str1, str2) ? "YES" : " NO");

    }

    public static boolean isAnagram(String str1, String str2) {

        if (str1.length() != str2.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (char ch : str1.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (char ch : str2.toCharArray()) {
            if (!map.containsKey(ch)) {
                return false;
            }

            map.put(ch, map.get(ch) - 1);
            if (map.get(ch) == 0) {
                map.remove(ch);
            }
        }

        return map.isEmpty();
    }
}
