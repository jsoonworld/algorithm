package org.algorithm.inflearn.map.p4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EveryAnagram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        String t = sc.next();

        System.out.println(countAnagrams(s, t));

        sc.close();
    }

    public static int countAnagrams(String s, String t) {
        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();

        int tLen = t.length();
        int sLen = s.length();

        // 1. T 문자열의 빈도수 맵 생성
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        // 2. S 문자열의 초기 윈도우 크기(T의 길이 - 1)까지 맵 생성
        for (int i = 0; i < tLen - 1; i++) {
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        int count = 0;

        // 3. 슬라이딩 윈도우 탐색
        for (int right = tLen - 1, left = 0; right < sLen; right++, left++) {
            // 현재 윈도우에 들어오는 문자 추가
            sMap.put(s.charAt(right), sMap.getOrDefault(s.charAt(right), 0) + 1);

            // 현재 윈도우와 T의 빈도수 비교
            if (compareMaps(sMap, tMap)) {
                count++;
            }

            // 현재 윈도우에서 나가는 문자 제거
            char outgoing = s.charAt(left);
            sMap.put(outgoing, sMap.get(outgoing) - 1);
            if (sMap.get(outgoing) == 0) {
                sMap.remove(outgoing); // 빈도수가 0인 문자는 제거
            }
        }

        return count;
    }

    // 두 맵이 동일한지 비교
    private static boolean compareMaps(Map<Character, Integer> map1, Map<Character, Integer> map2) {
        if (map1.size() != map2.size()) {
            return false;
        }
        for (char key : map1.keySet()) {
            if (!map2.containsKey(key) || !map1.get(key).equals(map2.get(key))) {
                return false;
            }
        }
        return true;
    }
}
