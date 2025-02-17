class Solution {
    public int solution(String name) {
        int answer = 0;
        char[] nameArr = name.toCharArray();
        int index = 0;
        int length = nameArr.length;
        int move = length - 1;
        
        for (int i = 0; i < length; i++) {
            answer += Math.min(nameArr[i] - 'A', 'Z' - nameArr[i] + 1);
            index = i + 1;
            while(index < length && nameArr[index] == 'A'){
                index++;
            }

            move = Math.min(move, i * 2 + length - index);
            move = Math.min(move, (length - index) * 2 + i);
        }

        return answer + move;
    }
}