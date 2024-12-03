package org.algorithm.inflearn.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ClassPresidentElection {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String votes = sc.next();

        System.out.println(findClassPresident(votes));
    }

    public static char findClassPresident(String votes) {
        Map<Character, Integer> voteCount = new HashMap<>();

        for (char vote : votes.toCharArray()) {
            voteCount.put(vote, voteCount.getOrDefault(vote, 0) + 1);
        }

        char elected = ' ';
        int maxVote = 0;

        for (char candiate : voteCount.keySet()) {
            if (voteCount.get(candiate) > maxVote) {
                maxVote = voteCount.get(candiate);
                elected = candiate;
            }
        }
        return elected;
    }
}
