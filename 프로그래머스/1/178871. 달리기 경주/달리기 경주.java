import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        Map<String, Integer> orders = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            orders.put(players[i], i);
        }
        for (String calling : callings) {
            int winnerIdx = orders.get(calling);
            int loserIdx = winnerIdx - 1;
            String winner = calling;
            String loser = players[loserIdx];
            players[winnerIdx - 1] = winner;
            players[loserIdx + 1] = loser;
            orders.put(winner, winnerIdx-1);
            orders.put(loser, loserIdx+1);
        }
        answer = players;
        return answer;
    }
}