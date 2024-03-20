package com.example.systemdesign;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class GameLeaderBoard2 {

    private Map<Integer, Integer> scores;

    public GameLeaderBoard2() {
        scores = new HashMap<>();
    }

    public void addScore(int playerId, int score) {
        if (!scores.containsKey(playerId)) {
            scores.put(playerId, 0);
        }
        scores.put(playerId, scores.get(playerId) + score);
    }

    public int top(int K) {
        // We are taking a min-heap containing values of the hash map.
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);

        for (int score : scores.values()) { // O(N)
            minHeap.offer(score);
            if (minHeap.size() > K) {
                minHeap.poll(); // extract min because we are interested in Top elements
                // O(logK)
            }
        } // Overall time complexity to execute this foreach loop: O(NlogK)

        int sum = 0;
        for (int a : minHeap) { // O(K)
            sum += a;
        }
        return sum;

        // Time complexity: O(K) + O(NlogK) = O(NlogK)
    }


    public void reset(int playerId) { // Time Complexity: O(1)
        // update score of given player to zero
        scores.put(playerId, 0); // O(1)
    }

    /*
    Space Complexity: O(N + K), where N = total number  of players.
    We are keeping scores of all the players in the map.
    O(K) is used by the heap in top(K) method.
    */

    public static void main(String[] args) {
        GameLeaderBoard2 leaderboard = new GameLeaderBoard2();
        leaderboard.addScore(1, 73); // leaderboard = [[1,73]];
        leaderboard.addScore(2, 56); // leaderboard = [[1,73],[2,56]];
        leaderboard.addScore(3, 39); // leaderboard = [[1,73],[2,56],[3,39]];
        leaderboard.addScore(4, 51); // leaderboard = [[1,73],[2,56],[3,39],[4,51]];
        leaderboard.addScore(5, 4); // leaderboard = [[1,73],[2,56],[3,39],[4,51],[5,4]];
        System.out.println(leaderboard.top(1)); // returns 73;
        leaderboard.reset(1); // leaderboard = [[2,56],[3,39],[4,51],[5,4]];
        leaderboard.reset(2); // leaderboard = [[3,39],[4,51],[5,4]];
        leaderboard.addScore(2, 51); // leaderboard = [[2,51],[3,39],[4,51],[5,4]];
        System.out.println(leaderboard.top(3)); // returns 141 = 51 + 51 + 39;
    }

}
