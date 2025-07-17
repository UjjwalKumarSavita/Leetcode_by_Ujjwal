// https://leetcode.com/problems/maximum-matching-of-players-with-trainers/description/

import java.util.*;
class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int n = players.length;
        int m = trainers.length;

        int i = 0; // player 
        int j = 0; // trainers

        int count = 0; // count of matching
        while (i < n && j < m) {
            if (players[i] <= trainers[j]) {
                count++;
                i++;
                j++;
            } else if (trainers[j] < players[i]) {
                j++;
            }
        }
        return count;
    }
}