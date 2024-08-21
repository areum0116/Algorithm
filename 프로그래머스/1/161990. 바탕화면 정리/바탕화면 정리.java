class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = {};
        int lux = 999, luy = 999;
        int rdx = -1, rdy = -1;

        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[i].length(); j++) {
                if(wallpaper[i].charAt(j) == '#') {
                    lux = Math.min(lux, i);
                    luy = Math.min(luy, j);
                    rdx = Math.max(rdx, i);
                    rdy = Math.max(rdy, j);
                }
            }
        }
        answer = new int[]{lux, luy, ++rdx, ++rdy};
        return answer;
    }
}