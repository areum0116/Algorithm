class Solution {
    public int[] solution(int brown, int yellow) {
        int h = 3;
        int w;

        int area = brown + yellow;
        while(true) {
            if(area % h == 0) {
                w = area / h;
                if((h - 2) * (w - 2) == yellow)
                    return new int[] {w, h};
            }
            h++;
        }
    }
}

