class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int maxW = 0;
        int maxH = 0;
        for (int i = 0; i < sizes.length; i++) {
            if(sizes[i][0] < sizes[i][1]) swap(sizes[i]);
            if(sizes[i][0] > maxW) maxW = sizes[i][0];
            if(sizes[i][1] > maxH) maxH = sizes[i][1];
        }
        answer = maxW * maxH;
        return answer;
    }
    static void swap(int[] arr) {
        int tmp = arr[0];
        arr[0] = arr[1];
        arr[1] = tmp;
    }
}