class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        long count = 1;
        int idx = 0;
        while (count <= n) {
            answer[idx++] = x * count++;
        }
        return answer;
    }
}