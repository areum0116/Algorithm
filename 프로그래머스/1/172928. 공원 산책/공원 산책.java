import java.util.*;
class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = {};
        char[][] parkArr = new char[park.length][park[0].length()];
        int curX = 0;
        int curY = 0;
        for (int i = 0; i < park.length; i++) {
            parkArr[i] = park[i].toCharArray();
            if(park[i].indexOf('S') != -1) {
                curX = i;
                curY = park[i].indexOf('S');
            }
        }
        for (String route : routes) {
            char op = route.charAt(0);
            int n = route.charAt(2) - '0';
            int tmpX = curX, tmpY = curY;
            for(int i = 0; i < n; i++) {
                switch (op){
                    case 'N' -> curX--;
                    case 'E' -> curY++;
                    case 'S' -> curX++;
                    case 'W' -> curY--;
                }
                if((curX < 0 || curX >= park.length || curY < 0 || curY >= park[0].length()) || parkArr[curX][curY] == 'X') {
                    curX = tmpX;
                    curY = tmpY;
                    break;
                }
            }
        }
        answer = new int[]{curX, curY};
        return answer;
    }
}