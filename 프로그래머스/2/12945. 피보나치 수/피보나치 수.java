class Solution {
    public int solution(int n) {
        long[] fiv = new long[n + 1];
        fiv[0] = 0; fiv[1] = 1;
        for (int i = 2; i <= n; i++) {
            fiv[i] = (fiv[i - 1] + fiv[i - 2]) % 1234567;
        }
        return (int) fiv[n];
    }
}