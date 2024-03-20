package com.example.systemdesign;

import java.util.*;

public class GameLeaderBoard1 {
    private Map<Integer, Integer> scores;

    public GameLeaderBoard1() {
        scores = new HashMap<>();
    }

    public void addScore(int playerId, int score) { // Time Complexity: O(1)
        // if the player is not already present, initialize
        // the player's score to 0
        if (!scores.containsKey(playerId)) { // O(1)
            scores.put(playerId, 0); // O(1)
        }
        // add the given score to the current score of the player
        scores.put(playerId, scores.get(playerId) + score); // O(1)
    }

    public int top(int K) { // Time Complexity: O(NlogN) + O(K) = O(NlogN) where N = total number of players
        // we have all the scores in our hash map.  how do we get the top K scores ?
        // Simple. sort all the values contained in the map and return the
        // max K elements from the sorted scores.
        // We would sort in descending order and grab the first K entries
        List<Integer> values = new ArrayList<Integer>(scores.values());
        Collections.sort(values, Collections.reverseOrder()); // O(NlogN)

        int sum = 0;
        for (int i = 0; i < K; i++) { // O(K)
            sum += values.get(i);
        }
        return sum;
    }

    public void reset(int playerId) { // Time Complexity: O(1)
        // update score of given player to zero
        scores.put(playerId, 0); // O(1)
    }

    // Space Complexity: O(N), where N = total number  of players. We are keeping scores of all the players in the map.

    public static void main(String[] args) {
        GameLeaderBoard1 leaderboard = new GameLeaderBoard1();
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