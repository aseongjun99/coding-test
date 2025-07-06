import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        String[] str = Long.toString(n).split("");
        Arrays.sort(str);
        for (int i=0;i<str.length;i++) {
            answer += Long.parseLong(str[i]) * Math.pow(10, i);
        }
        return answer;
    }
}