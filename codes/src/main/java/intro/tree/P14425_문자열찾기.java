package intro.tree;

import java.util.Scanner;

public class P14425_문자열찾기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        tNode root = new tNode();

        // 단어 삽입 부분
        for (int j = 0; j < n; j++) {
            String text = sc.next();
            tNode now = root;
            for (int i = 0; i < text.length(); i++) {
                char c = text.charAt(i);
                if (now.next[c - 'a'] == null) {
                    now.next[c - 'a'] = new tNode();
                }
                now = now.next[c - 'a'];
            }
            now.isEnd = true; // 단어의 끝을 표시
        }

        int count = 0;

        // 문자열 검색 부분
        for (int j = 0; j < m; j++) {
            String text = sc.next();
            tNode now = root;
            boolean isMatch = true;
            for (int i = 0; i < text.length(); i++) {
                char c = text.charAt(i);
                if (now.next[c - 'a'] == null) {
                    isMatch = false;
                    break;
                }
                now = now.next[c - 'a'];
            }
            if (isMatch && now.isEnd) {
                count++;
            }
        }

        System.out.println(count);
    }
}

class tNode {
    tNode[] next = new tNode[26];
    boolean isEnd;
}
